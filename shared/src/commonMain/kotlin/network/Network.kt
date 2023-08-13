package network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.cookies.AcceptAllCookiesStorage
import io.ktor.client.plugins.cookies.HttpCookies
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object Network {

    val client= HttpClient {
        //配置默认参数，域名
        defaultRequest {
            url("https://www.wanandroid.com/")
        }

        //日志解析
        install(Logging){
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
        //Cookie
        install(HttpCookies) {
            storage = AcceptAllCookiesStorage()
        }
        //json解析
        install(ContentNegotiation){
            json(Json { //application/json html/text
                ignoreUnknownKeys = true
                useAlternativeNames = true //这个配置会增加性能开销，非必要不开启
            })
        }
        //BaseResponse插件
//        install(BaseResponsePlugin){
//            keysForStatus = listOf("errorCode")
//            successCode = "0"
//            keysForData = listOf("data")
//
//        }
//        install(AutoHeadResponse.toString()){
//
//        }

    }

}