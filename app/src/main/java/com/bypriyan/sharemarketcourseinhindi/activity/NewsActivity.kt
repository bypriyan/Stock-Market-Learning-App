package com.bypriyan.sharemarketcourseinhindi.activity

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnScrollChangeListener
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bypriyan.sharemarketcourseinhindi.R
import com.bypriyan.sharemarketcourseinhindi.adapter.AdapterNews
import com.bypriyan.sharemarketcourseinhindi.adapter.AdapterTopics
import com.bypriyan.sharemarketcourseinhindi.api.NewsService
import com.bypriyan.sharemarketcourseinhindi.databinding.ActivityNewsBinding
import com.bypriyan.sharemarketcourseinhindi.databinding.ActivityTopicsBinding
import com.bypriyan.sharemarketcourseinhindi.model.ModelArticelResponce
import com.bypriyan.sharemarketcourseinhindi.utility.NetworkConnection
import com.bypriyan.sharemarketcourseinhindi.viewModel.NewsViewModel
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.OnUserEarnedRewardListener
import com.google.android.gms.ads.admanager.AdManagerAdRequest
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsActivity : AppCompatActivity() {

    lateinit var binding: ActivityNewsBinding
    private lateinit var newsViewModel: NewsViewModel
    private var rewardedAd: RewardedAd? = null
    private var isShowed:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        newsViewModel = ViewModelProvider(this)[NewsViewModel::class.java]
        newsViewModel.getNews(1, 30)

        isLoading(true)

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
//                        ad.show(this@NewsActivity, OnUserEarnedRewardListener { rewardItem ->
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

        newsViewModel.newsList.observe(this, Observer{
            if(it.size!=0){
                isLoading(false)
                Log.d("TAG", "onCreate: list size ${it.size}")
                binding.newsRv.adapter = AdapterNews(this, it)
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


    fun isLoading(loading:Boolean){
        if(loading){
            binding.progressbar.visibility= View.VISIBLE
        }else{
            binding.progressbar.visibility= View.GONE
        }
    }

    private fun loadBanner() {

        // Create an ad request.
        val adRequest = com.google.android.gms.ads.AdRequest.Builder().build()

        binding.adView.loadAd(adRequest)
    }



}