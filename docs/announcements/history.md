# 公告历史

当前仓库不保存服务器生产环境的 `announcement.json`，因此这里记录文档站开始维护后的公告索引。

## 记录格式

| 日期 | 公告 ID | 标题 | 状态 | 备注 |
| --- | --- | --- | --- | --- |
| 2026-05-07 | docs-site-bootstrap | 文档站初始化 | 草稿 | 作为公告历史页的起始记录，不代表生产公告已发布。 |

## 维护规则

- 每次生产公告变更后，在此追加一行。
- 不在仓库中提交包含敏感信息或临时维护凭据的公告内容。
- 生产公告实际来源仍以服务器运行目录中的 `announcement.json` 为准。

## 来源文件

- `server/src/main/kotlin/cn/edu/ubaa/announcement/AnnouncementService.kt`
