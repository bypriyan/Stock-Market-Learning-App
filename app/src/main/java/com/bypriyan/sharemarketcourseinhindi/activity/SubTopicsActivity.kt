package com.bypriyan.sharemarketcourseinhindi.activity

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bypriyan.bustrackingsystem.utility.Constants
import com.bypriyan.sharemarketcourseinhindi.R
import com.bypriyan.sharemarketcourseinhindi.adapter.AdapterSubTopics
import com.bypriyan.sharemarketcourseinhindi.adapter.AdapterSubTopicsDetails
import com.bypriyan.sharemarketcourseinhindi.databinding.ActivityNewsDetailsBinding
import com.bypriyan.sharemarketcourseinhindi.databinding.ActivitySubTopicsBinding
import com.bypriyan.sharemarketcourseinhindi.model.ModelSubTopic
import com.bypriyan.sharemarketcourseinhindi.topicsDatas.Bonds
import com.bypriyan.sharemarketcourseinhindi.topicsDatas.Commodity
import com.bypriyan.sharemarketcourseinhindi.topicsDatas.Cryptocurrency
import com.bypriyan.sharemarketcourseinhindi.topicsDatas.Dividends
import com.bypriyan.sharemarketcourseinhindi.topicsDatas.ETF
import com.bypriyan.sharemarketcourseinhindi.topicsDatas.IPO
import com.bypriyan.sharemarketcourseinhindi.topicsDatas.IndexFund
import com.bypriyan.sharemarketcourseinhindi.topicsDatas.Inflation
import com.bypriyan.sharemarketcourseinhindi.topicsDatas.Investing
import com.bypriyan.sharemarketcourseinhindi.topicsDatas.MutualFunds
import com.bypriyan.sharemarketcourseinhindi.topicsDatas.Nifty
import com.bypriyan.sharemarketcourseinhindi.topicsDatas.SIP
import com.bypriyan.sharemarketcourseinhindi.topicsDatas.Sensex
import com.bypriyan.sharemarketcourseinhindi.topicsDatas.StockMarket
import com.bypriyan.sharemarketcourseinhindi.topicsDatas.Trading
import com.bypriyan.sharemarketcourseinhindi.utility.NetworkConnection
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.OnUserEarnedRewardListener
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback

class SubTopicsActivity : AppCompatActivity() {

    lateinit var binding: ActivitySubTopicsBinding
    lateinit var topicList: List<ModelSubTopic>
    private var rewardedAd: RewardedAd? = null
    private var isShowed:Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySubTopicsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.title.text = intent.getStringExtra(Constants.KEY_SUB_TOPIC)

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
//                        ad.show(this@SubTopicsActivity, OnUserEarnedRewardListener { rewardItem ->
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

        topicList = when(intent.getStringExtra(Constants.KEY_SUB_TOPIC)) {
            "Stock Market" ->  StockMarket.getStockMarketTopic()
            "Mutual Funds" -> MutualFunds.getMutualFundsTopic()
            "Trading" -> Trading.getTradingList()
            "Investing" -> Investing.getInvestingList()
            "Commodity" -> Commodity.getCommodityList()
            "ETF" -> ETF.getEFTList()
            "SIP" ->  SIP.getSIPList()
            "IndexFund" ->  IndexFund.getIndexFundList()
            "Bonds" ->  Bonds.getBondsList()
            "Inflation" ->  Inflation.getInflationList()
            "Dividends" -> Dividends.getDividendsList()
            "IPO" -> IPO.getIPOList()
            "Nifty" ->  Nifty.getNiftyList()
            "Sensex" ->  Sensex.getSensexList()
            "Cryptocurrency" ->  Cryptocurrency.getCryptocurrencyList()
            else -> MutualFunds.getMutualFundsTopic()
        }

        binding.subTopicRv.adapter = AdapterSubTopics(this, topicList)

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