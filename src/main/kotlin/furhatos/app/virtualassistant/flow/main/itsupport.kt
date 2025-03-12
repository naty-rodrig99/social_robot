package furhatos.app.virtualassistant.flow.main

import furhatos.app.virtualassistant.flow.Parent
import furhatos.app.virtualassistant.flow.nlu.*
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.onResponse
import furhatos.flow.kotlin.state
import furhatos.gestures.Gestures

val ItSupport: State = state(Parent) {
    onEntry {
        furhat.gesture(Gestures.Smile)
        furhat.ask("Hi! Are you having technical difficulties?")
    }

    onResponse<AskForHelp> {
        furhat.gesture(Gestures.Thoughtful)
        furhat.say("Let’s troubleshoot the issue.")
        delay(500) //add a thinking gesture
        furhat.gesture(Gestures.Nod)
        furhat.say("First, check if the Wi-Fi is enabled on your laptop.")
        furhat.ask("Can you see the Wi-Fi icon on your screen?")
    }

    onResponse<ConfirmWifi> {
        furhat.say("Good. Now, please ensure that your device is within range of the office network.")
        furhat.ask("Can you see the network name in the list of available connections?")
    }

    onResponse<ConfirmNetwork> {
        furhat.say("It’s possible that the network settings may need to be refreshed. Please try disconnecting and reconnecting to the network, or restart your laptop.")
    }

    onResponse<WaitingRestart> {
        furhat.say("Sure! Let me know when you are ready to continue.")
        delay(5000)
    }

    onResponse<CloseItConversation> {
        furhat.gesture(Gestures.Smile)
        furhat.say("I’m glad to have resolved the issue. If you have any other technical issues, feel free to reach out.")
        goto(Idle)
    }
}