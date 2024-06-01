package com.bypriyan.sharemarketcourseinhindi.activity

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.unit.Constraints
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bypriyan.bustrackingsystem.utility.Constants
import com.bypriyan.sharemarketcourseinhindi.R
import com.bypriyan.sharemarketcourseinhindi.adapter.AdapterTopics
import com.bypriyan.sharemarketcourseinhindi.databinding.ActivityMainBinding
import com.bypriyan.sharemarketcourseinhindi.databinding.ActivitySelectBinding
import com.bypriyan.sharemarketcourseinhindi.databinding.ActivityTopicsBinding
import com.bypriyan.sharemarketcourseinhindi.model.ModelTopics
import com.bypriyan.sharemarketcourseinhindi.utility.NetworkConnection
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.OnUserEarnedRewardListener
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback

class TopicsActivity : AppCompatActivity() {

    lateinit var binding: ActivityTopicsBinding
    private var rewardedAd: RewardedAd? = null
    private var isShowed:Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTopicsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.topicsRv.adapter =AdapterTopics(this, getTopicsList())

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
//                        ad.show(this@TopicsActivity, OnUserEarnedRewardListener { rewardItem ->
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

    fun getTopicsList(): List<ModelTopics> {
            return listOf(
                ModelTopics("https://images.moneycontrol.com/static-mcnews/2020/01/Investment-1-770x433.png?impolicy=website&width=770&height=431", "शेयर बाजार\n(Stock Market)", Constants.KEY_TOPIC_STOCK_MARKET),
                ModelTopics("https://www.mstock.com/content/images/articles/category-banner/mutual-fund.webp", "म्युचुअल फण्ड\n(Mutual Funds)", Constants.KEY_TOPIC_MUTUAL_FUNDS),
                ModelTopics("https://png.pngtree.com/png-vector/20211007/ourlarge/pngtree-online-trading-stock-market-in-flat-png-image_3974395.png", "ट्रेडिंग\n(Trading)", Constants.KEY_TOPIC_TRADING),
                ModelTopics("https://media.istockphoto.com/id/2072952800/vector/bse-building-bombay-stock-exchange-market-growth-stock-market-trading-indian-businesses.jpg?s=612x612&w=0&k=20&c=wEH8EqWSMKTlrmFY9yrHQNc7e6H-4On0QCluxhb9ECI=", "निफ्टी\n(Nifty)", Constants.KEY_TOPIC_NIFTY),
                ModelTopics("https://www.tickertape.in/blog/wp-content/uploads/2022/05/TT-25-May-Sensex-BB-1200x900-cropped.jpeg", "सेंसेक्स\n(Sensex)", Constants.KEY_TOPIC_SENSEX),
                ModelTopics("https://static.vecteezy.com/system/resources/previews/001/944/170/non_2x/man-invests-and-made-a-profit-free-vector.jpg", "निवेश\n(Investing)", Constants.KEY_TOPIC_INVESTING),
                ModelTopics("https://www.shutterstock.com/image-vector/commodities-price-trading-investment-agriculture-600nw-2135732231.jpg", "कमोडिटी\n(Commodity)", Constants.KEY_TOPIC_COMMODITY),
                ModelTopics("https://media.istockphoto.com/id/1316247835/vector/etf-index-fund-or-mutual-fund-alternative-concept-businessman-investor-holding-or-balance.jpg?s=612x612&w=0&k=20&c=oSx0EaD-4cbGGIdH1QJi-enjgRjxkm10Iz87v53LPuU=", "ईटीएफ\n(ETF)", Constants.KEY_TOPIC_ETF),
                ModelTopics("https://static.vecteezy.com/system/resources/thumbnails/007/814/346/small_2x/index-fund-concept-business-people-analyzing-a-growth-index-fund-graph-illustration-free-vector.jpg", "इंडेक्स फंड\n(Index Fund)", Constants.KEY_TOPIC_INDEX_FUND),
                ModelTopics("https://www.smallcase.com/wp-content/uploads/2023/02/Hero-new-SIP-2.png", "एसआईपी\n(SIP)",Constants.KEY_TOPIC_SIP),
                ModelTopics("https://media.istockphoto.com/id/1282186968/vector/woman-invests-in-bonds-receive-coupons-concept-of-return-on-investment-financial-solutions.jpg?s=612x612&w=0&k=20&c=ufjm9HW8tsV2gqGtkjMTlKMLC-8gOvWdDb7RVrWvTBM=", "बॉन्ड्स\n(Bonds)", Constants.KEY_TOPIC_BONDS),
                ModelTopics("https://media.istockphoto.com/id/1400001514/vector/food-and-price-inflation-rises-after-monetary-value-growth-ideas-financial-problems-and.jpg?s=612x612&w=0&k=20&c=jPlvH-V6VEb88YWot1Ou4ggq4ZFPH9ugm4RhtRaWRNM=", "महंगाई\n(Inflation)", Constants.KEY_TOPIC_INFLATION),
                ModelTopics("https://cdn-scripbox-wordpress.scripbox.com/wp-content/uploads/2021/03/dividend-payout-vector.png", "डिविडेंड\n(Dividends)", Constants.KEY_TOPIC_DIVIDENDS),
                ModelTopics("https://static.vecteezy.com/system/resources/previews/026/568/013/original/initial-public-offering-ipo-concept-investment-tiny-people-investors-ivest-stock-market-shares-company-growth-passive-income-modern-flat-cartoon-style-illustration-on-white-background-vector.jpg", "आईपीओ\n(IPO)", Constants.KEY_TOPIC_IPO),
                ModelTopics("https://cdn.dribbble.com/userupload/3228221/file/original-d107e26d3c6f1de989a5d239d031270c.png?resize=752x", "क्रिप्टोकरेंसी\n(Cryptocurrency)", Constants.KEY_TOPIC_CRYPTO)
            )

    }

    private fun loadBanner() {

        // Create an ad request.
        val adRequest = com.google.android.gms.ads.AdRequest.Builder().build()

        binding.adView.loadAd(adRequest)
    }
}

