package dev.lumberisland.core.objects.schematics

import org.bukkit.Location
import kotlin.math.roundToInt

class Schematic(val blocks: Map<Location, BlockInfo>) {

    fun getSize(root: Location): Int{
        var _distance = 0.0
        for (block in blocks) {
            val dist = block.key.distance(root)
            if(dist > _distance) _distance = dist
        }
        return _distance.roundToInt()
    }

    fun getMinY(root: Location): Int{
        var _y = 0.0
        for (block in blocks) {
            val y = block.key.y
            if(_y == 0.0 || y < _y) _y = y
        }
        return _y.roundToInt()
    }

    fun getMaxY(root: Location): Int{
        var _y = 0.0
        for (block in blocks) {
            val y = block.key.y
            if(_y == 0.0 || y > _y) _y = y
        }
        return _y.roundToInt()
    }

    fun getMinX(root: Location): Int{
        var _x = 0.0
        for (block in blocks) {
            val x = block.key.x
            if(_x == 0.0 || x < _x) _x = x
        }
        return _x.roundToInt()
    }

    fun getMaxX(root: Location): Int{
        var _x = 0.0
        for (block in blocks) {
            val x = block.key.x
            if(_x == 0.0 || x > _x) _x = x
        }
        return _x.roundToInt()
    }

    fun getMinZ(root: Location): Int{
        var _z = 0.0
        for (block in blocks) {
            val z = block.key.z
            if(_z == 0.0 || z < _z) _z = z
        }
        return _z.roundToInt()
    }

    fun getMaxZ(root: Location): Int{
        var _z = 0.0
        for (block in blocks) {
            val z = block.key.z
            if(_z == 0.0 || z > _z) _z = z
        }
        return _z.roundToInt()
    }


}