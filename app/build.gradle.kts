plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.projetokotlin"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.projetokotlin"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    viewBinding {
        enable = true
    }

    ksp {
        arg("room.schemaLocation", "$projectDir/schemas")
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.room.common.jvm)
    implementation(libs.androidx.room.runtime.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //bibliotecas Android Room
    val roomVersion = "2.6.1"//Versão do Android Room a ser utilizada
    implementation(libs.androidx.room.runtime.v261)//Principal biblioteca do Android Room
    implementation(libs.androidx.room.ktx.v261)//Fornece integração com o Kotlin
    ksp(libs.androidx.room.compiler)//É responsável por gerar código Room em tempo de compilação através das anotações
    annotationProcessor(libs.androidx.room.compiler)//Utilizado para   maior compatibilidade com outros tipos de anotações que precisam ser verificadas em tempo de compilação
}