package org.sopt.seminar1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.sopt.seminar1.api.ServiceCreator
import org.sopt.seminar1.data.request.RequestJoinData
import org.sopt.seminar1.data.request.RequestLoginData
import org.sopt.seminar1.data.response.ResponseJoinData
import org.sopt.seminar1.data.response.ResponseLoginData
import org.sopt.seminar1.databinding.ActivitySignUpBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d("Life Cycle", "SignUp_onStart")
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtonClickEvent()

    }


    private fun initButtonClickEvent() {
        binding.signupBtn.setOnClickListener{

            val signUpId = binding.signupIdInput.text
            val signUpPw = binding.signupPwInput.text
            val signUpName = binding.signupNameInput.text
            //val signUpToSignInIntent = Intent(this, SignInActivity::class.java)

            if(signUpId.isNullOrBlank() || signUpPw.isNullOrBlank() || signUpName.isNullOrBlank()) {
                Toast.makeText(applicationContext, "빈 칸이 있는 지 확인해주세요!", Toast.LENGTH_SHORT)
                    .show()
            } else{


                val requestJoinData = RequestJoinData(
                        email = signUpId.toString(),
                        password = signUpPw.toString(),
                        nickname = signUpName.toString(),
                        sex = "0",
                        phone = "01000000000",
                        birth = "0"
                )
                val call : Call<ResponseJoinData> = ServiceCreator.spotServiece
                        .postJoin(requestJoinData)

                call.enqueue(object : Callback<ResponseJoinData> {
                    override fun onResponse(
                            call : Call<ResponseJoinData>,
                            response: Response<ResponseJoinData>
                    ) {
                        if (response.isSuccessful) {
                            val data = response.body()?.data
                            Toast.makeText(this@SignUpActivity, data?.nickname, Toast.LENGTH_SHORT)
                                    .show()
                            startSignInActivity()
                        } else {
                            Toast.makeText(this@SignUpActivity, "잠시 후 다시 시도해주세요", Toast.LENGTH_SHORT)
                                    .show()
                        }

                    }

                    private fun startSignInActivity(){
                        val intent = Intent()
                        intent.putExtra("signUpId", signUpId.toString())
                        intent.putExtra("signUpPw", signUpPw.toString())
                        setResult(Activity.RESULT_OK, intent)
                        finish()
                    }

                    override fun onFailure(call: Call<ResponseJoinData>, t: Throwable) {
                        Log.d("NetworkTest","error:$t")
                    }
                })
            }
        }
    }


    override fun onStart() {
        super.onStart()
        Log.d("Life Cycle", "SignUp_onStart 호출")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Life Cycle", "SignUp_onRestart 호출")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Life Cycle", "SignUp_onResume 호출")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Life Cycle", "SignUp_onPause 호출")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Life Cycle", "SignUp_onStop 호출")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Life Cycle", "SignUp_onDestroy 호출")
    }
}