package basic.mockk

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.clearMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

class MockkVerityKotest : BehaviorSpec({

    val verityTest = mockk<MockkVerityJunitTest.VerifyClass>(relaxed = true)

    // 테스트 수행후 verify Count 를 초기화한다.
    afterTest {
        clearMocks(
            verityTest,
            answers = false,
            recordedCalls = true,
            childMocks = false,
            verificationMarks = true,
            exclusionRules = false
        )
    }


    given("모킹된 객체가") {
        val nickName = "goodall"
        every {
            verityTest.run()
        } returns nickName

        `when`("2번 호출되었을 때") {
            verityTest.run() shouldBe nickName
            verityTest.run() shouldBe nickName

            then("2번 호출되었음을 검증할 수 있다.") {
                verify(exactly = 2) {
                    verityTest.run()
                }
            }
        }

        `when`("1번 호출되었을때") {
            verityTest.run() shouldBe nickName

            then("1번 호출되었음을 검증할 수 있다.") {
                verify(exactly = 1) {
                    verityTest.run()
                }
            }
        }
    }

    class VerifyClass {
        fun run(): String {
            return "run"
        }
    }
})


