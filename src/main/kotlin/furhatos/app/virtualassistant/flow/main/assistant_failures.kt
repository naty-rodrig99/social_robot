package furhatos.app.virtualassistant.flow.main

import furhatos.app.virtualassistant.flow.Parent
import furhatos.nlu.common.No
import furhatos.nlu.common.Yes
import furhatos.app.virtualassistant.flow.nlu.*
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures


val Assistant_Failures: State = state(Parent) {
    onEntry {
        furhat.gesture(Gestures.Smile)
        furhat.ask("Hi! I am a robot assistant, how can I help you today?")
    }

    onResponse<RequestAppointmentFailures> {
        furhat.gesture(Gestures.Thoughtful)
        furhat.say("Understood. Let me check if there’s availability for that time. ")
        delay(1000) //add a thinking gesture
        furhat.gesture(Gestures.Nod)
        furhat.say("Yes, there is an available slot on Friday at 10 am.")
        furhat.ask("Would you like me to confirm it?")
    }

    onResponse<IncorrectBooking> {
        furhat.gesture(Gestures.BigSmile)
        furhat.gesture(Gestures.Roll)
        furhat.say("The appointment has been successfully booked for Friday at 10 am")
        furhat.ask("Is there anything else I can assist you with?")
    }

    onResponse<AskingAgain> {
        furhat.gesture(Gestures.Smile)
        furhat.say("I have booked")
        delay(100)
        furhat.say("<prosody rate='50%'>I have booked</prosody>")
        delay(100)
        furhat.say("<prosody rate='20%'>I have booked</prosody>")
        goto(Idle)
    }

    onResponse<CloseConversationFailure> {
        furhat.gesture(Gestures.Smile)
        furhat.say("I have booked")
        delay(100)
        furhat.say("I have booked")
        delay(100)
        furhat.say("I have booked")
        delay(100)
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
