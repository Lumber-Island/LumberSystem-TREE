package dev.lumberisland.core.handlers;

public interface Store<K, V> {

    void setup();

    K getCarrier();

    V getStoredValue();

}
