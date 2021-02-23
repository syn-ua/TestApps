package com.test.testapp.ui.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.test.testapp.R
import com.test.testapp.ui.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}