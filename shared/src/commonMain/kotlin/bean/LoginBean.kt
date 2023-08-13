package bean

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @desc：注册接口实体类
 */
@Serializable
data class RegisterResp(
    @SerialName("data") val data: UserInfo,
    @SerialName("errorCode") val errorCode: Long,
    @SerialName("errorMsg") val errorMsg: String
)

//RegisterInfo==UserInfo
@Serializable
data class RegisterInfo(
    @SerialName("admin") val admin: Boolean,
    @SerialName("chapterTops") val chapterTops: List<String?>,
    @SerialName("coinCount") val coinCount: Long,
    @SerialName("collectIDS") val collectIDS: List<String?>,
    @SerialName("email") val email: String,
    @SerialName("icon") val icon: String,
    @SerialName("id") val id: Long,
    @SerialName("nickname") val nickname: String,
    @SerialName("password") val password: String,
    @SerialName("publicName") val publicName: String,
    @SerialName("token") val token: String,
    @SerialName("type") val type: Long,
    @SerialName("username") val username: String
)

/**
 * @desc：登录接口实体类
 */
@Serializable
data class UserResp(
    @SerialName("data") var data: UserInfo? = null,
    @SerialName("errorCode") val errorCode: Long,
    @SerialName("errorMsg") val errorMsg: String
)
@Serializable
data class UserInfo(
    @SerialName("admin") val admin: Boolean = false,
    @SerialName("chapterTops") val chapterTops: List<String?> = emptyList(),
    @SerialName("coinCount") val coinCount: Long = 0,
    @SerialName("collectIds") val collectIds: List<Long> = emptyList(),
    @SerialName("email") val email: String = "",
    @SerialName("icon") val icon: String = "",
    @SerialName("id") val id: Long = 0,
    @SerialName("nickname") val nickname: String = "",
    @SerialName("password") val password: String = "",
    @SerialName("publicName") val publicName: String = "",
    @SerialName("token") val token: String = "",
    @SerialName("type") val type: Long = 0,
    @SerialName("username") val username: String = ""
)