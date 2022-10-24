package dev.lumberisland.core.editor

import org.bukkit.ChatColor
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import java.util.function.Consumer

class ItemEditor(val itemStack: ItemStack) {

    fun edit(consumer: Consumer<ItemStack>){
        consumer.accept(itemStack)
    }

    fun editMeta(consumer: Consumer<ItemMeta>){
        val itemMeta = itemStack.itemMeta
        consumer.accept(itemMeta!!)
        itemStack.itemMeta = itemMeta
    }

    fun display(displayName: String){
        editMeta(consumer = {
            it.setDisplayName(displayName)
        })
    }

    fun lore(lore: List<String>){
        editMeta(consumer = {
            it.lore = lore.stream().map { s -> ChatColor.translateAlternateColorCodes('&', s) } .toList()
        })
    }

    fun modelData(int: Int){
        editMeta(consumer = {
            it.setCustomModelData(int)
        })
    }

}