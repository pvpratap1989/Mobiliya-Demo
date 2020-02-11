package com.orange.mobiliya.ui.rootScreen

import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.orange.mobiliya.BR
import com.orange.mobiliya.BaseActivity
import com.orange.mobiliya.R
import com.orange.mobiliya.adapters.RepoAdapter
import com.orange.mobiliya.dataModels.UserProfile
import com.orange.mobiliya.dataModels.UserRepos
import com.orange.mobiliya.databinding.ActivityRootBinding

import kotlinx.android.synthetic.main.activity_root.*
import javax.inject.Inject

class RootActivity : BaseActivity<ActivityRootBinding, RootViewModel>(), RootNavigator {

    @Inject
    lateinit var mViewModel: RootViewModel

    var mAdapter: RepoAdapter = RepoAdapter()

    var mLayoutManager: LinearLayoutManager = LinearLayoutManager(this)

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_root

    override val viewModel: RootViewModel
        get() = mViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        centerToolbarText(getString(R.string.app_name_custom))
        mViewModel.setmNavigator(this)
    }

    override fun onUserProficeRecived(userProfile: UserProfile) {
        //Set Image and repo Name
        Glide.with(applicationContext)
            .load(userProfile.avatarUrl)
            .into(userImage);
        userName.setText(userProfile.name)
    }


    override fun onUserRepoReceived(userRepos: List<UserRepos?>) {
        //Display results in recylerview
        reloadRecyclerView(userRepos)
    }

    fun reloadRecyclerView(userRepos: List<UserRepos?>) {
        mAdapter.setCustomContext(applicationContext)
        mLayoutManager.setOrientation(RecyclerView.VERTICAL)
        recylerView.setLayoutManager(mLayoutManager)
        recylerView.setItemAnimator(DefaultItemAnimator())
        mAdapter.setFeedList(userRepos as List<UserRepos>)
        recylerView.setAdapter(mAdapter)
        mAdapter.notifyDataSetChanged()
    }

    override fun onError(error: String) {
        Toast.makeText(applicationContext, "Error", Toast.LENGTH_LONG).show()
    }

    private fun centerToolbarText(title: String) {
        val mTitleTextView = AppCompatTextView(this)
        mTitleTextView.text = title
        mTitleTextView.setSingleLine()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mTitleTextView.setTextColor(getColor(R.color.white))
        }
        mTitleTextView.textSize = 25f
        val layoutParams = ActionBar.LayoutParams(
            ActionBar.LayoutParams.WRAP_CONTENT,
            ActionBar.LayoutParams.WRAP_CONTENT
        )
        layoutParams.gravity = Gravity.CENTER
        supportActionBar?.setCustomView(mTitleTextView, layoutParams)
        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
    }
}
