package bean

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** ----------1级项目---------------*/
@Serializable
data class ProjectResp(
    @SerialName("data") val data: List<ProjectBean>?,
    @SerialName("errorCode") val errorCode: Long,
    @SerialName("errorMsg") val errorMsg: String
)
@Serializable
data class ProjectBean(
    @SerialName("articleList") val articleList: List<String?>,
    @SerialName("author") val author: String,
    @SerialName("children") val children: List<String?>,
    @SerialName("courseId") val courseId: Long,
    @SerialName("cover") val cover: String,
    @SerialName("desc") val desc: String,
    @SerialName("id") val id: Long,
    @SerialName("lisense") val lisense: String,
    @SerialName("lisenseLink") val lisenseLink: String,
    @SerialName("name") val name: String,
    @SerialName("order") val order: Long,
    @SerialName("parentChapterId") val parentChapterId: Long,
    @SerialName("type") val type: Long,
    @SerialName("userControlSetTop") val userControlSetTop: Boolean,
    @SerialName("visible") val visible: Long
)
/** ----------2级项目---------------*/
@Serializable
data class ProjectItemResp(
    @SerialName("data") val data: ProjectItemListBeanData?,
    @SerialName("errorCode") val errorCode: Long,
    @SerialName("errorMsg") val errorMsg: String
)
@Serializable
data class ProjectItemListBeanData(
    @SerialName("curPage") val curPage: Long,
    @SerialName("datas") val datas: List<Article>,
    @SerialName("offset") val offset: Long,
    @SerialName("over") val over: Boolean,
    @SerialName("pageCount") val pageCount: Long,
    @SerialName("size") val size: Long,
    @SerialName("total") val total: Long
)