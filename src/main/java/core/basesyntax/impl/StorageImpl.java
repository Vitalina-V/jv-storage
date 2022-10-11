package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private final K[] keys = (K[]) new Object[10];
    private final V[] values = (V[]) new Object[10];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (key == keys[i] && i < size || key != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == key || key != null && key.equals(keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
