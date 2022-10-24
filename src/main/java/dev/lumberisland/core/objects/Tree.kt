package dev.lumberisland.core.objects

import dev.lumberisland.core.objects.axe.AxeType
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.SoundCategory
import org.bukkit.inventory.ItemStack
import org.bukkit.util.Vector
import java.util.*

class Tree(val uuid: UUID, val root: Location, private val durability: Double, val regeneration: Regeneration, var blocksToDrop: Int, var multiplier: Int) {

    private var current_durability: Double = durability;
    var x_min = 0.0
    var x_max = 0.0
    var z_min = 0.0
    var z_max = 0.0

    var up_corner: Location? = null
    var down_corner: Location? = null

    fun isIn(location: Location): Boolean {
        if(up_corner == null || down_corner == null){
            up_corner = Vector(root.x + x_max, root.y + regeneration.schematic.getMaxY(root), root.z + z_max).toLocation(root.world!!)
            down_corner = Vector(root.x + x_min, root.y + regeneration.schematic.getMinY(root), root.z + z_min).toLocation(root.world!!)
        }
        return  up_corner!!.x >= location.x && up_corner!!.y >= location.y && up_corner!!.z >= location.z
                                                        &&
                down_corner!!.x <= location.x && down_corner!!.y <= location.y && down_corner!!.z <= down_corner!!.z
    }

    fun damage(itemStack: ItemStack){
        val givenDamage = 0.0
        if(itemStack.type.name.contains("AXE")) {
            val axeType = AxeType.getType(itemStack)
            if(axeType.id == 0) return
            current_durability -= givenDamage
            if(current_durability <= 0) {
                destroy()
                root.world!!.playSound(root, Sound.ENTITY_ZOMBIE_BREAK_WOODEN_DOOR, SoundCategory.BLOCKS, 1F, 1F)
            }
            else {
                root.world!!.playSound(root, Sound.ENTITY_ZOMBIE_ATTACK_WOODEN_DOOR, SoundCategory.BLOCKS, 1F, 1F)
            }
        }
    }

    private fun destroy(){
        current_durability = durability
        root.block.setType(Material.OAK_SAPLING, false)
        regeneration.schematic.blocks.forEach { (t, _) ->  t.block.type = Material.AIR}
        regeneration.startRegen()
    }
}