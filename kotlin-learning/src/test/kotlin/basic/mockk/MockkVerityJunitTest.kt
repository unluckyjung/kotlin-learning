package basic.mockk

import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test

class MockkVerityJunitTest {
    private val verityTest = mockk<VerifyClass>(relaxed = true)
    private val nickName = "goodall"

    @BeforeEach
    internal fun setUp() {
        every{
            verityTest.run()
        } returns nickName
    }

    @Order(1)
    @Test
    fun test1(){
        repeat(2){
            verityTest.run() shouldBe nickName
        }

        verify(exactly = 2){
            verityTest.run()
        }
    }

    @Order(2)
    @Test
    fun test2(){
        repeat(1){
            verityTest.run() shouldBe nickName
        }

        verify(exactly = 1){
            verityTest.run()
        }
    }

    inner class VerifyClass {
        fun run(): String {
            return "run"
        }
    }
}

