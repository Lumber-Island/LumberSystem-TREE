package dev.lumberisland.core.objects

import dev.lumberisland.core.Main
import dev.lumberisland.core.extends.MapExtend
import dev.lumberisland.core.objects.schematics.BlockInfo
import dev.lumberisland.core.objects.schematics.Schematic
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

class Regeneration(val tree: Tree, val schematic: Schematic, val time: Long) : MapExtend(){

    private var regeneratedBlocks: List<BlockInfo> = ArrayList()

    private var regenTask: ScheduledFuture<*>? = null

    private var regen_start = 0L
    private var regen_end = 0L

    fun startRegen(){

        if(regenTask != null && !regenTask!!.isDone) return

        var cbtr = 0

        regen_start = System.currentTimeMillis()
        regen_end = regen_start + time

        regenTask = Main.getInstance().scheduledExecutorService.schedule({
            val toEnd = regen_end - System.currentTimeMillis()
            if(toEnd < regeneratedBlocks.size * 10)
            if(cbtr < regeneratedBlocks.size) {
                val getter = schematic.blocks[cbtr++]
                if(getter != null){
                    val location = getter.key
                    val blockInfo = getter.value

                    location.block.type = blockInfo.material
                }
            }
        }, 10, TimeUnit.MILLISECONDS)
    }
}