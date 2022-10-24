package dev.lumberisland.core.events

import dev.lumberisland.core.events.system.PluginEvent
import dev.lumberisland.core.events.system.stereotype.EventHandler
import dev.lumberisland.core.events.system.stereotype.EventLimiter
import dev.lumberisland.core.objects.Tree
import org.bukkit.entity.Player
import java.util.function.Consumer

class PlayerBreakTreeEvent(val player: Player, val tree: Tree) : PluginEvent<PlayerBreakTreeEvent> {

    override fun getEvent(): PlayerBreakTreeEvent {
        return this
    }

    override fun getEventList(): MutableSet<Consumer<PlayerBreakTreeEvent>> {
        return events
    }

    companion object {
        @EventHandler
        @EventLimiter(size = 5)
        private val events: MutableSet<Consumer<PlayerBreakTreeEvent>> = HashSet()
    }
}