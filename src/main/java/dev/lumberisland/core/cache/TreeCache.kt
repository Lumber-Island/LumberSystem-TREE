package dev.lumberisland.core.cache

import java.util.UUID
import java.util.HashMap
import dev.lumberisland.core.objects.Regeneration
import dev.lumberisland.core.objects.Tree
import org.bukkit.Location

class TreeCache{

    private val cache: MutableMap<UUID, Tree> = HashMap()

    fun getCache(): Map<UUID, Tree> {
        return cache
    }

    operator fun get(uuid: UUID): Tree? {
        return cache[uuid]
    }

    operator fun get(location: Location): Tree? {
        return cache.values.filter { value -> value.isIn(location) }.getOrNull(0)
    }

    fun build(
        uuid: UUID,
        root: Location,
        durability: Double,
        regeneration: Regeneration,
        blocksToDrop: Int,
        multiplier: Int
    ): Tree {
        var tree = cache[uuid]
        if (tree == null) {
            tree = Tree(uuid, root, durability, regeneration, blocksToDrop, multiplier)
            cache[uuid] = tree
        }
        val size = regeneration.schematic.getSize(root)
        tree.z_min = size.toDouble()
        tree.z_max = size.toDouble()
        tree.x_min = size.toDouble()
        tree.x_max = size.toDouble()
        return tree
    }

    companion object {
        var instance: TreeCache? = null
            get() {
                if (field == null) field = TreeCache()
                return field
            }
    }
}