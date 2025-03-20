package furhatos.app.virtualassistant.flow.main

import furhatos.app.virtualassistant.flow.Parent
import furhatos.nlu.common.No
import furhatos.nlu.common.Yes
import furhatos.app.virtualassistant.flow.nlu.*
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures


val Assistant: State = state(Parent) {
    onEntry {
        furhat.gesture(Gestures.Smile)
        furhat.ask("Hi! I am a robot assistant, how can I help you today?")
    }

    //onUserEnter {
    //    furhat.gesture(Gestures.Smile)
    //    furhat.ask("Hi! I am a robot assistant, how can I help you today?")
    //}

    onResponse<RequestAppointment> {
        furhat.gesture(Gestures.Thoughtful)
        furhat.say("Understood. Let me check if there’s availability for that time. ")
        delay(1000) //add a thinking gesture
        furhat.gesture(Gestures.Nod)
        furhat.say("Yes, there is an available slot on Thursday at 8 am.")
        furhat.ask("Would you like me to confirm it?")
    }

    onResponse<ConfirmBooking> {
        furhat.gesture(Gestures.BigSmile)
        furhat.gesture(Gestures.Roll)
        furhat.say("The appointment has been successfully booked for Thursday at 8 a.m.")
        furhat.ask("Is there anything else I can assist you with?")
    }

    onResponse<RequestReminder> {
        furhat.gesture(Gestures.Blink)
        furhat.gesture(Gestures.Nod)
        furhat.say("Sure, I’ll send you a reminder for the appointment on Wednesday at 8 am.")
        delay(500)
        furhat.ask("Is there anything else I can assist you with?")
    }

    onResponse<CloseConversation> {
        furhat.gesture(Gestures.BigSmile)
        furhat.gesture(Gestures.Roll)
        furhat.say("You're welcome! Have a great day.")
        goto(Idle)
    }

    onNoResponse {
        furhat.gesture(Gestures.Thoughtful)
        furhat.say("Sorry, I didn’t hear anything. Can you say that again?")
    }

    onResponse {
        furhat.gesture(Gestures.Thoughtful)
        furhat.say("Sorry, I didn’t understand that. Can you say that again?")
    }
}

