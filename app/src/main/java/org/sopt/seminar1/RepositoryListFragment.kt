package org.sopt.seminar1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.seminar1.databinding.FragmentRepositoryListBinding
import androidx.fragment.app.Fragment


class RepositoryListFragment:Fragment() {

    private var _binding: FragmentRepositoryListBinding? = null
    private val binding get() = _binding ?: error("View를 참조하기 위해 binding이 초기화 되지 않았습니다")



    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRepositoryListBinding.inflate(inflater, container, false)
        return binding.root
    }


    private lateinit var repositoryListAdapter: RepositoryListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        repositoryListAdapter = RepositoryListAdapter()

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

        repositoryListAdapter.notifyDataSetChanged()


    }


    override fun onDestroyView(){
        super.onDestroyView()
        _binding=null
    }
}