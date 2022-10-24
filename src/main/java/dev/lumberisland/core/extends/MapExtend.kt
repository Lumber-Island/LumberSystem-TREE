package dev.lumberisland.core.extends

open class MapExtend {

    operator fun <K, V> Map<K, V>.get(id: Int): Getter<K, V>?{
        var currentID = 0

        var valueToGet: Getter<K, V>? = null

        forEach { (t, u) ->
            run {
                if (currentID++ == id) valueToGet = Getter(t, u)
            }
        }

        return valueToGet
    }

    fun <K, V> Map<K, V>.getValueOrNull(id: Int): V?{
        return get(id)?.value
    }

    class Getter<K, V>(val key: K, val value: V) {}

}