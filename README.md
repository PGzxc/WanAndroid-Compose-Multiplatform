# WanAndroid-Compose-Multiplatform

## 一 开发环境
* 软件系统：MacOS 13.5
* 开发工具：Android Studio Giraffe|2022.3.1
* JRE：18.0.1

## 二 项目创建(基于模版)

### 2.1 模版

* [compose-multiplatform-template](https://github.com/JetBrains/compose-multiplatform-template#readme)

### 2.2 模版修改

#### 项目名称(settings.gradles.kts)

* rootProject.name

#### androidApp(build.gradle.kts)

* namespace：设置包名
* applicationId
* src/androidMain/kotlin下面的包名与namespace一样

#### iosApp

```
kdoctor --team-ids
```

执行上面的指令，获取Apple Team ID

iosApp/Configuration/Config.xcconfig配置以下信息

* TEAM_ID：Apple Team ID
*  BUNDLE_ID：包名
* APP_NAME：项目名称

#### desktopApp(build.gradle.kts)

* packageName：应用名称
* packageVersion：版本

## 三 版本

### v1.0

* 基于模版[compose-multiplatform-template](https://github.com/JetBrains/compose-multiplatform-template#readme)创建项目

### v2.0

添加依赖：

* compose.materialIconsExtended：Icon扩展
* compose.animation：动画
* voyager-navigator：voyager库
* voyager-transitions：voyager库

内容修改：

* desktopApp，通过Window.title修改标题显示
* 主题设置
* 项目框架搭建(首页、导航、项目、消息、我的)
