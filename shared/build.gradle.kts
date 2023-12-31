plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("org.jetbrains.compose")
    kotlin("plugin.serialization") version("1.9.0") //序列化
    //id("io.ktor.plugin")
}

kotlin {
    androidTarget()

    jvm("desktop")

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        version = "1.0.0"
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
        }
        extraSpecAttributes["resources"] = "['src/commonMain/resources/**', 'src/iosMain/resources/**']"
    }
    val voyagerVersion = "1.0.0-rc06"
    val ktorVersion = "2.3.3"
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.animation) //要加这个，不然voyager-transition会出错
                implementation(compose.materialIconsExtended)
                //implementation(compose.material)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)

                implementation("media.kamel:kamel-image:0.7.1") //图片
                implementation("io.ktor:ktor-client-core:$ktorVersion") //网络请求-核心依赖项
                implementation("io.ktor:ktor-server-auto-head-response:$ktorVersion")
                implementation("io.ktor:ktor-client-logging:$ktorVersion") //网络日志打印
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion") //负责序列化/反序列化特定格式的内容

                // Navigator
                implementation("cafe.adriel.voyager:voyager-navigator:$voyagerVersion")
                // Transitions
                implementation("cafe.adriel.voyager:voyager-transitions:$voyagerVersion")

                //implementation("io.github.irgaly.kottage:kottage:1.5.1") //保存数据
                implementation("io.github.xxfast:kstore-file:0.6.0")
                implementation("io.github.xxfast:kstore:0.6.0")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                api("androidx.activity:activity-compose:1.6.1")
                api("androidx.appcompat:appcompat:1.6.1")
                api("androidx.core:core-ktx:1.9.0")

                api("io.ktor:ktor-client-android:$ktorVersion") //网络请求
                api("com.google.accompanist:accompanist-systemuicontroller:0.30.1")
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation("io.ktor:ktor-client-darwin:$ktorVersion") //网络请求
            }
            //implementation("io.ktor:ktor-client-coi-jvm:$ktorVersion") //网络请求
            //implementation("io.ktor:ktor-client-curl:2.3.3")
            //implementation("io.ktor:ktor-client-cio:$ktorVersion") //网络请求
            //implementation("io.ktor:ktor-client-darwin:$ktorVersion")
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }

        val desktopMain by getting {
            dependencies {
                implementation(compose.desktop.common)
                implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
                //implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
                //implementation("io.ktor:ktor-client-curl:$ktorVersion") //网络请求
                //implementation("io.ktor:ktor-client-core-native:$ktorVersion")
            }
        }
    }
}

android {
    compileSdk = (findProperty("android.compileSdk") as String).toInt()
    namespace = "com.zxc.common"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        minSdk = (findProperty("android.minSdk") as String).toInt()
        targetSdk = (findProperty("android.targetSdk") as String).toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        jvmToolchain(17)
    }
}
