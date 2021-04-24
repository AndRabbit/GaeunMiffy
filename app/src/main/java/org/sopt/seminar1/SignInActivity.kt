package org.sopt.seminar1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import org.sopt.seminar1.databinding.ActivitySignInBinding
import androidx.activity.result.contract.ActivityResultContracts


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
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, HomeActivity::class.java))
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