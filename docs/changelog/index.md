# 更新日志

UBAA 的版本号由 `gradle.properties` 管理，应用发布资产由 GitHub Release 工作流生成，客户端版本检查由 server 的 `/api/v1/app/version` 提供。

## 当前版本

- `project.version=1.7.1`
- `project.version.code=24`

## 版本检查

客户端调用：

```text
GET /api/v1/app/version?clientVersion=...
```

服务端返回 `AppVersionCheckResponse`，包含当前版本、最新版本、是否需要更新、下载链接和兼容旧客户端的字段。维护时不要删除旧客户端仍依赖的字段。

## 发布资产

Release 工作流会生成：

- `UBAA-Android-v<version>.apk`
- `UBAA-Linux-v<version>.deb`
- `UBAA-Server-v<version>.jar`
- `UBAA-Web-Wasm-v<version>.zip`
- `UBAA-Web-JS-v<version>.zip`
- `UBAA-iOS-Framework-v<version>.zip`
- `UBAA-Windows-v<version>.exe`

## 记录

### 1.7.1

- 项目版本来自当前 `gradle.properties`。
- 文档站从 VitePress 示例页迁移为源码可追溯的 UBAA 文档。
- 新增 docs 自动构建和 SSH rsync 发布流程。

## 来源文件

- `gradle.properties`
- `.github/workflows/release.yml`
- `server/src/main/kotlin/cn/edu/ubaa/version/AppVersionRoutes.kt`
- `server/src/main/kotlin/cn/edu/ubaa/version/AppVersionService.kt`
- `shared/src/commonMain/kotlin/cn/edu/ubaa/api/auth/UpdateService.kt`
- `server/src/test/kotlin/cn/edu/ubaa/version/AppVersionServiceTest.kt`
