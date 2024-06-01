package com.bypriyan.sharemarketcourseinhindi.activity

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bypriyan.sharemarketcourseinhindi.R
import com.bypriyan.sharemarketcourseinhindi.databinding.ActivityDisclamerBinding
import com.bypriyan.sharemarketcourseinhindi.databinding.ActivitySelectBinding

class DisclamerActivity : AppCompatActivity() {

    lateinit var binding: ActivityDisclamerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisclamerBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.backBtn.setOnClickListener{
            onBackPressedDispatcher.onBackPressed()
        }

        //back pressed
        onBackPressedDispatcher.addCallback(this, object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                finish()
            }
        })

        binding.disclamerTv.text = "यह App केवल शिक्षा और सीखने के उद्देश्य से है। यह किसी भी तरह से निवेश सलाह नहीं है. आप जो भी व्यापार करना चाहते हैं उसके लिए कृपया अपने Financial Advisor से सलाह लें।\n" +
                "\n" +
                "प्राप्त जानकारी या बाजार विश्लेषण के आधार पर उपयोगकर्ता द्वारा किए गए निवेश लेनदेन या अन्य परिसंपत्ति स्वभाव के परिणामस्वरूप होने वाले जोखिमों के लिए किसी भी और सभी दायित्व को \"Stock Market Course In Hindi App\" द्वारा स्पष्ट रूप से बाहर रखा गया है। यहां उपलब्ध कराई गई सभी जानकारी आम तौर पर केवल एक उदाहरण के रूप में प्रदान की जाती है, बिना किसी बाध्यता के और कार्रवाई के लिए विशिष्ट अनुशंसाओं के बिना।\n" +
                "\n" +
                "यह निवेश सलाह का गठन नहीं करता है और न ही उसका स्थान ले सकता है। इसलिए हम अनुशंसा करते हैं कि आप विशिष्ट लेनदेन और निवेश करने से पहले अपने व्यक्तिगत वित्तीय सलाहकार से संपर्क करें।\n" +
                "\n" +
                "उच्च जोखिमों को ध्यान में रखते हुए, आपको ऐसे लेनदेन केवल तभी करने चाहिए यदि आप उन अनुबंधों (और संविदात्मक संबंधों) की प्रकृति को समझते हैं जिनमें आप प्रवेश कर रहे हैं और यदि आप अपनी जोखिम क्षमता की सीमा का पूरी तरह से आकलन करने में सक्षम हैं। वायदा, विकल्प, विदेशी मुद्रा, सीएफडी, स्टॉक, क्रिप्टोकरेंसी और इसी तरह के वित्तीय उपकरणों के साथ व्यापार करना कई लोगों के लिए उपयुक्त नहीं है, आपको सावधानीपूर्वक विचार करना चाहिए कि आपके अनुभव, आपके उद्देश्यों, आपकी वित्तीय स्थिति और अन्य प्रासंगिक परिस्थितियों के आधार पर व्यापार करना आपके लिए उपयुक्त है या नहीं।\n" +
                "\n" +
                "पिछला प्रदर्शन भविष्य के परिणामों का कोई संकेत नहीं देता।\n" +
                "\n" +
                "स्टॉक, फ्यूचर और ऑप्शन ट्रेडिंग में नुकसान का काफी जोखिम होता है और यह हर निवेशक के लिए उपयुक्त नहीं है। वायदा, स्टॉक और विकल्प के मूल्यांकन में उतार-चढ़ाव हो सकता है और परिणामस्वरूप, ग्राहकों को अपने मूल निवेश से अधिक का नुकसान हो सकता है। मौसमी और भू-राजनीतिक घटनाओं का प्रभाव पहले से ही बाजार की कीमतों पर पड़ता है। वायदा कारोबार की अत्यधिक लीवरेज्ड प्रकृति का मतलब है कि छोटे बाजार आंदोलनों का आपके ट्रेडिंग खाते पर बहुत बड़ा प्रभाव पड़ेगा और यह आपके खिलाफ काम कर सकता है, जिससे बड़े नुकसान हो सकते हैं या आपके लिए काम कर सकते हैं, जिससे बड़े लाभ हो सकते हैं। यदि बाज़ार आपके विरुद्ध चलता है, तो आपको अपने खाते में जमा की गई राशि से अधिक का कुल नुकसान हो सकता है। आप अपने द्वारा उपयोग किए जाने वाले सभी जोखिमों और वित्तीय संसाधनों और चुनी गई ट्रेडिंग प्रणाली के लिए जिम्मेदार हैं। आपको तब तक व्यापार में संलग्न नहीं होना चाहिए जब तक कि आप अपने द्वारा किए जा रहे लेनदेन की प्रकृति और आपके नुकसान के जोखिम की सीमा को पूरी तरह से नहीं समझ लेते। यदि आप इन जोखिमों को पूरी तरह से नहीं समझते हैं तो आपको अपने वित्तीय सलाहकार से स्वतंत्र सलाह लेनी चाहिए।\n" +
                "\n" +
                "सभी ट्रेडिंग रणनीतियों का उपयोग आपके अपने जोखिम पर किया जाता है।"


    }

}