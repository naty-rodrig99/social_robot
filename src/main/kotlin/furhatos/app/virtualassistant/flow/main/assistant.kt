package furhatos.app.virtualassistant.flow.main

import furhatos.app.virtualassistant.flow.Parent
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.onResponse
import furhatos.flow.kotlin.state
import furhatos.nlu.common.No
import furhatos.nlu.common.Yes
import furhatos.app.virtualassistant.flow.nlu.RequestAppointment
import furhatos.app.virtualassistant.flow.nlu.ConfirmBooking
import furhatos.app.virtualassistant.flow.nlu.RequestReminder
import furhatos.app.virtualassistant.flow.nlu.CloseConversation


val Assistant: State = state(Parent) {
    onEntry {
        furhat.ask("Hi! I am a robot assistant, how can I help you today?")
    }

    onResponse<RequestAppointment> {
        furhat.say("Understood. Let me check if there’s availability for that time. ")
        delay(1000) //add a thinking gesture
        furhat.say("Yes, there is an available slot on Thursday at 8 am.")
        furhat.ask("Would you like me to confirm it?")
    }

    onResponse<ConfirmBooking> {
        furhat.say("The appointment has been successfully booked for Thursday at 8 a.m.")
        furhat.ask("Is there anything else I can assist you with?")
    }

    onResponse<RequestReminder> {
        furhat.say("Sure, I’ll send you a reminder for the appointment on Wednesday at 9 am.")
        delay(500)
        furhat.ask("Is there anything else I can assist you with?")
    }

    onResponse<CloseConversation> {
        furhat.say("You're welcome! Have a great day.")
        goto(Idle)
    }
}

