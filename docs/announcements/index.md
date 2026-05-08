# 公告维护

UBAA 服务端通过 `GET /api/v1/app/announcement` 提供启动公告。客户端获取到公告后展示标题、正文、确认按钮和可选链接，并在本地记录已读状态。

## 配置文件

服务端默认读取运行目录下的 `announcement.json`。该文件包含：

```json
{
  "enabled": true,
  "id": "2026-05-07-maintenance",
  "title": "维护公告",
  "content": "公告正文，可包含普通文本和链接。",
  "confirmText": "知道了",
  "linkUrl": "https://example.com"
}
```

字段规则：

- `enabled=false` 时接口返回 `204 No Content`。
- `id`、`title`、`content` 为空时不展示公告。
- `confirmText` 和 `linkUrl` 可省略。
- 更新公告时必须更换 `id`，否则已读用户不会再次看到。

## 发布流程

1. 在服务器运行目录更新 `announcement.json`。
2. 确认 JSON 可被 kotlinx.serialization 解析。
3. 请求 `/api/v1/app/announcement` 验证状态码和内容。
4. 客户端链接由 `ReleaseNotesText` 支持 Markdown 链接和裸 URL。

## 来源文件

- `server/src/main/kotlin/cn/edu/ubaa/announcement/AnnouncementRoutes.kt`
- `server/src/main/kotlin/cn/edu/ubaa/announcement/AnnouncementService.kt`
- `shared/src/commonMain/kotlin/cn/edu/ubaa/api/auth/AnnouncementService.kt`
- `shared/src/commonMain/kotlin/cn/edu/ubaa/api/storage/AnnouncementReadStore.kt`
- `composeApp/src/commonMain/kotlin/cn/edu/ubaa/ui/common/components/ReleaseNotesText.kt`
- `server/src/test/kotlin/cn/edu/ubaa/announcement/AnnouncementRoutesTest.kt`
- `server/src/test/kotlin/cn/edu/ubaa/announcement/AnnouncementServiceTest.kt`
