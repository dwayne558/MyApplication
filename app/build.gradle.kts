plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}


android {
    namespace = "com.example.myapplication"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("com.iterable:iterableapi:3.5.3") // Iterable SDK
    implementation ("com.iterable:iterableapi-ui:3.5.3")
    implementation ("com.google.firebase:firebase-messaging:20.3.0")

    implementation(libs.androidx.ui.graphics.android)
    implementation(libs.androidx.foundation.android)
    implementation(libs.androidx.material3.android)
    implementation("androidx.compose.ui:ui:1.5.0")
    implementation("androidx.compose.material:material:1.5.0")
    implementation("androidx.compose.ui:ui-tooling:1.5.0")
    implementation("androidx.compose.runtime:runtime:1.5.0")
    implementation(libs.androidx.monitor)
    implementation(libs.core)
    implementation(libs.androidx.junit.ktx)
    implementation(libs.androidx.core)
    implementation(libs.androidx.core)
    testImplementation(libs.junit.junit)
    androidTestImplementation(libs.junit.junit)
}
