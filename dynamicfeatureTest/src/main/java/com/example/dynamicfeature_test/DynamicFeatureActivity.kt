package com.example.dynamicfeature_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.connectmodules.ConnectModulesApp
import com.example.connectmodules.HelperApp
 import kotlinx.android.synthetic.main.activity_dynamic_feature.*
import javax.inject.Inject

class DynamicFeatureActivity : AppCompatActivity() {

//    @Inject
//    lateinit var helper: Helper
    @Inject
    lateinit var helperApp: HelperApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDI()
        setContentView(R.layout.activity_dynamic_feature)

        btn_goToMainActivityModule.setOnClickListener {
            val intent = Intent(this,
                Class.forName("com.example.connectmodules.presentation.MainActivity"))
            startActivity(intent)
        }

//        Log.d("DYNAMICTAG", helper.test())
        Log.d("DYNAMICTAG", helperApp.printHello())
    }

    private fun initDI() {
        DaggerDynamicFeatureComponent
            .builder()
            .appComponent(ConnectModulesApp.appComponent)
            .dynamicFeatureModule(DynamicFeatureModule())
            .build()
            .inject(this)
    }
}
