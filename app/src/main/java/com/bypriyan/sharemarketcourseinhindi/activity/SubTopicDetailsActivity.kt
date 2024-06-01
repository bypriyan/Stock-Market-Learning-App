package com.bypriyan.sharemarketcourseinhindi.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.bypriyan.bustrackingsystem.utility.Constants
import com.bypriyan.sharemarketcourseinhindi.adapter.AdapterSubTopicsDetails
import com.bypriyan.sharemarketcourseinhindi.databinding.ActivitySubTopicDetailsBinding
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

class SubTopicDetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivitySubTopicDetailsBinding
    lateinit var adapter: AdapterSubTopicsDetails
    private var rewardedAd: RewardedAd? = null
    private var isShowed:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySubTopicDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
//                        ad.show(this@SubTopicDetailsActivity, OnUserEarnedRewardListener { rewardItem ->
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

        var subTopic = intent.getStringExtra(Constants.KEY_SUB_TOPIC)
        binding.title.text = subTopic

        // Set adapter to ViewPager2
        adapter= when(subTopic){
            "Stock Market" -> AdapterSubTopicsDetails(this, StockMarket.getStockMarketTopic())
            "Mutual Funds" -> AdapterSubTopicsDetails(this, MutualFunds.getMutualFundsTopic())
            "Trading" -> AdapterSubTopicsDetails(this, Trading.getTradingList())
            "Investing" -> AdapterSubTopicsDetails(this, Investing.getInvestingList())
            "Commodity" -> AdapterSubTopicsDetails(this, Commodity.getCommodityList())
            "ETF" -> AdapterSubTopicsDetails(this, ETF.getEFTList())
            "SIP" -> AdapterSubTopicsDetails(this, SIP.getSIPList())
            "IndexFund" -> AdapterSubTopicsDetails(this, IndexFund.getIndexFundList())
            "Bonds" -> AdapterSubTopicsDetails(this, Bonds.getBondsList())
            "Inflation" -> AdapterSubTopicsDetails(this, Inflation.getInflationList())
            "Dividends" -> AdapterSubTopicsDetails(this, Dividends.getDividendsList())
            "IPO" -> AdapterSubTopicsDetails(this, IPO.getIPOList())
            "Nifty" -> AdapterSubTopicsDetails(this, Nifty.getNiftyList())
            "Sensex" -> AdapterSubTopicsDetails(this, Sensex.getSensexList())
            "Cryptocurrency" -> AdapterSubTopicsDetails(this, Cryptocurrency.getCryptocurrencyList())
            else -> AdapterSubTopicsDetails(this, MutualFunds.getMutualFundsTopic())
        }
        binding.viewPager2.adapter = adapter

        binding.viewPager2.currentItem = intent.getStringExtra(Constants.KEY_SUB_TOPIC_ID)!!.toInt()-1

        var lastIndex = adapter.itemCount//16
        checkPosition(binding.viewPager2.currentItem, lastIndex = lastIndex )


        binding.viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(currentPos: Int) {
                super.onPageSelected(currentPos)
                checkPosition(currentPos, lastIndex)
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

    private fun checkPosition(currentPos: Int, lastIndex: Int) {
        if(currentPos==0){
            binding.precCounter.visibility= View.GONE
            binding.presentCounter.text = "${currentPos+1} OF ${lastIndex}"
            binding.postCounter.visibility= View.VISIBLE
            binding.postCounter.text = "${currentPos+2} OF ${lastIndex}"
        }else if(currentPos==lastIndex-1){
            binding.precCounter.visibility= View.VISIBLE
            binding.precCounter.text = "${currentPos} OF ${lastIndex}"
            binding.presentCounter.text = "${currentPos+1} OF ${lastIndex}"
            binding.postCounter.visibility= View.GONE
        }else{
            binding.precCounter.visibility= View.VISIBLE
            binding.precCounter.text = "${currentPos} OF ${lastIndex}"
            binding.presentCounter.text = "${currentPos+1} OF ${lastIndex}"
            binding.postCounter.visibility= View.VISIBLE
            binding.postCounter.text = "${currentPos+2} OF ${lastIndex}"
        }

    }

    private fun loadBanner() {

        // Create an ad request.
        val adRequest = com.google.android.gms.ads.AdRequest.Builder().build()

        binding.adView.loadAd(adRequest)
    }

}