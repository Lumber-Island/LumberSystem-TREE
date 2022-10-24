package dev.lumberisland.core

import dev.lumberisland.core.cache.TreeCache
import dev.lumberisland.core.objects.Tree
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent

class HandleListeners : Listener {

    @EventHandler
    fun handlePlayerBlockBreakEvent(event: BlockBreakEvent){

        val tree: Tree = TreeCache.instance!![event.block.location] ?: return
        event.isCancelled = true

        if(tree.regeneration.time > System.currentTimeMillis()) return
        tree.damage(event.player.equipment!!.itemInMainHand)

    }

}