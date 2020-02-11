package com.orange.mobiliya.ui.splashScreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.orange.mobiliya.BR
import com.orange.mobiliya.BaseActivity
import com.orange.mobiliya.R
import com.orange.mobiliya.databinding.ActivitySplashScreenBinding
import com.orange.mobiliya.ui.rootScreen.RootActivity

class SplashScreen : BaseActivity<ActivitySplashScreenBinding, SplashViewModel>(), SplashNavigator {

    var mSpalshViewModel = SplashViewModel()

    override val bindingVariable: Int
        get() = BR.viewModel

    override val viewModel: SplashViewModel
        get() = mSpalshViewModel

    override val layoutId: Int
        get() = R.layout.activity_splash_screen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        Handler().postDelayed({
            var intent = Intent(applicationContext, RootActivity::class.java)
            startActivity(intent)
        }, 5000)

    }
}
