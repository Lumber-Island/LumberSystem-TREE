package dev.lumberisland.core.objects.hologram

import dev.lumberisland.core.extends.SetExtends
import org.bukkit.OfflinePlayer

class TimedHologramLine(override val text: String, time: Long) : HologramLine, SetExtends() {

    private val members: Set<OfflinePlayer> = HashSet();

    private val removeAt: Long = System.currentTimeMillis() + time;

    override fun canSee(offlinePlayer: OfflinePlayer): Boolean {
        return members.contains(offlinePlayer) && removeAt < System.currentTimeMillis()
    }

    override fun show(offlinePlayer: OfflinePlayer) {
        if(removeAt > System.currentTimeMillis())
        members.addIfAbsent(offlinePlayer)
    }

    override fun hide(offlinePlayer: OfflinePlayer) {
        members.removeIf { o -> !canSee(o) || System.currentTimeMillis() > removeAt }
    }

}