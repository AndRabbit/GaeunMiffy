## Lv1-1 Activity 처리

---

searchUserAuthStorage() 메소드를 제작하여

SharedPreference에 등록된 아이디와 비밀번호가 있다면, 바로 홈화면으로 이동하도록 하는

자동로그인을 구현하였다. 

```kotlin
call.enqueue(object : Callback<ResponseLoginData> {
                override fun onResponse(
                        call : Call<ResponseLoginData>,
                        response: Response<ResponseLoginData>
                ) {
                    if (response.isSuccessful) {
                        val data = response.body()?.data
                        //통신 성공 시 유저 닉네임을 보여준다.
                        showToast(data?.user_nickname.toString())

                        if(!SoptUserAuthStorage.hasUserData(this@SignInActivity)) {
                            SoptUserAuthStorage.saveUserId(this@SignInActivity, requestLoginData.id)
                            SoptUserAuthStorage.saveUserPw(this@SignInActivity, requestLoginData.password)
                        }

                        startHomeActivity()

                    } else {
                        showToast("아이디와 비밀번호를 확인해 주세요")
                    }
                }

                override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
                    Log.d("NetworkTest","error:$t")
                }
            })
```

사용자가 로그인에 성공하면 입력한 아이디와 비밀번호를 sharedPreference에 집어 넣는다.

## Lv1-2 SharedPreference 코드 첨부

---

```kotlin
object SoptUserAuthStorage {
    private const val STORAGE_KEY = "user_auth"
    private const val USER_ID_KEY = "user_id"
    private const val USER_PW_KEY = "user_pw"

    fun getUserId(context: Context): String {
        val sharedPreferences = context.getSharedPreferences(
                "${context.packageName}.$STORAGE_KEY",
                Context.MODE_PRIVATE
        )
        return sharedPreferences.getString(USER_ID_KEY, "") ?: ""
    }

    fun getUserPw(context: Context): String {
        val sharedPreferences = context.getSharedPreferences(
                "${context.packageName}.$STORAGE_KEY",
                Context.MODE_PRIVATE
        )
        return sharedPreferences.getString(USER_PW_KEY, "") ?: ""
    }

    fun saveUserId(context: Context, id: String) {
        val sharedPreferences = context.getSharedPreferences(
                "${context.packageName}.$STORAGE_KEY",
                Context.MODE_PRIVATE
        )
        sharedPreferences.edit()
                .putString(USER_ID_KEY, id)
                .apply()
    }

    fun saveUserPw(context: Context, pw: String) {
        val sharedPreferences = context.getSharedPreferences(
                "${context.packageName}.$STORAGE_KEY",
                Context.MODE_PRIVATE
        )
        sharedPreferences.edit()
                .putString(USER_PW_KEY, pw)
                .apply()
    }

    fun clearAuthLogin(context: Context) {
        val sharedPreferences = context.getSharedPreferences(
                "${context.packageName}.$STORAGE_KEY",
                Context.MODE_PRIVATE
        )
        sharedPreferences.edit()
                .clear()
                .apply()
    }

    fun hasUserData(context: Context) : Boolean {
        val sharedPreferences = context.getSharedPreferences(
                "${context.packageName}.$STORAGE_KEY",
                Context.MODE_PRIVATE
        )
        return !sharedPreferences.getString(USER_ID_KEY, "").isNullOrBlank() &&
                !sharedPreferences.getString(USER_PW_KEY, "").isNullOrBlank()
    }
}
```

### 과제를 통해 배운 내용!

---

sharedPreference를 통한 자동로그인을 구현하였다! 확장함수를 통해서 긴 코드를 줄이는 방법을 배우고, 메소드를 생성하여 코드를 정리하는 것과 확장함수를 사용해서 정리하는 방법의 차이와 용도를 (어느정도) 알게 되었다. 과제를 할 수록 클린 코드와 효율적인 코드 작성에 대해서 더 공부하고 싶어진다 !!
