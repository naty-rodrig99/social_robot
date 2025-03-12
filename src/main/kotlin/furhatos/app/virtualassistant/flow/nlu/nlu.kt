package furhatos.app.virtualassistant.flow.nlu
import furhatos.nlu.Intent
import furhatos.util.Language


class RequestAppointment: Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("Please book me a dentist appointment for Thursday at 8am.",
            "Book me a dentist appointment for Thursday at 8am.",
            "dentist appointment")
    }
}

class ConfirmBooking: Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("Yes, please go ahead and confirm it.",
            "Yes",
            "Sure")
    }
}

class RequestReminder: Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("Actually, could you also send a reminder a day before the appointment?")
    }
}

class CloseConversation: Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("No, thank you!")
    }
}