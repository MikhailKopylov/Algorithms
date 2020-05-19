package lesson8;


import java.util.LinkedList;

public class HashTableLinked<K, V> implements HashTable<K, V> {

    private static class Item<K, V> {
        private final K key;
        private V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }


    LinkedList<Item<K, V>>[] arrayList;
    private final int size;

    public HashTableLinked(int maxSize) {
        arrayList = new LinkedList[(maxSize << 1)];
        for (int i = 0; i < arrayList.length; i++) {
            arrayList[i] = new LinkedList<>();
        }
        size = arrayList.length;
    }

    @Override
    public boolean put(K key, V value) {
        Item<K, V> item = new Item<>(key, value);
        int index = getHash(key);
        arrayList[index].add(item);
        return true;
    }

    @Override
    public V get(K key) {
        int index = getHash(key);
        LinkedList<Item<K, V>> list = arrayList[index];
        for (Item<K, V> item : list) {
            if (item.key.equals(key)) {
                return item.value;
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = getHash(key);
        LinkedList<Item<K, V>> list = arrayList[index];
        for (int i = 0; i < list.size(); i++) {
            Item<K, V> item = list.get(i);
            if (item.key.equals(key)) {
                V value = item.value;
                list.remove(i);
                return value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    @Override
    public void display() {
        System.out.println("----------");
        for (int i = 0; i < arrayList.length; i++) {
            System.out.printf("%d = [", i);
            for (Item<K, V> item :arrayList[i]) {
                System.out.printf("%s, %s]  ", item.key, item.value);
            }
            System.out.println();
        }
        System.out.println("----------");
    }

    private int getHash(K key) {
        return key.hashCode() % arrayList.length;
    }
}
