# 模块职责

## shared

`shared` 负责跨平台契约和可复用业务逻辑。`model/dto` 定义网络与 UI 共用数据结构；`api/feature` 定义业务 backend 接口和 relay backend；`api/local` 定义直连/WebVPN 实现；`api/storage` 管理跨平台本地设置。

## composeApp

`composeApp` 负责跨平台 UI 和 ViewModel。`commonMain` 下保存大部分界面，平台 source set 只提供少量能力差异，例如图片选择、字体和返回处理。`webMain` 负责 Wasm/JS Web 入口和资源。

## server

`server` 是 Ktor 后端网关。它维护 JWT、Redis 会话、Refresh Token、分布式锁、上游客户端缓存、Prometheus 指标、公告和版本检查。每个业务模块通常包含 `Routes`、`Service`、必要的上游 `Client` 与测试。

## 平台壳工程

`androidApp` 和 `iosApp` 负责原生平台入口、图标、签名/配置和平台项目结构。业务逻辑不应散落到壳工程中。

## 来源文件

- `settings.gradle.kts`
- `shared/src/commonMain/kotlin/cn/edu/ubaa/api/core/ApiFactory.kt`
- `composeApp/src/commonMain/kotlin/cn/edu/ubaa/App.kt`
- `composeApp/src/webMain/kotlin/cn/edu/ubaa/main.kt`
- `composeApp/src/webMain/resources/index.html`
- `androidApp/src/main/java/cn/edu/ubaa/MainActivity.kt`
- `iosApp/iosApp/iOSApp.swift`
- `server/src/main/kotlin/cn/edu/ubaa/Application.kt`
