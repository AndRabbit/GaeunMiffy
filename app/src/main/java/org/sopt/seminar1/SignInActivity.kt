package org.sopt.seminar1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import org.sopt.seminar1.databinding.ActivitySignInBinding
import androidx.activity.result.contract.ActivityResultContracts
import org.sopt.seminar1.api.ServiceCreator
import org.sopt.seminar1.data.request.RequestLoginData
import org.sopt.seminar1.data.response.ResponseLoginData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d("Life Cycle", "SignIn_onStart")
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtonClickEvent()

    }


    private fun initButtonClickEvent() {
        binding.loginBtn.setOnClickListener{

            val userId = binding.loginIdInput.text
            val userPw = binding.loginPwInput.text


            if(userId.isNullOrBlank() && userPw.isNullOrBlank()) {
                Toast.makeText(applicationContext, "아이디/비밀번호를 확인해주세요!", Toast.LENGTH_SHORT)
                        .show()
            } else{


                val requestLoginData = RequestLoginData(
                        id = userId.toString(),
                        password = userPw.toString()
                )
                val call : Call<ResponseLoginData> = ServiceCreator.spotServiece
                        .postLogin(requestLoginData)


                call.enqueue(object : Callback<ResponseLoginData> {
                    override fun onResponse(
                            call : Call<ResponseLoginData>,
                            response: Response<ResponseLoginData>
                    ) {
                        if (response.isSuccessful) {
                            val data = response.body()?.data
                            Toast.makeText(this@SignInActivity, data?.user_nickname, Toast.LENGTH_LONG)
                                    .show()
                            startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
                        } else {
                            Toast.makeText(this@SignInActivity, "아이디와 비밀번호를 확인해 주세요", Toast.LENGTH_SHORT)
                                    .show()
                        }

                    }

                    override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
                        Log.d("NetworkTest","error:$t")
                    }
                })
            }
        }


        binding.signupText.setOnClickListener {
            signUpActivityLauncher.launch(Intent(this, SignUpActivity::class.java))

        }
    }




    private val signUpActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){}



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