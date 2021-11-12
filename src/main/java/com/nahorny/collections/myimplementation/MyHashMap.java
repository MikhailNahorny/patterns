package com.nahorny.collections.myimplementation;

import java.util.*;

public class MyHashMap<K, V> implements Map<K, V> {
    private int size;
    private static final int NUM_BUCKETS = 32;
    public Entry<K, V>[] data = new Entry[NUM_BUCKETS];

    private int bucket(Object key) {
        return Math.abs(key.hashCode()) % NUM_BUCKETS;
    }

    //Map contract

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        if (key == null) throw new NullPointerException("not NULL argument required");
        int index = bucket(key);
        Entry<K, V> last = data[index];
        if (last == null) return false;
        do {
            if (last.key.equals(key)) return true;
        } while (last.next != null);
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        if (value == null) throw new NullPointerException("not NULL argument required");
        for (Entry<K, V> current : data) {
            if (current != null) {
                do {
                    if (current.value.equals(value)) return true;
                } while (current.next != null);
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        int index = bucket(key);
        Entry<K, V> current = data[index];

        while (current != null) {
            K k = current.key;
            if (k.equals(key)) {
                return current.getValue();
            } else {
                current = current.next;
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        if (key == null) throw new NullPointerException("not NULL argument required");
        int index = bucket(key);
        Entry<K, V> last = data[index];
        data[index] = new Entry(last, key, value);
        size++;
        return value;
    }

    @Override
    public V remove(Object key) {
        if (key == null) throw new NullPointerException("not NULL argument required");
        int index = bucket(key);
        Entry<K, V> current = data[index];
        if (current != null && current.next == null) {
            data[index] = null;
            size--;
            return current.getValue();
        } else {
            Entry<K, V> prev = null;
            while (current != null) {
                Object o = current.key;
                if (o.equals(key)) {
                    prev.next = current.next;
                    size--;
                    return current.getValue();
                } else {
                    prev = current;
                    current = current.next;
                }
            }
        }
        return null;
    }

    @Override
    public void putAll(final Map<? extends K, ? extends V> m) {
        if (m == null) throw new NullPointerException("not NULL argument required");
        for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
            Entry<K, V> pairs = (Entry<K, V>) entry;
            put(pairs.getKey(), pairs.getValue());
        }
    }

    @Override
    public void clear() {
        data = new Entry[NUM_BUCKETS];
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        HashSet<K> res = new HashSet<>();
        for (Entry<K, V> current : data) {
            while (current != null) {
                res.add(current.key);
                current = current.next;
            }
        }
        return res;
    }

    @Override
    public Collection<V> values() {
        Collection<V> res = new HashSet<>();
        for (Entry<K, V> current : this.data) {
            while (current != null) {
                res.add(current.value);
                current = current.next;
            }
        }
        return res;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return new Set<Map.Entry<K, V>>() {
            @Override
            public int size() {
                return MyHashMap.this.size();
            }

            @Override
            public boolean isEmpty() {
                return MyHashMap.this.isEmpty();
            }

            @Override
            public boolean contains(Object o) {
                //https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html#contains-java.lang.Object-
                if (o == null) throw new NullPointerException("not NULL argument required");
                Object[] tmp = toArray();
                for (Object cur : tmp) {
                    if (cur.equals(o)) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public Iterator<Map.Entry<K, V>> iterator() {
                return new Iterator<Map.Entry<K, V>>() {
                    Entry<K, V> currentNode = null;
                    int currentBucket = 0;
                    {
                        for (int i = 0; i < NUM_BUCKETS; i++) {
                            if (data[i] != null) {
                                currentNode = data[i];
                                currentBucket = i;
                                break;
                            }
                        }
                    }

                    @Override
                    public boolean hasNext() {
                        if (currentNode.next != null) {
                            return true;
                        } else {
                            for (int i = currentBucket; i < NUM_BUCKETS; i++) {
                                if (data[i] != null) {
                                    currentNode = data[i];
                                    currentBucket = i + 1;
                                    return true;
                                }
                            }
                        }
                        return false;
                    }

                    @Override
                    public Entry<K, V> next() {
                        Entry<K, V> tmp = currentNode;
                        if (currentNode.next != null) {
                            currentNode = currentNode.next;
                        } else {
                            for (int i = currentBucket; i < NUM_BUCKETS; i++) {
                                if (data[i] != null) {
                                    currentNode = data[i];
                                    currentBucket = i;
                                    break;
                                }
                            }
                        }
                        return tmp;
                    }
                };
            }

            @Override
            public Object[] toArray() {
                int i = 0;
                Object[] res = new Object[this.size()];
                for (Entry<K, V> current : data) {
                    if (current != null) {
                        do {
                            res[i] = current;
                            i++;
                        } while (current.next != null);
                    }
                }
                return res;
            }

            @Override
            public <T> T[] toArray(T[] ts) {
                if (ts == null) throw new NullPointerException("not NULL argument required");
                if (this.size() > ts.length) {
                    ts = Arrays.copyOf(ts, this.size());
                }
                int i = 0;
                for (Entry<K, V> current : data) {
                    if (current != null) {
                        do {
                            ts[i] = (T) current;
                            i++;
                        } while (current.next != null);
                    }
                }
                return ts;
            }

            @Override
            public boolean add(Map.Entry entry) {
                if (entry == null) throw new NullPointerException("not NULL argument required");
                K key = ((Map.Entry<K, V>) entry).getKey();
                V value = ((Map.Entry<K, V>) entry).getValue();
                put(key, value);
                return false;
            }

            @Override
            public boolean remove(Object o) {
                if (o == null) throw new NullPointerException("not NULL argument required");
                if (!this.contains(o)) {
                    return false;
                }
                return MyHashMap.this.remove(((Entry<K, V>) o).getKey()) != null;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                if (collection == null) throw new NullPointerException("not NULL argument required");
                Object[] tmp = collection.toArray();
                for (Object cur : tmp) {
                    if (!this.contains(cur)) {
                        return false;
                    }
                }
                return true;
            }

            @Override
            public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
                if (collection == null) throw new NullPointerException("not NULL argument required");
                for (Map.Entry<K, V> kvEntry : collection) {
                    Entry<K, V> currentEntry = (Entry<K, V>) kvEntry;
                    put(currentEntry.getKey(), currentEntry.getValue());
                }
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                if (collection == null) throw new NullPointerException("not NULL argument required");
                boolean res = false;
                for (Object o : this) {
                    if (!collection.contains(o)) {
                        res = true;
                        this.remove(o);
                    }
                }
                return res;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                boolean res = false;
                if (collection == null) throw new NullPointerException("not NULL argument required");
                Object[] tmp = collection.toArray();
                for (Object cur : tmp) {
                    if (!res) res = this.remove(cur);
                    else
                        this.remove(cur);
                }
                return res;
            }

            @Override
            public void clear() {
                MyHashMap.this.clear();
            }
        };
    }//entrySet

    //contract

    private static class Entry<K, V> implements Map.Entry<K, V> {
        Entry<K, V> next;
        private final K key;
        private V value;

        public Entry(Entry<K, V> next, K key, V value) {
            this.next = next;
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V value) {
            if (value == null) return null;
            this.value = value;
            return value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "next=" + next +
                    ", key=" + key +
                    ", value='" + value + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Map.Entry<K, V> entry = (Map.Entry<K, V>) o;
            return key.equals(entry.getKey()) &&
                    value.equals(entry.getValue());
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }
}
