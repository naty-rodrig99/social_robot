package furhatos.app.virtualassistant

import furhatos.app.virtualassistant.flow.Init
import furhatos.flow.kotlin.Flow
import furhatos.skills.Skill

class VirtualassistantSkill : Skill() {
    override fun start() {
        Flow().run(Init)
    }
}

fun main(args: Array<String>) {
    Skill.main(args)
}
