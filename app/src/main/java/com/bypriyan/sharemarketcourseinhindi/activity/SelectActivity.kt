package com.bypriyan.sharemarketcourseinhindi.activity

import android.content.Intent
import android.media.tv.AdRequest
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.bypriyan.sharemarketcourseinhindi.R
import com.bypriyan.sharemarketcourseinhindi.databinding.ActivitySelectBinding
import com.bypriyan.sharemarketcourseinhindi.utility.NetworkConnection
import com.google.android.gms.ads.MobileAds

class SelectActivity : AppCompatActivity() {

    lateinit var binding: ActivitySelectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MobileAds.initialize(this) {}

        binding.startLearningBtn.setOnClickListener{
            startActivity(Intent(this, TopicsActivity::class.java))
        }


        //back pressed
        onBackPressedDispatcher.addCallback(this, object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                finish()
            }
        })

        binding.marketNewsBtn.setOnClickListener{
            startActivity(Intent(this, NewsActivity::class.java))
        }

        binding.shareBtnBtn.setOnClickListener {
            val shareText = "${getString(R.string.app_name)}\n" +
                    "Download Now\n" +
                    "https://play.google.com/store/apps/details?id=com.bypriyan.sharemarketcourseinhindi"

            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, shareText)
                type = "text/plain"
            }
            startActivity(Intent.createChooser(sendIntent, null))
        }

        binding.disclamerBtn.setOnClickListener{
            startActivity(Intent(this, DisclamerActivity::class.java))
        }

        try {
            var networkConnection  = NetworkConnection(applicationContext)
            networkConnection.observe(this){
                if(it){
                    binding.networkErrorLayout.root.visibility = View.GONE
                }else{
                    binding.networkErrorLayout.root.visibility = View.VISIBLE
                }
            }
        } catch (exception: IllegalArgumentException) {
            //network is already unregistered
        }

        binding.demateAccountOpenBtn.setOnClickListener {
            val url = "https://bit.ly/3eEAMr0"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        loadBanner()

    }

    private fun loadBanner() {

        // Create an ad request.
        val adRequest = com.google.android.gms.ads.AdRequest.Builder().build()

        binding.adView.loadAd(adRequest)
    }

}