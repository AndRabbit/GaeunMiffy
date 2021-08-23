package org.sopt.seminar1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.seminar1.data.RepositoryInfo
import org.sopt.seminar1.databinding.ItemRepositoryBinding

class RepositoryListAdapter: RecyclerView.Adapter<RepositoryListAdapter.RepositoryListViewHolder>() {

    val repositoryList = mutableListOf<RepositoryInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryListViewHolder {
        val binding = ItemRepositoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        )
        return RepositoryListViewHolder(binding)
    }

    override fun getItemCount(): Int =repositoryList.size

    override fun onBindViewHolder(holder: RepositoryListViewHolder, position: Int) {
        holder.onBind(repositoryList[position])
    }


    class RepositoryListViewHolder(
            private val binding: ItemRepositoryBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun onBind(repositoryInfo: RepositoryInfo){
            binding.repositoryNameText.text = repositoryInfo.repoName
            binding.repositoryInfoText.text = repositoryInfo.repoInfo
            binding.repositoryLangText.text = repositoryInfo.repoLang

        }
    }

}