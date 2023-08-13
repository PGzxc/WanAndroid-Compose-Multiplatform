package service

import bean.ArticleData
import bean.ArticleResp
import bean.HomeBannerResp
import bean.MeCoinInfoResp
import bean.MessageBeanData
import bean.MessageResp
import bean.ProjectBean
import bean.ProjectItemListBeanData
import bean.ProjectItemResp
import bean.ProjectResp
import bean.RegisterResp
import bean.TreeBean
import bean.TreeListResp
import bean.UserInfo
import bean.UserResp
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.http.path
import network.Network

interface Api {
    //1-首页
    suspend fun getHomeBanner(): HomeBannerResp

    //suspend fun getHomeBanner(): List<HomeBannerBean>
    suspend fun getHomeArticleList(page: Int = 0): ArticleResp

    //suspend fun getHomeArticleList(page: Int = 0): ArticleData
    //2-导航
    suspend fun getNavigator(): TreeListResp

    //3-项目
    suspend fun getProject(): ProjectResp
    suspend fun getProjectItem(page: Int = 0, cid: Long): ProjectItemResp

    //4-消息
    suspend fun getMessageUnRead(page: Int = 1): MessageResp
    suspend fun getMessageRead(page: Int = 1): MessageResp

    //5-我的
    suspend fun getCoinUserInfo(): MeCoinInfoResp

    //6-登录注册
    suspend fun login(username: String, password: String): UserResp

    suspend fun register(username: String, password: String, repassword: String): RegisterResp


    companion object {
        val instance = ApiService(Network.client)
    }
}

class ApiService(private val client: HttpClient) : Api {
    override suspend fun getHomeBanner(): HomeBannerResp {
        return client.get("/banner/json").body()
    }

    override suspend fun getHomeArticleList(page: Int): ArticleResp {
        return client.get("article/list/$page/json").body()
    }

    override suspend fun getNavigator(): TreeListResp {
        return client.get("tree/json").body()
    }

    override suspend fun getProject(): ProjectResp {
        return client.get("project/tree/json").body()
    }

    override suspend fun getProjectItem(page: Int, cid: Long): ProjectItemResp {
        return client.get {
            url {
                path("project/list/$page/json")
                parameters.append("cid", cid.toString())
            }
        }.body()
    }

    override suspend fun getMessageUnRead(page: Int): MessageResp {
        return client.get("message/lg/unread_list/$page/json").body()
    }

    override suspend fun getMessageRead(page: Int): MessageResp {
        return client.get("message/lg/readed_list/$page/json").body()
    }

    //获取个人积分，需要登录后访问
    override suspend fun getCoinUserInfo(): MeCoinInfoResp {
        return client.get("lg/coin/userinfo/json").body()
    }

    override suspend fun login(username: String, password: String): UserResp {
        return client.post {
            url {
                path("user/login")
                parameters.append("username", username)
                parameters.append("password", password)
            }
        }.body()
    }

    override suspend fun register(
        username: String,
        password: String,
        repassword: String
    ): RegisterResp {
        return client.post {
            url {
                path("user/register")
                parameters.append("username", username)
                parameters.append("password", password)
                parameters.append("repassword", repassword)
            }
        }.body()
    }
}
