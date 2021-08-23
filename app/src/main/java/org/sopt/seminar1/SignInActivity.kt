package org.sopt.seminar1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import org.sopt.seminar1.databinding.ActivitySignInBinding
import androidx.activity.result.contract.ActivityResultContracts
import org.sopt.seminar1.api.ServiceCreator
import org.sopt.seminar1.data.SoptUserAuthStorage
import org.sopt.seminar1.data.request.RequestLoginData
import org.sopt.seminar1.data.response.ResponseLoginData
import org.sopt.seminar1.utils.showToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding

    private val signUpActivityLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
    ){
        binding.loginIdInput.setText(it.data?.getStringExtra("id"))
        binding.loginPwInput.setText(it.data?.getStringExtra("password"))
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d("Life Cycle", "SignIn_onStart")
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        searchUserAuthStorage()
        setButtonEvent()
    }

    private fun searchUserAuthStorage() {
        //UserAuthStorage에 데이터가 있다면,
        if(!SoptUserAuthStorage.hasUserData(this)) {
            with(binding) {
                SoptUserAuthStorage.saveUserId(this@SignInActivity,loginIdInput.text.toString())
                SoptUserAuthStorage.saveUserPw(this@SignInActivity,loginPwInput.text.toString())
            }
        }
        else startHomeActivity()
    }

    private fun setButtonEvent() {
        with(binding) {
            loginBtn.setOnClickListener{ loginBtnClickEvent() }
            signupText.setOnClickListener{ startSignUpForResult() }
        }
    }

    private fun loginBtnClickEvent(){
        val requestLoginData = RequestLoginData(
                id = binding.loginPwInput.text.toString(),
                password = binding.loginPwInput.text.toString()
        )
        requestLogin(requestLoginData)
        showToast("안녕")
    }

    private fun requestLogin(requestLoginData: RequestLoginData) {
        val userId = binding.loginIdInput.text
        val userPw = binding.loginPwInput.text

        if(userId.isNullOrBlank() && userPw.isNullOrBlank()) {
            showToast("아이디/비밀번호를 확인해주세요!")

        } else{

            val call : Call<ResponseLoginData> = ServiceCreator.spotServiece
                    .postLogin(requestLoginData)

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
        }
    }

    private fun startHomeActivity(){
        startActivity(
                Intent(this, HomeActivity::class.java)
        )
        finish()
    }

    private fun startSignUpForResult() {
        signUpActivityLauncher.launch(
                Intent(this, SignUpActivity::class.java)
        )
    }

    override fun onStart() {
        super.onStart()
        Log.d("Life Cycle", "SignIn_onStart 호출")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Life Cycle", "SignIn_onRestart 호출")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Life Cycle", "SignIn_onResume 호출")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Life Cycle", "SignIn_onPause 호출")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Life Cycle", "SignIn_onStop 호출")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Life Cycle", "SignIn_onDestroy 호출")
    }


}