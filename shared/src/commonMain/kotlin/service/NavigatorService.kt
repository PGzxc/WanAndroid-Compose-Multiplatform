package service

import bean.TreeBean
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import network.Network


interface NavigatorService {
    suspend fun getNavigator(): List<TreeBean>
    companion object{
        val instance = NavigatorServiceImpl(Network.client)
    }
}
class NavigatorServiceImpl(private val client: HttpClient):NavigatorService{
    override suspend fun getNavigator(): List<TreeBean> {
        return client.get("tree/json").body()
    }

}