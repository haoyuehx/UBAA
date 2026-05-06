package cn.edu.ubaa.ui.screens.judge

import cn.edu.ubaa.model.dto.JudgeAssignmentSummaryDto
import cn.edu.ubaa.model.dto.JudgeSubmissionStatus
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class JudgeAssignmentDisplayTest {
  @Test
  fun `unknown summary status is not displayed as a status chip`() {
    val assignment =
        assignment(
            submissionStatus = JudgeSubmissionStatus.UNKNOWN,
            submissionStatusText = "未知状态",
        )

    assertFalse(assignment.shouldShowJudgeSummaryStatus())
  }

  @Test
  fun `known summary status is displayed as a status chip`() {
    val assignment =
        assignment(
            submissionStatus = JudgeSubmissionStatus.PARTIAL,
            submissionStatusText = "进行中(1/2)",
        )

    assertTrue(assignment.shouldShowJudgeSummaryStatus())
  }

  @Test
  fun `summary info omits unavailable time values`() {
    val assignment =
        assignment(
            startTime = null,
            dueTime = null,
            totalProblems = 0,
            submittedCount = 0,
            maxScore = null,
            myScore = null,
        )

    assertEquals(emptyList(), assignment.judgeSummaryInfoLines())
  }

  @Test
  fun `summary info keeps available progress and score values`() {
    val assignment =
        assignment(
            startTime = "2026-04-20 19:00:00",
            dueTime = "2026-05-03 23:00:00",
            totalProblems = 2,
            submittedCount = 1,
            maxScore = "100",
            myScore = null,
        )

    assertEquals(
        listOf(
            "开始：2026-04-20 19:00:00",
            "截止：2026-05-03 23:00:00",
            "进度：1/2",
            "分数：无 / 100",
        ),
        assignment.judgeSummaryInfoLines(),
    )
  }

  private fun assignment(
      submissionStatus: JudgeSubmissionStatus = JudgeSubmissionStatus.UNKNOWN,
      submissionStatusText: String = "未知状态",
      startTime: String? = null,
      dueTime: String? = null,
      totalProblems: Int = 0,
      submittedCount: Int = 0,
      maxScore: String? = null,
      myScore: String? = null,
  ): JudgeAssignmentSummaryDto =
      JudgeAssignmentSummaryDto(
          courseId = "1",
          courseName = "软件工程",
          assignmentId = "101",
          title = "设计作业",
          startTime = startTime,
          dueTime = dueTime,
          maxScore = maxScore,
          myScore = myScore,
          totalProblems = totalProblems,
          submittedCount = submittedCount,
          submissionStatus = submissionStatus,
          submissionStatusText = submissionStatusText,
      )
}
