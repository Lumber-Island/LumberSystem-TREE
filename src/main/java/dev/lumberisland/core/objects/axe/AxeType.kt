package dev.lumberisland.core.objects.axe

import org.bukkit.Material
import org.bukkit.inventory.ItemStack

enum class AxeType(val id: Int, val damage: Double, val material: Material) {

    FORBIDDEN(0, 0.0, Material.AIR),

    DEFAULT_WOODEN(1, 0.5, Material.WOODEN_AXE),
    DEFAULT_STONE(2, 1.0, Material.STONE_AXE),
    DEFAULT_IRON(3, 2.0, Material.IRON_AXE),
    DEFAULT_GOLD(4, 5.0, Material.GOLDEN_AXE),
    DEFAULT_DIAMOND(5, 4.0, Material.DIAMOND_AXE),
    DEFAULT_NETHERITE(6, 4.5, Material.NETHERITE_AXE);

    companion object {
        fun build(axeType: AxeType): ItemStack{
            val itemStack = ItemStack(axeType.material);
            val itemMeta = itemStack.itemMeta!!

            itemMeta.setCustomModelData(axeType.id)
            itemStack.itemMeta = itemMeta;
            return itemStack;
        }

        fun getType(itemStack: ItemStack): AxeType{
            val id = itemStack.itemMeta!!.customModelData
            for (value in values()) {
                if(value.id == id) return value
            }
            return FORBIDDEN;
        }
    }
}