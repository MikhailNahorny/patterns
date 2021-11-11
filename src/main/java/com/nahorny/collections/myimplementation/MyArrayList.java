package com.nahorny.collections.myimplementation;

import java.util.*;

public class MyArrayList implements List {

    private Object[] payload;
    private int currentSize;
    private static final int VOLUME_FACTOR = 2;
    private static final int MAX_SIZE = Integer.MAX_VALUE - 8;

    public MyArrayList() {
        this.payload = new Object[0];
        this.currentSize = 0;
    }


    //contract
    @Override
    public int size() {
        return this.currentSize;
    }

    @Override
    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) return false;
        for (int i = 0; i < this.currentSize; i++) {//можно через вызов indexOf, и даже правильнее, но переписывать не буду
            if (this.payload[i].equals(o)) return true;
            /*
             @Override
             public boolean equals(Object obj) {} mandatory for obj!
             */
        }
        return false;
    }

    @Override
    public boolean add(Object o) {
        if (o == null) return false;
        checkSize(1);
        this.payload[currentSize++] = o;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) return false;
        for (int i = 0; i <= this.currentSize; i++) {
            if (this.payload[i].equals(o)) {
                return removeHelp(o);
            }
        }
        return false;
    }

    @Override
    public void clear() {
        this.payload = new Object[0];
        this.currentSize = 0;
    }

    @Override
    public boolean addAll(Collection arg) {

        if (arg == null) return false;
//        Iterator itr = arg.iterator();
//        while (itr.hasNext()){
//            checkSize(arg.size());
//            this.payload[this.currentSize++] = itr.next();
//        }
        for (Object o : arg) {
            checkSize(1);
            this.payload[this.currentSize++] = o;
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection other) {
        if (other == null) return false;
        int resSize = 0;
        for (Object otherItem : other) {
            if (this.indexOf(otherItem) != -1) {
                resSize++;
            }
        }
        if (resSize == 0) {
            return false;
        } else {
            Object[] result = new Object[resSize];
            resSize = 0;
            for (Object otherItem : other) {
                if (this.indexOf(otherItem) != -1) {
                    result[resSize++] = otherItem;
                }
            }
            this.currentSize = resSize;
            this.payload = result;
            return true;
        }
    }

    @Override
    public boolean removeAll(Collection other) {
        boolean res = false;
        if (other == null) return res;
        for (Object otherItem : other) {
            if (this.indexOf(otherItem) != -1) {
                this.remove(this.payload[this.indexOf(otherItem)]);
                res = true;
            }
        }
        return res;
    }

    @Override
    public boolean containsAll(Collection other) {
        if (other == null) return false;
        boolean res = true;
        for (Object otherItem : other) {
            if (this.indexOf(otherItem) == -1) {
                res = false;
            }
        }
        return res;
    }

    @Override
    public Object[] toArray() {
        Object[] res = new Object[0];
        if (currentSize >= 0) System.arraycopy(this.payload, 0, res, 0, currentSize);
        return res;
    }

    @Override
    public Object[] toArray(Object[] objects) {
        if (objects.length >= this.toArray().length) objects = this.toArray();
        return objects;
    }

    @Override
    public Iterator iterator() {

        return new Iterator() {
            private int current = 0;

            @Override
            public boolean hasNext() {
                return current < currentSize;
            }

            @Override
            public Object next() {
                return payload[current++];
            }
        };
    }

    @Override
    public boolean addAll(int index, Collection collection) {
        if (index >= this.currentSize) throw new IndexOutOfBoundsException("no such index");
        checkSize(collection.size());
        Object[] tailSubArr = Arrays.copyOfRange(this.payload, index, this.currentSize);
        for (Object next : collection) {
            this.payload[index++] = next;
        }
        for (Object next : tailSubArr) {
            this.payload[index++] = next;
        }
        this.currentSize += collection.size();
        return false;
    }

    @Override
    public void add(int index, Object o) {
        if (index >= this.currentSize) throw new IndexOutOfBoundsException("no such index");
        if (o == null) return;
        checkSize(1);
        Object[] tailSubArr = Arrays.copyOfRange(this.payload, index, this.currentSize);
        this.payload[index++] = o;
        for (Object next : tailSubArr) {
            this.payload[index++] = next;
        }
        this.currentSize++;
    }

    @Override
    public Object get(int index) {
        return this.payload[index];
    }

    @Override
    public Object set(int index, Object o) {
        Object tmp = this.payload[index];
        this.payload[index] = o;
        return tmp;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) return -1;
        for (int i = 0; i < this.currentSize; i++) {
            if (this.payload[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) return -1;
        for (int i = this.currentSize - 1; i >= 0; i--) {
            if (this.payload[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Object remove(int index) {
        Object tmp = this.payload[index];
        for (int i = index; i < this.currentSize; i++) {
            this.payload[i] = this.payload[i + 1];
        }
        this.currentSize--;
        return tmp;
    }

    @Override
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override
    public ListIterator listIterator(int startIndex) {
        return new ListIterator() {
            private int current = startIndex;
            private int lastRet = -1;

            @Override
            public boolean hasNext() {
                return current < currentSize;
            }

            @Override
            public Object next() {
                lastRet = current;
                return payload[current++];
            }

            @Override
            public boolean hasPrevious() {
                //Logger.getLogger().log("текущий индекс: " + current);
                return current > startIndex;// current > 0
            }

            @Override
            public Object previous() {
                Object toReturn = payload[--current];
                lastRet = current;
                return toReturn;
            }

            @Override
            public int nextIndex() {
                //The above method is used to return the index of the element which is returned by the next() method
                //если был возвращен, то указатель уже инкрементирован, значит -1
                return current;
            }

            @Override
            public int previousIndex() {
                return current - 1;
            }

            @Override
            public void remove() {
                for (int i = lastRet; i < currentSize - 1; i++) {
                    payload[i] = payload[i + 1];
                    payload[currentSize] = null;
                }
                currentSize--;
                current--;
            }

            @Override
            public void set(Object o) {
                payload[lastRet] = o;
            }

            @Override
            public void add(Object o) {
                //вставить до того, который вернет next ()
                //next () это не затронет
                //previous () его вернет
                // nextIndex и previousIndex увеличатся на 1
                MyArrayList.this.add(lastRet, o);
                current++;
            }
        };
    }

    @Override
    public List subList(int startIndex, int stopIndex) {
        subListRangeCheck(startIndex, stopIndex, currentSize);
        return new SubList(this, startIndex, stopIndex);
    }

    @Override
    public void sort(Comparator c) {
        Arrays.sort(this.payload, c);
    }
    //contract

    static void subListRangeCheck(int startIndex, int stopIndex, int size) {
        if (startIndex < 0 | stopIndex > size | startIndex > stopIndex)
            throw new RuntimeException("subList incorrect Range");
    }

    public class SubList extends AbstractList {
        List parentList = null;
        int startPosition = 0;
        int endPosition = 0;

        public SubList(List parentList, int startPosition, int endPosition) {
            this.parentList = parentList;
            this.startPosition = startPosition;
            this.endPosition = endPosition;
        }

        @Override
        public int size() {
            return endPosition - startPosition;
        }

        @Override
        public boolean isEmpty() {
            return size() == 0;
        }

        @Override
        public Object get(int index) {
            return MyArrayList.this.get(startPosition + index);
        }

        @Override
        public void add(int index, Object object) {
            parentList.add(index + startPosition, object);
        }

        @Override
        public boolean contains(Object object) {
            for (int i = startPosition; i < endPosition; i++) {
                if (parentList.get(i).equals(object)) {
                    return true;
                }
            }
            return false;
        }
    }//SubList

    private void checkSize(int addLength) {
        if (currentSize + addLength >= payload.length) {
            if (payload.length == 0) {
                this.payload = new Object[1];
            }
            while (currentSize + addLength >= payload.length) {
                this.payload = grow();
            }
        }
    }

    private Object[] grow() {
        if (this.payload.length * 2 > MAX_SIZE) throw new RuntimeException("Collection overflowed");
        return this.payload = Arrays.copyOf(this.payload, this.payload.length * VOLUME_FACTOR);
    }

    private boolean removeHelp(Object o) {
        //TODO переписать для вызова в итераторах
        if (indexOf(o) == -1) return false;
        for (int i = indexOf(o); i < this.currentSize - 1; i++) {
            this.payload[i] = this.payload[i + 1];
        }
        this.payload[currentSize] = null;//если не перетереть явно, то ничего не страшного не случится, если не заглядывать, куда не просят. но после удаления в масиве данных дублируется последний не-нулл элемент
        this.currentSize--;
        return true;
    }

    @Override
    public String toString() {
        if (this.currentSize == 0) {
            return "MyCollection is empty";
        }
        String res = "MyCollection contains following items:\n";
        for (int i = 0; i < currentSize; i++) {
            res += this.payload[i].toString() + "\n";
        }
        return res;
    }
}
