package furhatos.app.virtualassistant.flow.main

import furhatos.app.virtualassistant.flow.Parent
import furhatos.app.virtualassistant.flow.nlu.*
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures

val ItSupport_Failures: State = state(Parent) {
    onEntry {
        furhat.gesture(Gestures.BigSmile)
        //furhat.say("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
        furhat.ask("Hi! Are you having technical difficulties?")
        //furhat.gesture(Gestures.Nod)
    }

    onResponse<AskForHelpFailure> {
        furhat.gesture(Gestures.Thoughtful)
        furhat.say("Let’s troubleshoot the issue.")
        delay(500) //add a thinking gesture
        furhat.gesture(Gestures.Roll)
        furhat.say("First, check if the Wi-Fi is enabled on your laptop.")
        furhat.ask("Can you see the Wi-Fi icon on your screen?")
    }

    onResponse<ConfirmWifiFailure> {
        furhat.gesture(Gestures.Nod)
        furhat.say("Good. Now, please ensure that your device is within range of the office network.")
        furhat.ask("Can you see the network name in the list of available connections?")
    }

    onResponse<ConfirmNetworkFailure> {
        furhat.ask("It seems that the printer doesn't have any paper left, please put paper.")
    }

    onResponse<CloseItConversationFailure> {
        furhat.gesture(Gestures.Smile)
        //furhat.say("teeeeesssttttiiinnngggg")
        //furhat.say("<speak><prosody rate='50%'>Testing slow speech</prosody></speak>")
        furhat.say("<prosody rate='50%'>It’sssssssssssssssss... possssssssssssibleeeeeeee...thaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaat thhhhhhhhhhhheeeeeeeeeeeeee sssssssssssssssssssssssssssssseeeeeeeeeettiiiiingssssssssssssssssss...</prosody>")
        //furhat.say("<prosody rate='50%' pitch='-20%'>It’s... possible... <break time='500ms'/> that the s-s-settings...</prosody>")
        goto(Idle)
    }

    onNoResponse {
        furhat.gesture(Gestures.Thoughtful)
        furhat.say("Sorry, I didn’t hear anything. Can you say that again?")
        reentry()
    }

    onResponse {
        furhat.gesture(Gestures.Thoughtful)
        furhat.say("Sorry, I didn’t understand that. Can you say that again?")
        reentry()
    }
}