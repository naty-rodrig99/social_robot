package furhatos.app.virtualassistant.flow

import furhatos.app.virtualassistant.flow.main.Assistant
import furhatos.app.virtualassistant.flow.main.Idle
import furhatos.app.virtualassistant.flow.main.Greeting
import furhatos.app.virtualassistant.setting.DISTANCE_TO_ENGAGE
import furhatos.app.virtualassistant.setting.MAX_NUMBER_OF_USERS
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.state
import furhatos.flow.kotlin.users
import furhatos.flow.kotlin.voice.Voice
import furhatos.util.Gender
import furhatos.util.Language

val Init: State = state {
    init {
        users.setSimpleEngagementPolicy(DISTANCE_TO_ENGAGE, MAX_NUMBER_OF_USERS)
        //furhat.setCharacter("Ted")
        furhat.voice = Voice(gender = Gender.NEUTRAL, language = Language.ENGLISH_US, pitch = "medium", rate = 1.0)
    }
    onEntry {
        when {
           // furhat.isVirtual() -> goto(Greeting)
            furhat.isVirtual() -> goto(Assistant)
            users.hasAny() -> {
                furhat.attend(users.random)
                //goto(Greeting)
                goto(Assistant)
            }
            else -> goto(Idle)
        }
    }


}
