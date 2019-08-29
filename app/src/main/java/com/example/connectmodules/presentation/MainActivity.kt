package com.example.connectmodules.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.connectmodules.R
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainActivityRouter: MainActivityRouter

    @Inject
    lateinit var splitInstallManager: SplitInstallManager

    private var mySessionId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_connectModule.setOnClickListener {
//            mainActivityRouter.goToTestActivityPage()

            val request = SplitInstallRequest
                .newBuilder()
                .addModule("dynamicfeatureTest")
                .build()

//            val splitInstallManager = SplitInstallManagerFactory.create(this)

            // Starting Module Installation
            splitInstallManager.startInstall(request)
                .addOnSuccessListener {
                    mySessionId = it
                }
                .addOnFailureListener {

                }

            if (splitInstallManager.installedModules.contains("dynamicfeatureTest")) {
                // Module is installed
                Log.d("Tutorial","Module Installed")
//                val intent = Intent().setClassName(
//                    "com.example.connectmodules",
//                    "com.example.dynamicfeature_test.DynamicFeatureActivity"
//                )
                //                val intent = Intent().setClassName(
//                    "com.example.connectmodules",
//                    "com.example.dynamicfeatureTest.DynamicFeatureActivity"
//                )
                val intent = Intent(this,
                    Class.forName("com.example.dynamicfeature_test.DynamicFeatureActivity"))
                startActivity(intent)
            } else {
                Log.d("Tutorial","Module isn't Installed")
            }
        }
    }
}
