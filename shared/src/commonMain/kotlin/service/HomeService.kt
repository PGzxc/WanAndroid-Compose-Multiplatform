package service

import bean.ArticleData
import bean.HomeBannerBean
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import network.Network

interface HomeService {
    suspend fun getHomeBanner(): List<HomeBannerBean>
    suspend fun getHomeArticleList(page: Int = 0):ArticleData
    companion object{
        val instance = HomeServiceImpl(Network.client)
    }
}
class HomeServiceImpl(private val client:HttpClient):HomeService{
    override suspend fun getHomeBanner(): List<HomeBannerBean> {
        return client.get("/banner/json").body()
    }

    override suspend fun getHomeArticleList(page: Int): ArticleData {
        return client.get("article/list/$page/json").body()
    }

}