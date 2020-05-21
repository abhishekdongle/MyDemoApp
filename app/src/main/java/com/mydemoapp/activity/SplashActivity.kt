package com.mydemoapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mydemoapp.R
import com.mydemoapp.model.SplashModel
import com.mydemoapp.base.BaseEvent
import com.mydemoapp.base.EventObserver
import com.mydemoapp.databinding.ActivitySplashBinding
import com.mydemoapp.viewModel.SplashViewModel
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private lateinit var mVieModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        mVieModel = ViewModelProvider(this)[SplashViewModel::class.java]

        mVieModel.eventListener.observe(this@SplashActivity, Observer {
            if (it)
                Toast.makeText(this, "OK", Toast.LENGTH_LONG).show()
        })
        with(mVieModel) {
            modelListener.observe(this@SplashActivity, EventObserver {
                it.let {
                    if (isValid(it.textName!!)) {
                        tvName.setTextColor(resources.getColor(R.color.colorWhite))
                    }
                }
            })


            var obj = SplashModel()
            obj.textName = "Failed"
            mVieModel.modelListener.value = BaseEvent(obj)
            Handler().postDelayed(Runnable {
                mVieModel.eventListener.value = true
            }, 3000)
        }

        with(binding)
        {
            viewModel = mVieModel
        }
    }
}
