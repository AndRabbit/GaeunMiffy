package org.sopt.seminar1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.sopt.seminar1.databinding.ActivitySignUpBinding

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
                val intent = Intent()
                intent.putExtra("signUpId", signUpId.toString())
                intent.putExtra("signUpPw", signUpPw.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()
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