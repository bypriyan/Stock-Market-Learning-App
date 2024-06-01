package com.bypriyan.sharemarketcourseinhindi.model

data class ModelArticelResponce(
    val status:String,
    val totalResults:Int,
    val articles:List<ModelArticles>
)
