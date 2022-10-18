package dev.lumberisland.core.extends

import java.util.function.Consumer
import java.util.function.Predicate

open class SetExtends {

    fun <E> Set<E>.addIfAbsent(e: E){
        if(contains(e)) return;
        if(this is HashSet<E> ) run {
            val hash: HashSet<E> = this;
            hash.add(e);
        }
    }

    fun <E> Set<E>.invokeIfExists(e: E, consumer: Consumer<E>){
        if(this is HashSet<E>) run {
            val hash: HashSet<E> = this;
            for (any in hash) {
                if(any!! == e) consumer.accept(any);
            }
        }
    }

    fun <E> Set<E>.remove(e: E){
        if(this is HashSet<E>) run {
            val hash: HashSet<E> = this;
            hash.remove(e);
        }
    }

    fun <E> Set<E>.getElements(): Set<E>{
        return toSet();
    }

    fun <E> Set<E>.removeIf(predicate: Predicate<E>){
        for (element in getElements()) {
            if(predicate.test(element)) remove(element);
        }
    }
}