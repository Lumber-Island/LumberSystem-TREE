package dev.lumberisland.core.extends

class MapExtend {

    fun <K, V> Map<K, V>.get(id: Int): Getter<K, V>?{
        var currentID = 0

        var valueToGet: Getter<K, V>? = null

        forEach { (t, u) ->
            run {
                if (currentID++ == id) valueToGet = Getter(t, u)
            }
        }

        return valueToGet
    }

    class Getter<K, V>(val key: K, val value: V) {}

}