plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-kapt")

}

android {
    namespace = "com.bypriyan.sharemarketcourseinhindi"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.bypriyan.sharemarketcourseinhindi"
        minSdk = 24
        targetSdk = 34
        versionCode = 2
        versionName = "2.0"
        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    //viewpager 2
    implementation ("com.google.android.material:material:1.11.0")
    implementation ("androidx.viewpager2:viewpager2:1.0.0")

    //splash screen api
    implementation ("androidx.core:core-splashscreen:1.0.1")
    //multidex
    implementation ("androidx.annotation:annotation:1.7.1")
    implementation ("org.jetbrains:annotations:24.0.1")
    implementation ("androidx.multidex:multidex:2.0.1")
    //sdp ssp
    implementation ("com.intuit.sdp:sdp-android:1.1.0")
    implementation ("com.intuit.ssp:ssp-android:1.1.0")
    //lottie anim
    implementation ("com.airbnb.android:lottie:6.4.0")
    //coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    //mvvm
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    // Lifecycles only (without ViewModel or LiveData)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")

    // LiveData
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation ("androidx.core:core-ktx:1.12.0")
    //dagger
    implementation ("com.google.dagger:dagger:2.51.1")
    kapt ("com.google.dagger:dagger-compiler:2.51.1")
    //anim
    implementation ("com.flaviofaria:kenburnsview:1.0.7")
    //coil
    implementation("io.coil-kt:coil:2.6.0")

    implementation("com.tbuonomo:dotsindicator:5.0")
    //retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.11.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.11.0")
    //pagging
    implementation ("androidx.paging:paging-runtime-ktx:3.2.1")
    //admob
    implementation("com.google.android.gms:play-services-ads:23.0.0")

}