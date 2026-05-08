# 研讨室预约

研讨室预约模块覆盖场地查询、预约目的、日期时段、预约提交、订单列表、取消订单和门锁码。直连模式和服务器中转都要处理验证码、签名和上游接口异常。

## 用户能力

- 查看可预约场地和空间。
- 选择预约目的、日期和时段。
- 填写预约表单并提交预约。
- 查看个人预约订单、订单详情、取消预约和门锁码。

## 技术路径

- UI 分为首页、空间选择、预约表单、订单列表和门锁码页。
- `CgyyViewModel` 管理预约流程状态、表单存储和订单加载。
- `CgyyApiBackend` 是 shared 层契约；`LocalCgyyApiBackend` 实现直连/WebVPN。
- `CgyyService` 和 `CgyyZhjsClient` 处理服务器中转、上游登录、验证码、目的类型和订单操作。
- 预约类型为空或解析失败时，本地实现应保留 fallback 目的类型，避免直连模式无法选择预约类型。

## 接口

- `GET /api/v1/cgyy/sites`
- `GET /api/v1/cgyy/purpose-types`
- `GET /api/v1/cgyy/day-info`
- `POST /api/v1/cgyy/reservations`
- `GET /api/v1/cgyy/orders/lock-code`
- `GET /api/v1/cgyy/orders/{orderId}`
- `POST /api/v1/cgyy/orders/{orderId}/cancel`

## 来源文件

- `composeApp/src/commonMain/kotlin/cn/edu/ubaa/ui/screens/cgyy/CgyyHomeScreen.kt`
- `composeApp/src/commonMain/kotlin/cn/edu/ubaa/ui/screens/cgyy/CgyyReservePickerScreen.kt`
- `composeApp/src/commonMain/kotlin/cn/edu/ubaa/ui/screens/cgyy/CgyyReserveFormScreen.kt`
- `composeApp/src/commonMain/kotlin/cn/edu/ubaa/ui/screens/cgyy/CgyyOrdersScreen.kt`
- `composeApp/src/commonMain/kotlin/cn/edu/ubaa/ui/screens/cgyy/CgyyLockCodeScreen.kt`
- `composeApp/src/commonMain/kotlin/cn/edu/ubaa/ui/screens/cgyy/CgyyViewModel.kt`
- `shared/src/commonMain/kotlin/cn/edu/ubaa/api/feature/CgyyApi.kt`
- `shared/src/commonMain/kotlin/cn/edu/ubaa/api/local/LocalCgyyApi.kt`
- `shared/src/commonMain/kotlin/cn/edu/ubaa/model/dto/Cgyy.kt`
- `server/src/main/kotlin/cn/edu/ubaa/cgyy/CgyyRoutes.kt`
- `server/src/main/kotlin/cn/edu/ubaa/cgyy/CgyyService.kt`
- `server/src/main/kotlin/cn/edu/ubaa/cgyy/CgyyZhjsClient.kt`
- `composeApp/src/commonTest/kotlin/cn/edu/ubaa/ui/CgyyViewModelTest.kt`
- `server/src/test/kotlin/cn/edu/ubaa/cgyy/CgyyRoutesTest.kt`
