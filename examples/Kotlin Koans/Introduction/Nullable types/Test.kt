import org.junit.Test as test
import org.junit.Assert

class TestNullableTypes {
    fun testSendMessageToClient(
            client: Client?,
            message: String?,
            expectedEmail: String? = null,
            shouldBeInvoked: Boolean = false
    ) {
        var invoked = false
        val expectedMessage = message
        sendMessageToClient(client, message, object : Mailer {
            public override fun sendMessage(email: String, message: String) {
                invoked = true
                Assert.assertEquals("The message is not as expected:",
                        expectedMessage, message)
                Assert.assertEquals("The email is not as expected:",
                        expectedEmail, email)
            }
        })
        Assert.assertEquals("The function 'sendMessage' should${if (shouldBeInvoked) "" else "n't"} be invoked",
                shouldBeInvoked, invoked)
    }

    @test fun everythingIsOk() {
        testSendMessageToClient(Client(PersonalInfo("bob@gmail.com")),
                "Hi Bob! We have an awesome proposition for you...",
                "bob@gmail.com",
                true)
    }

    @test fun noMessage() {
        testSendMessageToClient(Client(PersonalInfo("bob@gmail.com")), null)
    }

    @test fun noEmail() {
        testSendMessageToClient(Client(PersonalInfo(null)), "Hi Bob! We have an awesome proposition for you...")
    }

    @test fun noPersonalInfo() {
        testSendMessageToClient(Client(null), "Hi Bob! We have an awesome proposition for you...")
    }

    @test fun noClient() {
        testSendMessageToClient(null, "Hi Bob! We have an awesome proposition for you...")
    }
}