---
layout: home

hero:
  name: UBAA
  text: 智慧北航 Remake
  tagline: 面向 BUAA 学生的跨平台校园服务聚合客户端与服务端网关。
  actions:
    - theme: brand
      text: 查看功能
      link: /features/
    - theme: alt
      text: 技术文档
      link: /tech/architecture
    - theme: alt
      text: GitHub
      link: https://github.com/BUAASubnet/UBAA

features:
  - title: 多端统一
    details: Android、iOS、Desktop、Web 共用 Kotlin Multiplatform 契约与 Compose Multiplatform UI。
  - title: 校园服务聚合
    details: 覆盖认证、课表、考试、成绩、博雅、空教室、SPOC、希冀、签到、研讨室、阳光打卡和评教。
  - title: 三种连接模式
    details: 客户端可在直连、WebVPN、服务器中转之间选择，按平台能力分发到本地实现或服务端代理。
  - title: 全栈同仓
    details: shared 管理契约和本地实现，server 适配上游并维护会话，composeApp 提供跨平台体验。
  - title: 可发布文档
    details: docs 使用 VitePress 构建，推送 dev 后通过 GitHub Actions 发布到服务器静态目录。
  - title: 可追溯维护
    details: 每页文档列出来源文件，便于后续功能变更时同步更新说明。
---

## 文档入口

- [功能说明](/features/) 面向用户和维护者说明每个模块能做什么。
- [技术文档](/tech/architecture) 面向开发者说明架构、API、配置、测试和部署。
- [公告维护](/announcements/) 说明服务端公告接口和公告内容管理方式。
- [更新日志](/changelog/) 记录版本、发布资产和版本检查接口的关系。

## 项目入口

- 在线使用：[https://app.buaa.team](https://app.buaa.team)
- 发布下载：[GitHub Releases](https://github.com/BUAASubnet/UBAA/releases)
- 源码仓库：[BUAASubnet/UBAA](https://github.com/BUAASubnet/UBAA)

## 来源文件

- `README.md`
- `settings.gradle.kts`
- `gradle.properties`
- `composeApp/src/commonMain/kotlin/cn/edu/ubaa/ui/screens/menu/RegularFeaturesScreen.kt`
- `composeApp/src/commonMain/kotlin/cn/edu/ubaa/ui/screens/menu/AdvancedFeaturesScreen.kt`
