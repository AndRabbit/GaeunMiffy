package org.sopt.seminar1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.seminar1.data.FollowingUserInfo
import org.sopt.seminar1.databinding.ItemFollowUserBinding

class FollowingListAdapter : RecyclerView.Adapter<FollowingListAdapter.FollowingUserViewHOlder>() {

    val userList = mutableListOf<FollowingUserInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowingUserViewHOlder {
        val binding = ItemFollowUserBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FollowingUserViewHOlder(binding)
    }

    override fun getItemCount(): Int =userList.size

    override fun onBindViewHolder(holder: FollowingUserViewHOlder, position: Int) {
        holder.onBind(userList[position])
    }


    class FollowingUserViewHOlder(
        private val binding: ItemFollowUserBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun onBind(followingUserInfo: FollowingUserInfo){
            binding.followUserName.text = followingUserInfo.userName
        }
    }
}