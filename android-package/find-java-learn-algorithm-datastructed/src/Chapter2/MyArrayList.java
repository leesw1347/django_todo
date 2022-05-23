package Chapter2;

import java.util.*;
import java.util.function.UnaryOperator;

public class MyArrayList<E> implements List<E> {
    int size; // 요소의 개수를 추적합니다
    private E[] array; // 요소를 저장합니다

    public MyArrayList() {
        array = (E[]) new Object[10];
        size = 0;
        System.out.println("MyArrayList 생성자를 호출합니다");
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        E i = (E) o;
//        if (i >= array.length && i < 0) {
//            System.out.println("indexOf 함수는 여기서는 " + i + "에 포함될 수 없습니다");
//            return -1;
//        }
        Integer index = -1;
        for (E arr : array) {
            if (equals((E) i)) {
                break;
            } else {
                index++;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Spliterator<E> spliterator() {
        return List.super.spliterator();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @param
     * @return
     * @apiNote 객체 내 o가 존재하는지 확인한다
     */
    @Override
    public boolean contains(Object o) {
//        return false;
        return indexOf(o) != -1;
    }

    @Override
    public boolean equals(Object obj) {
//        return super.equals(obj);
        // 배열의 요소를 대상 값과 비교하여 같으면 true, 아니면 false를 리턴한다
        boolean ret = false;
        if (obj != null) {
            for (E arr : array) {
                if (arr == (E) obj) {
                    ret = true;
                    break;
                }
            }
        }
        return ret;
    }

    @Override
    public Iterator<E> iterator() {
        // make a copy the array
        E[] copy = Arrays.copyOf(array, size);
        // make a list and return an iterator
//        System.out.println(Arrays.asList(copy));
        return Arrays.asList(copy).iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    public boolean add(E element) {
        if (size >= array.length) {
            // 큰 배열을 만들고 요소들을 복사합니다
            E[] bigger = (E[]) new Object[array.length * 2];
            System.arraycopy(array, 0, bigger, 0, array.length);
            array = bigger;
        }

        array[size] = element;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Integer i = (Integer) o;
        for (int index = 0; index < array.length; index++) {
            if (array[index] == i) {

            }
        }
        return true;
    }

    /**
     * @apiNote 객체로 들어온 Collection 내 데이터의 전체가 존재하는지 확인한다
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        boolean flag = true;
        for (Object element : c) {
            if (!contains(element)) { // contains 함수는 element가 Arrays에 포함되지 않는다면 false를 리턴한다
                flag = false;
                break;
            }
        }
        return flag;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
//        return false;
        // Collection으로 들어온 모든 데이터들을 array에 입력한다
        boolean flag = true;
        for (E element : c) {
            flag &= add(element);
        }
        return flag;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        List.super.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super E> c) {
        List.super.sort(c);
    }

    @Override
    public void clear() {
        // array와 size를 정리한다
        size = 0;
    }

    @Override
    public E get(int index) {
//        return null;
        if (index < 0 || index >= size) { // ArrayRange 오류가 나는지 안나는지 체크한다
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public E set(int index, E element) {
        if (index >= array.length && index < 0) {
            System.out.println(index + "의" + element + "를 추가할수 없습니다");
            return null;
        }

        if (array[index] != null) {
            array[index] = element;
        }
        size++;
        return array[index];
    }

    public static void main(String[] args) {
        // run a few simple tests
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.set(0, 150);
        System.out.println(myArrayList.get(0));
        System.out.println(Arrays.toString(myArrayList.toArray()) + ", size = " + myArrayList.size);
        System.out.println("3은 어느 위치에 있어요 ? " + myArrayList.indexOf(3));
//        System.out.println("3의 값이 array 내에 있어요 ? " + myArrayList.equals(3)); //
//        System.out.println("3의 값이 array 내에 있어요 ? " + myArrayList.equals(155)); //
//        myArrayList.remove(new Integer(2));

        System.out.println("listIterator " + myArrayList.iterator());
    }
}
