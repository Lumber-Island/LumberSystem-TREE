package dev.lumberisland.core.objects

import dev.lumberisland.core.Main
import dev.lumberisland.core.objects.schematics.BlockInfo
import dev.lumberisland.core.objects.schematics.Schematic
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

class Regeneration(val tree: Tree, val schematic: Schematic) {

    private var regeneratedBlocks: List<BlockInfo> = ArrayList()

    private var regenTask: ScheduledFuture<*>? = null

    fun startRegen(){

        if(regenTask != null && !regenTask!!.isDone) return

        var cbtr = 0

        regenTask = Main.getInstance().scheduledExecutorService.schedule({

        }, 250, TimeUnit.MILLISECONDS)

    }

}