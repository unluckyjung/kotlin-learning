fun sendMessageToClient(
    client: Client?, message: String?, mailer: Mailer
) {
    val email = client?.personalInfo?.email

    email?.let {
        message?.let { mailer.sendMessage(email, message) }
    }

//    // docs solution
//    if (email != null && message != null) {
//        mailer.sendMessage(email, message)
//    }
}

class Client(val personalInfo: PersonalInfo?)
class PersonalInfo(val email: String?)
interface Mailer {
    fun sendMessage(email: String, message: String)
}
