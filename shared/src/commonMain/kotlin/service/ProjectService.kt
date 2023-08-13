package service

import bean.ArticleData
import bean.HomeBannerBean
import bean.ProjectBean
import bean.ProjectItemListBeanData
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.path
import network.Network


interface ProjectService {
    suspend fun getProject(): List<ProjectBean>
    suspend fun getProjectItem(page: Int = 0, cid: Long): ProjectItemListBeanData

    companion object {
        val instance = ProjectServiceImpl(Network.client)
    }
}

class ProjectServiceImpl(private val client: HttpClient) : ProjectService {
    override suspend fun getProject(): List<ProjectBean> {
        return client.get("project/tree/json").body()
    }

    override suspend fun getProjectItem(page: Int, cid: Long): ProjectItemListBeanData {
        return client.get {
            url {
                path("project/list/$page/json")
                parameters.append("cid", cid.toString())
            }
        }.body()
    }
}