package data

import bean.UserInfo
import di.appStorage
import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.file.extensions.storeOf
import io.github.xxfast.kstore.file.storeOf


actual val store: KStore<UserInfo> by lazy {
    storeOf("${appStorage}/saved.json", UserInfo())
}