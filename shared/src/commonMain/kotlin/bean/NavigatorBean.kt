package bean

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * @desc：导航数据类
 */
@Serializable
data class TreeListResp(
    val data: List<TreeBean>? = null,
    val errorCode: Long,
    val errorMsg: String
)

@Serializable
data class TreeBean(
    @SerialName("articleList") val articleList: List<String?> = listOf(),
    @SerialName("author") val author: String = "",
    @SerialName("children") val children: List<TreeItemBean> = listOf(),
    @SerialName("courseId") val courseId: Long = 0,
    @SerialName("cover") val cover: String = "",
    @SerialName("desc") val desc: String = "",
    @SerialName("id") val id: Long = 0,
    @SerialName("lisense") val lisense: String = "",
    @SerialName("lisenseLink") val lisenseLink: String = "",
    @SerialName("name") val name: String = "",
    @SerialName("order") val order: Long = 0,
    @SerialName("parentChapterId") val parentChapterId: Long,
    @SerialName("type") val type: Long = 0,
    @SerialName("userControlSetTop") val userControlSetTop: Boolean = false,
    @SerialName("visible") val visible: Long = 0
)

@Serializable
data class TreeItemBean(
    @SerialName("articleList") val articleList: List<ArticleList> = listOf(),
    @SerialName("author") val author: String = "",
    @SerialName("children") val children: List<String?> = listOf(),
    @SerialName("courseId") val courseId: Long,
    @SerialName("cover") val cover: String = "",
    @SerialName("desc") val desc: String = "",
    @SerialName("id") val id: Long = 0,
    @SerialName("lisense") val lisense: String = "",
    @SerialName("lisenseLink") val lisenseLink: String = "",
    @SerialName("name") val name: String = "",
    @SerialName("order") val order: Long = 0,
    @SerialName("parentChapterId") val parentChapterId: Long = 0,
    @SerialName("type") val type: Long = 0,
    @SerialName("userControlSetTop") val userControlSetTop: Boolean = false,
    @SerialName("visible") val visible: Long = 0
)

@Serializable
data class ArticleList(
    @SerialName("adminAdd") val adminAdd: Boolean,
    @SerialName("apkLink") val apkLink: String,
    @SerialName("audit") val audit: Long,
    @SerialName("author") val author: String,
    @SerialName("canEdit") val canEdit: Boolean,
    @SerialName("chapterId") val chapterId: Long,
    @SerialName("chapterName") val chapterName: String,
    @SerialName("collect") val collect: Boolean,
    @SerialName("courseId") val courseId: Long,
    @SerialName("desc") val desc: String,
    @SerialName("descMd") val descMd: String,
    @SerialName("envelopePic") val envelopePic: String,
    @SerialName("fresh") val fresh: Boolean,
    @SerialName("host") val host: String,
    @SerialName("id") val id: Long,
    @SerialName("isAdminAdd") val isAdminAdd: Boolean,
    @SerialName("link") val link: String,
    @SerialName("niceDate") val niceDate: String,
    @SerialName("niceShareDate") val niceShareDate: String,
    @SerialName("origin") val origin: String,
    @SerialName("prefix") val prefix: String,
    @SerialName("projectLink") val projectLink: String,
    @SerialName("publishTime") val publishTime: Long,
    @SerialName("realSuperChapterId") val realSuperChapterId: Long,
    @SerialName("selfVisible") val selfVisible: Long,
    @SerialName("shareDate") val shareDate: Long,
    @SerialName("shareUser") val shareUser: String,
    @SerialName("superChapterId") val superChapterId: Long,
    @SerialName("superChapterName") val superChapterName: String,
    @SerialName("tags") val tags: List<String?>,
    @SerialName("title") val title: String,
    @SerialName("type") val type: Long,
    @SerialName("userId") val userId: Long,
    @SerialName("visible") val visible: Long,
    @SerialName("zan") val zan: Long
)