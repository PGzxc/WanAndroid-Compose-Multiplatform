package bean

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MessageResp(
    @SerialName("data") val data: MessageBeanData ? = null,
    @SerialName("errorCode") val errorCode: Long,
    @SerialName("errorMsg") val errorMsg: String
)

@Serializable
data class MessageBeanData(
    @SerialName("curPage") val curPage: Long = 0,
    @SerialName("datas") val datas: List<MessageItem> = emptyList(),
    @SerialName("offset") val offset: Long = 0,
    @SerialName("over") val over: Boolean = false,
    @SerialName("pageCount") val pageCount: Long = 0,
    @SerialName("size") val size: Long = 0,
    @SerialName("total") val total: Long = 0
)

@Serializable
data class MessageItem(
    @SerialName("category") val category: Long = 0,
    @SerialName("date") val date: Long = 0,
    @SerialName("fromUser") val fromUser: String = "",
    @SerialName("fromUserId") val fromUserId: Long = 0,
    @SerialName("fullLink") val fullLink: String = "",
    @SerialName("id") val id: Long = 0,
    @SerialName("isRead") val isRead: Long = 0,
    @SerialName("link") val link: String = "",
    @SerialName("message") val message: String = "",
    @SerialName("niceDate") val niceDate: String = "",
    @SerialName("tag") val tag: String = "",
    @SerialName("title") val title: String = "",
    @SerialName("userId") val userId: Long = 0
)