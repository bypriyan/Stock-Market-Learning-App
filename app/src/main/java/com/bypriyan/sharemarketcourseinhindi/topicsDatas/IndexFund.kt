package com.bypriyan.sharemarketcourseinhindi.topicsDatas

import com.bypriyan.bustrackingsystem.utility.Constants
import com.bypriyan.sharemarketcourseinhindi.model.ModelSubTopic

object IndexFund {

    fun getIndexFundList(): List<ModelSubTopic>{
        return listOf(

            ModelSubTopic(
                id = 1,
                topic = Constants.KEY_TOPIC_INDEX_FUND,
                title = "इंडेक्स फंड क्या है?",
                description = "इंडेक्स फंड एक प्रकार के म्यूचुअल फंड होते हैं जो एक विशिष्ट शेयर बाजार इंडेक्स के अनुसार निवेश करते हैं। इनमें, निवेशक एक बाजार इंडेक्स के पोर्टफोलियो को अनुसारित करते हुए विभिन्न प्रकार के स्टॉक्स या सुरक्षाओं की एक बास्केट में निवेश करते हैं। ये फंड एक सरल और सीधी प्रणाली का अनुसरण करते हैं, जिसमें उनका मुख्य उद्देश्य इंडेक्स के अनुसार लाभ प्राप्त करना होता है।\n\n" +
                        "इंडेक्स फंड का उदाहरण निफ्टी 50 या सेंसेक्स हो सकता है, जिनमें भारतीय शेयर बाजार के मुख्य 50 या 30 शेयरों को संकेतित किया जाता है। इस तरह, इंडेक्स फंड निवेशकों को बाजार के मुख्य चलने वाले अंशों का सीधा उपायन करने में मदद करता है और इसे एक सुचारू और पारदर्शी तरीके से निवेश करने का एक अच्छा विकल्प बनाता है।\n\n" +
                        "यहां कुछ महत्वपूर्ण बिंदु इंडेक्स फंड्स के बारे में हैं:\n\n" +
                        "- इंडेक्स के अनुसार निवेश: इंडेक्स फंड एक मुख्य शेयर बाजार इंडेक्स, जैसे निफ्टी या सेंसेक्स, के अनुसार निवेश करते हैं। ये फंड उस इंडेक्स के प्रति किसी भी समय के बदलावों को प्रतिदिन से बचाते हैं।\n\n" +
                        "- सीधी प्रणाली: इंडेक्स फंड्स का प्रबंधन सीधा होता है। अर्थात, फंड प्रबंधक को प्रति निवेश के लिए स्टॉक या सुरक्षा का चयन करने की जरूरत नहीं होती। उन्हें बस इंडेक्स के अनुरूप पोर्टफोलियो को मेंटेन करना होता है।\n\n" +
                        "- काम कराने की लागत: इंडेक्स फंड्स की कम कारणी की लागत भी कम होती है, क्योंकि इनमें कोई अतिरिक्त सक्रिय फंड प्रबंधक की फीस या स्टॉक चयन की लागत नहीं होती। इसलिए, ये निवेशकों के लिए लागत-प्रभावी होते हैं।\n\n" +
                        "- समय की बचत: इंडेक्स फंड्स में निवेश करने से निवेशक को समय की बचत होती है, क्योंकि उन्हें शेयर बाजार में निवेश करने की तैयारी नहीं करनी पड़ती। ये फंड लॉन्ग-टर्म निवेश के लिए भी अच्छे होते हैं।\n\n" +
                        "- विविधता (Diversification): इंडेक्स फंड्स में निवेशक एक साथ कई स्टॉक्स में निवेश करते हैं, जो कि उन्हें विविधता का लाभ देते हैं। इससे उनका जोखिम कम हो जाता है।\n\n" +
                        "उदाहरण के रूप में, मान लीजिए आपने सेंसेक्स इंडेक्स फंड में निवेश किया है। अगर सेंसेक्स में शामिल कुछ प्रमुख 30 कंपनियों के शेयरों का मूल्य बढ़ता है, तो आपके इंडेक्स फंड के शेयरों का भी मूल्य बढ़ेगा। इस तरह सेंसेक्स के मुख्य चलनों के आधार पर, आपका निवेश बढ़ सकता है। यह एक ऐसा उदाहरण है जो सीधे शेयर बाजार के प्रभाव पर निर्भर करता है, इसलिए इसे 'पैसिव निवेश' भी कहा जाता है।",
                imgUrl = "https://static.vecteezy.com/system/resources/thumbnails/007/814/346/small_2x/index-fund-concept-business-people-analyzing-a-growth-index-fund-graph-illustration-free-vector.jpg"
            ),

            ModelSubTopic(
                id = 2,
                topic = Constants.KEY_TOPIC_INDEX_FUND,
                title = "दूसरे फंड और इंडेक्स फंड में अंतर",
                description = "दूसरे फंड और इंडेक्स फंड में कुछ मुख्य अंतर हैं:\n\n" +
                        "1. निवेश का तरीका: दूसरे म्यूचुअल फंड या एक्टिव फंड्स में, प्रबंधक निवेश को सक्रिय रूप से प्रबंधित करता है, जबकि इंडेक्स फंड्स में निवेश विशिष्ट शेयर बाजार इंडेक्स के अनुसार होता है और प्रबंधक की सक्रियता का कोई असर नहीं होता।\n\n" +
                        "2. निवेश की लागत: एक्टिव फंड्स की लागत इंडेक्स फंड्स की तुलना में अधिक होती है। एक्टिव फंड्स में प्रबंधकों की फीस, वित्तीय व्यय और अन्य लागतें शामिल होती हैं, जो निवेशकों को ज्यादा महंगी पड़ सकती है।\n\n" +
                        "3. शेयर चयन: एक्टिव फंड्स में प्रबंधक शेयर चयन करता है जो वह मानता है कि बाजार में सबसे अच्छा प्रदर्शन करेगा। इसके बावजूद, इंडेक्स फंड्स में शेयरों का चयन इंडेक्स के अनुसार होता है, जिससे निवेशकों का जोखिम कम होता है।\n\n" +
                        "4. प्रदर्शन: एक्टिव फंड्स का प्रदर्शन प्रबंधक की क्षमताओं पर निर्भर करता है, जबकि इंडेक्स फंड्स का प्रदर्शन उस इंडेक्स के अनुसार होता है जिसमें वह निवेश करता है।\n\n" +
                        "5. टैक्स लाभ: एक्टिव फंड्स में निवेश करने पर आमतौर पर लंबे समय तक लगातार प्राप्त लाभों पर कर लगता है, जबकि इंडेक्स फंड्स का कर लाभ प्राप्त करने का प्रावधान शेयर के नियमों और विनियमों के अनुसार होता है।",
                imgUrl = "https://static.vecteezy.com/system/resources/thumbnails/007/814/346/small_2x/index-fund-concept-business-people-analyzing-a-growth-index-fund-graph-illustration-free-vector.jpg"
            )
        )
    }

}