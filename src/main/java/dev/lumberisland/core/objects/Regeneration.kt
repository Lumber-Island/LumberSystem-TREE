package dev.lumberisland.core.objects

import dev.lumberisland.core.Main
import dev.lumberisland.core.extends.MapExtend
import dev.lumberisland.core.objects.schematics.BlockInfo
import dev.lumberisland.core.objects.schematics.Schematic
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

class Regeneration(val tree: Tree, val schematic: Schematic) : MapExtend(){

    private var regeneratedBlocks: List<BlockInfo> = ArrayList()

    private var regenTask: ScheduledFuture<*>? = null

    fun startRegen(){

        if(regenTask != null && !regenTask!!.isDone) return

        var cbtr = 0

        regenTask = Main.getInstance().scheduledExecutorService.schedule({
            if(cbtr < regeneratedBlocks.size) {
                val getter = schematic.blocks.get(cbtr++)
                if(getter != null){
                    val location = getter.key
                    val blockInfo = getter.value

                    location.block.type = blockInfo.material
                }

            }
        }, 250, TimeUnit.MILLISECONDS)

    }

}