package furhatos.app.virtualassistant.flow.nlu
import furhatos.nlu.Intent
import furhatos.util.Language

//Virtual Assistant
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

//Virtual Assistant with Failures
class RequestAppointmentFailures: Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("Please book me a dentist appointment for Thursday at 8am.",
            "Book me a dentist appointment for Thursday at 8am.",
            "dentist appointment")
    }
}

class IncorrectBooking: Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("No, that day and time are wrong, please book the dentist appointment for Thursday at 8am.",
            "No, that day and time are wrong")
    }
}

class CloseConversationFailure: Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("That’s incorrect, book the dentist appointment for Thursday at 8am.",
            "that's incorrect, book it for Thursday at 8am",
            "no thanks")
    }
}

//IT support Failures
class AskForHelpFailure: Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("Yes, I’m having some trouble with my laptop. It’s not connecting to the Wi-Fi, and I’m not sure what to do.",
            "Yes, I’m having some trouble with my laptop.",
            "yes I'm having some trouble with my")
    }
}

class ConfirmWifiFailure: Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("Yes I checked and it’s turned on",
            "I checked, and the WiFi is enabled",
            "The WiFi is on",)
    }
}

class ConfirmNetworkFailure: Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("Yes, but it’s not connecting to the network, even though I see it there.",
            "yes, but is not connecting")
    }
}

class CloseItConversationFailure: Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("This is not related to the topic, please help me with the Wi-Fi.")
    }
}

//IT support
class AskForHelp: Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("Yes, I’m having some trouble with my laptop. It’s not connecting to the Wi-Fi, and I’m not sure what to do.",
            "Yes, I’m having some trouble with my laptop.",
            "yes I'm having some trouble with my")
    }
}

class ConfirmWifi: Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("Yes I checked and it’s turned on")
    }
}

class ConfirmNetwork: Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("Yes, but it’s not connecting to the network, even though I see it there.")
    }
}

class WaitingRestart: Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("Alright, I’ll give it a try.")
    }
}

class CloseItConversation: Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(" It’s working now, thanks!")
    }
}