package org.sopt.seminar1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.sopt.seminar1.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d("Life Cycle", "Home_onStart")
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initButtonClickEvent()
        initRepoAdapter()

    }


    private fun initButtonClickEvent(){
        binding.homeMoreBtn.setOnClickListener{
            Toast.makeText(this, "more버튼 클릭", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,UserInfoActivity::class.java))
        }
    }

    private fun initRepoAdapter(){
        val repositoryListAdapter = RepositoryListAdapter()
        binding.repositoryRecyclerList.adapter = repositoryListAdapter
        repositoryListAdapter.repositoryList.addAll(
            listOf<RepositoryInfo>(
                    RepositoryInfo(
                            "첫 번째 레파지토리",
                            "설명이 길어지면 말 줄임표를 사용합니다설명이 길어지면 말 줄임표를 사용합니다설명이 길어지면 말 줄임표를 사용합니다",
                            "java"
                    ),
                    RepositoryInfo(
                             "두 번째 레파지토리 두번째 레파지토리 두번째 레파지토리 두번째 레파지토리",
                            "정보",
                            "kt"
                    ),
                    RepositoryInfo(
                            "세 번째 레파지토리",
                            "설명이 길어지면 말 줄임표를 사용합니다설명이 길어지면 말 줄임표를 사용합니다설명이 길어지면 말 줄임표를 사용합니다",
                            "java"
                    ),
                    RepositoryInfo(
                            "네 번째 레파지토리",
                            "설명이 길어지면 말 줄임표를 사용합니다설명이 길어지면 말 줄임표를 사용합니다설명이 길어지면 말 줄임표를 사용합니다",
                            "java"
                    ),
                    RepositoryInfo(
                            "마지막 레파지토리",
                            "설명이 길어지면 말 줄임표를 사용합니다설명이 길어지면 말 줄임표를 사용합니다설명이 길어지면 말 줄임표를 사용합니다",
                            "java"
                    )



            )
        )
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