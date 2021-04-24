package org.sopt.seminar1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.sopt.seminar1.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d("Life Cycle", "Home_onStart")
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }



    override fun onStart() {
        super.onStart()
        Log.d("Life Cycle", "Home_onStart 호출")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Life Cycle", "Home_onRestart 호출")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Life Cycle", "Home_onResume 호출")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Life Cycle", "Home_onPause 호출")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Life Cycle", "Home_onStop 호출")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Life Cycle", "Home_onDestroy 호출")
    }
}