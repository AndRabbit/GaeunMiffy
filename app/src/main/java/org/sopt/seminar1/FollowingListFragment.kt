package org.sopt.seminar1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.sopt.seminar1.databinding.FragmentFollowingListBinding

class FollowingListFragment:Fragment() {

    private var _binding: FragmentFollowingListBinding? = null
    private val binding get() = _binding ?: error("View를 참조하기 위해 binding이 초기화 되지 않았습니다")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowingListBinding.inflate(inflater,container, false)
        return binding.root
    }


    private lateinit var followingListAdapter: FollowingListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        followingListAdapter = FollowingListAdapter()

        binding.userList.adapter = followingListAdapter

        followingListAdapter.userList.addAll(
            listOf<FollowingUserInfo>(
                FollowingUserInfo(
                    userImage ="빈칸",
                    userName = "pserson1"
                ),
                FollowingUserInfo(
                    userImage ="빈칸",
                    userName = "pserson2"
                ),
                FollowingUserInfo(
                    userImage ="빈칸",
                    userName = "pserson3"
                ),
                FollowingUserInfo(
                    userImage ="빈칸",
                    userName = "pserson4"
                )
            )
        )

        followingListAdapter.notifyDataSetChanged()
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}