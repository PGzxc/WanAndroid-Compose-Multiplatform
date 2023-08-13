package viewmodel

import action.StateAction
import androidx.compose.runtime.mutableStateListOf
import bean.Article
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import service.Api
import state.UIState
import widget.BannerData

class HomeViewModel : ScreenModel {

    private val api = Api.instance
    val bannerList by lazy { mutableStateListOf<BannerData>() }
    val articleList by lazy { mutableStateListOf<Article>() }

    private val _uiState = MutableStateFlow<UIState>(UIState.Loading)
    val uiState = _uiState

    init {
        dispatch(StateAction.FetchData)
    }

    fun dispatch(action: StateAction) {
        when (action) {
            is StateAction.FetchData -> {
                kotlin.runCatching {
                    coroutineScope.launch {
                        val homeBannerDeferred = async { api.getHomeBanner() }
                        val homeBannerEntity = homeBannerDeferred.await()
                        val map = homeBannerEntity.data .map {
                            BannerData(title = it.title, imageUrl = it.imagePath, linkUrl = it.url)
                        }

                        bannerList.addAll(map?: emptyList())
                        print(bannerList)


                        val homeArticleDeferred = async { api.getHomeArticleList(page = 0) }
                        val homeArticleEntity = homeArticleDeferred.await()
                        articleList.addAll(homeArticleEntity.data?.datas?: emptyList() )
                        print(articleList)
                        _uiState.value = UIState.Success("Success")
                    }
                }.onFailure {
                    _uiState.value = UIState.Error("数据加载出错，请点击重试")
                }
            }
        }
    }
}