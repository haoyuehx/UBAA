# 测试与质量

UBAA 的测试覆盖 shared、composeApp 和 server。文档只改 docs 时至少需要 VitePress 构建验证；改源码时按影响范围选择 Gradle 测试。

## 常用命令

```bash
npm ci
npm run docs:build
./gradlew.bat :shared:jvmTest
./gradlew.bat :composeApp:jvmTest
./gradlew.bat :server:test
./gradlew.bat spotlessCheck
```

跨平台共享逻辑变更可继续运行：

```bash
./gradlew.bat :shared:compileKotlinJs :shared:compileKotlinWasmJs :shared:compileKotlinIosSimulatorArm64 :shared:compileAndroidMain
```

## 测试分层

- shared tests：API 分发、本地直连/WebVPN、DTO 和存储。
- composeApp tests：ViewModel、首页待办、筛选排序、显示逻辑。
- server tests：Ktor 路由、服务、解析器、指标和健康检查。
- browser verification：Wasm/JS UI 变更需要启动 server 和 web dev server 后用 Playwright 验证。

## 文档验证

docs 改动必须运行 `npm ci` 和 `npm run docs:build`。构建失败、死链或未提交 lockfile 都应阻止发布。

## 来源文件

- `build.gradle.kts`
- `shared/build.gradle.kts`
- `composeApp/build.gradle.kts`
- `server/build.gradle.kts`
- `.github/workflows/test.yml`
- `.github/workflows/format.yml`
- `composeApp/src/commonTest/kotlin/cn/edu/ubaa/ui/HomeTodoTest.kt`
- `shared/src/commonTest/kotlin/cn/edu/ubaa/api/ApiFactoryDispatchTest.kt`
- `server/src/test/kotlin/cn/edu/ubaa/ApplicationTest.kt`
