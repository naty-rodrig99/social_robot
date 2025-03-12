package furhatos.app.virtualassistant.flow.main

import furhatos.app.virtualassistant.flow.Parent
import furhatos.app.virtualassistant.flow.nlu.*
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.onResponse
import furhatos.flow.kotlin.state
import furhatos.gestures.Gestures

val ItSupport_Failures: State = state(Parent) {
    onEntry {
        furhat.gesture(Gestures.Smile)
        furhat.ask("Hi! Are you having technical difficulties?")
    }

    onResponse<AskForHelpFailure> {
        furhat.gesture(Gestures.Thoughtful)
        furhat.say("Let’s troubleshoot the issue.")
        delay(500) //add a thinking gesture
        furhat.gesture(Gestures.Nod)
        furhat.say("First, check if the Wi-Fi is enabled on your laptop.")
        furhat.ask("Can you see the Wi-Fi icon on your screen?")
    }

    onResponse<ConfirmWifiFailure> {
        furhat.say("Good. Now, please ensure that your device is within range of the office network.")
        furhat.ask("Can you see the network name in the list of available connections?")
    }

    onResponse<ConfirmNetworkFailure> {
        furhat.say("It seems that the printer doesn't have any paper left, please put paper.")
    }

    onResponse<CloseItConversationFailure> {
        furhat.gesture(Gestures.Smile)
        //furhat.say("teeeeesssttttiiinnngggg")
        //furhat.say("<speak><prosody rate='50%'>Testing slow speech</prosody></speak>")
        furhat.say("It’s... possible...that the s-s-settings...")
        //furhat.say("<prosody rate='50%' pitch='-20%'>It’s... possible... <break time='500ms'/> that the s-s-settings...</prosody>")
        goto(Idle)
    }
}