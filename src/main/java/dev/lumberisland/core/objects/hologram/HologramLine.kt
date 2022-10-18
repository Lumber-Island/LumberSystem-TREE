package dev.lumberisland.core.objects.hologram

import org.bukkit.OfflinePlayer

interface HologramLine {

    val text: String

    fun canSee(offlinePlayer: OfflinePlayer): Boolean

    fun show(offlinePlayer: OfflinePlayer)

    fun hide(offlinePlayer: OfflinePlayer)

}