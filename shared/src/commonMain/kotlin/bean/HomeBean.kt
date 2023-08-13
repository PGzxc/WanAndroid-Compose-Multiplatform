package bean

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @desc：首页轮播图
 */
@Serializable
data class HomeBannerBean(
    @SerialName("id") val id: Long = 0,
    @SerialName("desc") val desc: String = "",
    @SerialName("imagePath") val imagePath: String = "",
    @SerialName("isVisible") val isVisible: Int = 0,
    @SerialName("order") val order: Int = 0,
    @SerialName("title") val title: String = "",
    @SerialName("type") val type: Int = 0,
    @SerialName("url") val url: String = ""
)

@Serializable
data class HomeBannerResp(
    @SerialName("data") val data: List<HomeBannerBean>,
    @SerialName("errorCode") val errorCode: Long,
    @SerialName("errorMsg") val errorMsg: String
)


/**
 * @desc：首页-文章列表
 */

@Serializable
data class ArticleResp(
    @SerialName("data") val data: ArticleData? = null,
    @SerialName("errorCode") val errorCode: Long,
    @SerialName("errorMsg") val errorMsg: String
)

@Serializable
data class ArticleData(
    @SerialName("curPage") val curPage: Int = 0,
    @SerialName("datas") val datas: List<Article> = listOf(),
    @SerialName("offset") val offset: Int = 0,
    @SerialName("over") val over: Boolean = false,
    @SerialName("pageCount") val pageCount: Int = 0,
    @SerialName("size") val size: Int = 0,
    @SerialName("total") val total: Int = 0
)

@Serializable
data class Article(
    @SerialName("id") val id: Long = 0,
    @SerialName("apkLink") val apkLink: String = "",
    @SerialName("audit") val audit: Int = 0,
    @SerialName("author") private val author: String = "",
    @SerialName("canEdit") val canEdit: Boolean = false,
    @SerialName("chapterId") val chapterId: Int = 0,
    @SerialName("chapterName") val chapterName: String = "",
    @SerialName("collect") var collect: Boolean = false,
    @SerialName("courseId") val courseId: Int = 0,
    @SerialName("desc") val desc: String = "",
    @SerialName("descMd") val descMd: String = "",
    @SerialName("envelopePic") val envelopePic: String = "",
    @SerialName("fresh") val fresh: Boolean = false,
    @SerialName("host") val host: String = "",
    @SerialName("link") val link: String = "",
    @SerialName("niceDate") val niceDate: String = "",
    @SerialName("niceShareDate") val niceShareDate: String = "",
    @SerialName("origin") val origin: String = "",
    @SerialName("prefix") val prefix: String = "",
    @SerialName("projectLink") val projectLink: String = "",
    @SerialName("publishTime") val publishTime: Long = 0,
    @SerialName("realSuperChapterId") val realSuperChapterId: Int = 0,
    @SerialName("selfVisible") val selfVisible: Int = 0,
    //@SerialName("shareDate") val shareDate: Double = 0,
    @SerialName("shareUser") val shareUser: String = "",
    @SerialName("superChapterId") val superChapterId: Int = 0,
    @SerialName("superChapterName") val superChapterName: String = "",
    @SerialName("tags") val tags: MutableList<ArticleTag> = mutableListOf(),
    @SerialName("title") val title: String = "",
    @SerialName("type") val type: Int = 0,
    @SerialName("userId") val userId: Int = 0,
    @SerialName("visible") val visible: Int = 0,
    @SerialName("zan") val zan: Int = 0,
    @SerialName("originId") val originId: Long = 0
) {
    fun getAuthor(): String {
        return author.ifEmpty { shareUser }
    }
}

@Serializable
data class ArticleTag(
    @SerialName("name") val name: String = "",
    @SerialName("url") val url: String = ""
) {

}

