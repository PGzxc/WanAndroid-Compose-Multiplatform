package data

import bean.UserInfo
import io.github.xxfast.kstore.KStore

expect val store: KStore<UserInfo>
