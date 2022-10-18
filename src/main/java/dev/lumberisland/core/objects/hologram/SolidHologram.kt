package dev.lumberisland.core.objects.hologram

import org.bukkit.OfflinePlayer

class SolidHologram(override val text: String) : HologramLine {
    override fun canSee(offlinePlayer: OfflinePlayer): Boolean {
        TODO("Not yet implemented")
    }

    override fun show(offlinePlayer: OfflinePlayer) {
        TODO("Not yet implemented")
    }

    override fun hide(offlinePlayer: OfflinePlayer) {
        TODO("Not yet implemented")
    }
}