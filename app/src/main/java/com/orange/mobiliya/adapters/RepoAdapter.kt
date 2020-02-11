package com.orange.mobiliya.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orange.mobiliya.BaseViewHolder
import com.orange.mobiliya.dataModels.UserRepos
import com.orange.mobiliya.databinding.ItemRepoBinding

class RepoAdapter : RecyclerView.Adapter<BaseViewHolder>() {

    var userRepos: List<UserRepos>? = null
    var customContextVar: Context? = null

    override fun getItemViewType(position: Int): Int {
        if (userRepos == null)
            return VIEW_TYPE_NORMAL

        if (userRepos!!.size == 0)
            return VIEW_TYPE_NORMAL

        return VIEW_TYPE_NORMAL
    }


    fun setFeedList(userRepos: List<UserRepos>) {
        this.userRepos = userRepos;
    }

    fun setCustomContext(context: Context) {
        this.customContextVar = context;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {

        val mBinding: ItemRepoBinding = ItemRepoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return RepoViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int {
        if (userRepos != null) {
            return userRepos?.size!!
        } else {
            return 0
        }
    }

    inner class RepoViewHolder(binding: ItemRepoBinding) : BaseViewHolder(binding.card) {
        var bi = binding
        override fun onBind(position: Int) {
            userRepos.let {
                bi.repoName.setText(it?.get(position)?.name)
                bi.repoDesc.setText(it?.get(position)?.description)
            }
        }
    }


    companion object {
        const val VIEW_TYPE_NORMAL = 1
        const val VIEW_TYPE_EMPTY = 2
    }
}
