package viewmodel

import action.StateAction
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import bean.Article
import bean.ProjectBean
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import service.Api
import state.UIState

class ProjectViewModel: ScreenModel {
    private val api = Api.instance
    val projectListData by lazy { mutableStateListOf<ProjectBean>() }
    val projectItemListData by lazy { mutableStateListOf<Article>() }
    val currentPage by lazy { mutableStateOf<Int>(0) }
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
                        getProjectListData()
                        //_uiState.value = UIState.Success("Success")
                    }
                }.onFailure {
                    _uiState.value = UIState.Error("数据加载出错，请点击重试")
                }
            }
        }
    }

    fun getProjectListData(){
        kotlin.runCatching {
            coroutineScope.launch {
                val projectDeferred = async { api.getProject() }
                val navigatorEntity = projectDeferred.await()

                projectListData.addAll(navigatorEntity.data?: emptyList())
                print(projectListData)

                _uiState.value = UIState.Success("Success")
            }
        }.onFailure {
            _uiState.value = UIState.Error("数据加载出错，请点击重试")
        }
    }

    fun getProjectItemListData(page: Int, cid: Long){
        kotlin.runCatching {
            coroutineScope.launch {
                val projectItemListDeferred = async { api.getProjectItem(page,cid) }
                val navigatorItemListEntity = projectItemListDeferred.await()

                projectItemListData.addAll(navigatorItemListEntity.data?.datas ?: emptyList())
                print(projectItemListData)

                _uiState.value = UIState.Success("Success")
            }
        }.onFailure {
            _uiState.value = UIState.Error("数据加载出错，请点击重试")
        }
    }
}