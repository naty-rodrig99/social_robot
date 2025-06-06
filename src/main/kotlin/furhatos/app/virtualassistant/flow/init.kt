package furhatos.app.virtualassistant.flow

import furhatos.app.virtualassistant.flow.main.*
import furhatos.app.virtualassistant.setting.DISTANCE_TO_ENGAGE
import furhatos.app.virtualassistant.setting.MAX_NUMBER_OF_USERS
import furhatos.flow.kotlin.*
import furhatos.flow.kotlin.voice.Voice
import furhatos.util.Gender
import furhatos.util.Language

val Init: State = state {
    init {
        users.setSimpleEngagementPolicy(DISTANCE_TO_ENGAGE, MAX_NUMBER_OF_USERS)
        //furhat.setCharacter("Ted")
        //furhat.say {+"Turn your text into speech using cutting-edge AI"
        //    +Audio("classpath:testing2.wav", "Turn your text into speech using cutting-edge AI") }
        furhat.voice = Voice("Kendra", pitch="low")
    }
    onEntry {
        when {
           //furhat.isVirtual() -> goto(Greeting)
            //furhat.isVirtual() -> goto(Assistant)
            //furhat.isVirtual() -> goto(Assistant_Failures)
            //furhat.isVirtual() -> goto(ItSupport)
            furhat.isVirtual() -> goto(ItSupport_Failures)
            users.hasAny() -> {
                furhat.attend(users.random)
                //goto(Greeting)
                //goto(Assistant)
                //goto(Assistant_Failures)
                //goto(ItSupport)
                goto(ItSupport_Failures)
            }
            else -> goto(Idle)
        }
    }


}
