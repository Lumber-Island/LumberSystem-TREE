package dev.lumberisland.core.objects

import dev.lumberisland.core.objects.axe.AxeType
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.SoundCategory
import org.bukkit.inventory.ItemStack
import java.util.*

class Tree(val uuid: UUID, val root: Location, val durability: Double, val regeneration: Regeneration, val blocksToDrop: Int, val multiplier: Int) {

    private var current_durability: Double = durability;

    fun damage(itemStack: ItemStack){
        val givenDamage = 0.0
        if(itemStack.type.name.contains("AXE")) {
            val axeType = AxeType.getType(itemStack)
            if(axeType.id == 0) return
            current_durability -= givenDamage
            if(current_durability <= 0) destroy()
            else {
                root.world!!.playSound(root, Sound.ENTITY_ZOMBIE_ATTACK_WOODEN_DOOR, SoundCategory.BLOCKS, 1F, 1F)
            }
        }
    }

    private fun destroy(){
        root.world!!.playSound(root, Sound.ENTITY_ZOMBIE_BREAK_WOODEN_DOOR, SoundCategory.BLOCKS, 1F, 1F);
        regeneration.schematic.blocks.forEach { (t, _) ->  t.block.type = Material.AIR}
        regeneration.startRegen()
    }
}