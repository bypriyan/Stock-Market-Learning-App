package com.bypriyan.sharemarketcourseinhindi.activity

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import coil.load
import com.bypriyan.bustrackingsystem.utility.Constants
import com.bypriyan.sharemarketcourseinhindi.R
import com.bypriyan.sharemarketcourseinhindi.databinding.ActivityNewsBinding
import com.bypriyan.sharemarketcourseinhindi.databinding.ActivityNewsDetailsBinding
import com.bypriyan.sharemarketcourseinhindi.utility.NetworkConnection
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.OnUserEarnedRewardListener
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback

class NewsDetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivityNewsDetailsBinding
    private var rewardedAd: RewardedAd? = null
    private var isShowed:Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var title = intent.getStringExtra(Constants.KEY_NEWS_TITLE)

        binding.newsImg.load(intent.getStringExtra(Constants.KEY_NEWS_IMG)){
            crossfade(true)
            placeholder(R.drawable.logo)
        }

        binding.newsTitleAppBar.text = title?.substring(0,27)+"..."
        binding.newsTitleTv.text = title
        binding.newsDateTv.text =
            intent.getStringExtra(Constants.KEY_NEWS_DATE)?.split("T")?.get(0) ?: "Waiting.."


        binding.descriptionTv.text =  intent.getStringExtra(Constants.KEY_NEWS_DESCRIPTION)

        binding.contentTv.text =  intent.getStringExtra(Constants.KEY_NEWS_CONTENT)

//        binding.backBtn.setOnClickListener{
//            // load ad
//            if(!isShowed){
//                rewardedAd?.let { ad ->
//                    ad.show(this, OnUserEarnedRewardListener { rewardItem ->
//                        onBackPressedDispatcher.onBackPressed()
//                        isShowed= true
//                    })
//                } ?: run {
//                    onBackPressedDispatcher.onBackPressed()
//                    isShowed = true
//                }
//            }else{
//                onBackPressedDispatcher
//            }
//
//
//        }
//        //back pressed
//        onBackPressedDispatcher.addCallback(this, object: OnBackPressedCallback(true) {
//            override fun handleOnBackPressed() {
//
//                if(!isShowed){
//                    //load ad
//                    rewardedAd?.let { ad ->
//                        ad.show(this@NewsDetailsActivity, OnUserEarnedRewardListener { rewardItem ->
//                            isShowed = true
//                            finish()
//                        })
//                    } ?: run {
//                        isShowed = true
//                        finish()
//                    }
//                }else{
//                    finish()
//                }
//
//            }
//        })

        binding.backBtn.setOnClickListener{
            onBackPressedDispatcher.onBackPressed()
        }

        //back pressed
        onBackPressedDispatcher.addCallback(this, object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                finish()
            }
        })

        //
        var adRequest = AdRequest.Builder().build()
        RewardedAd.load(this,"ca-app-pub-3940256099942544/5224354917", adRequest, object : RewardedAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {

                rewardedAd = null
            }

            override fun onAdLoaded(ad: RewardedAd) {
                rewardedAd = ad
            }
        })

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

        loadBanner()

    }

    private fun loadBanner() {

        // Create an ad request.
        val adRequest = com.google.android.gms.ads.AdRequest.Builder().build()

        binding.adView.loadAd(adRequest)
    }
}