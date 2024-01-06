package lab7;

import lab6.car.PassengerCar;

import java.util.Set;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Collection;
import java.util.Objects;


public class PassengerCarSet implements Set<PassengerCar> {

    private static class Node {
        PassengerCar data;
        Node next;

        Node(PassengerCar data) {
            this.data = data;
        }
    }

    private class PassengerCarSetItr implements Iterator<PassengerCar> {

        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public PassengerCar next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            PassengerCar data = current.data;
            current = current.next;
            return data;
        }
    }

    private Node head;
    private int size;

    public PassengerCarSet() {
    }

    public PassengerCarSet(PassengerCar data) {
        add(data);
    }

    public PassengerCarSet(Collection<PassengerCar> collection) {
        addAll(collection);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (isEmpty() || !(o instanceof PassengerCar)) {
            return false;
        }

        PassengerCar car = (PassengerCar) o;
        Node current = head;

        while (current != null) {
            if (current.data.equals(car)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public Iterator<PassengerCar> iterator() {
        return new PassengerCarSetItr();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];

        Node current = head;
        for (int i = 0; current != null; ++i) {
            array[i] = current.data;
            current = current.next;
        }

        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // я не знаю, як це імплементувати))
        return null;
    }

    @Override
    public boolean add(PassengerCar passengerCar) {
        Node node = new Node(passengerCar);

        //не додаємо елемент до списку, якщо це дублікат, та повертаємо false
        if (contains(passengerCar)) {
            return false;
        }

        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (isEmpty() || !(o instanceof PassengerCar)) {
            return false;
        }

        PassengerCar data = (PassengerCar) o;

        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Objects.requireNonNull(c);
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends PassengerCar> c) {
        Objects.requireNonNull(c);
        int initialSize = size;
        c.forEach(this::add);
        return !(size == initialSize);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Objects.requireNonNull(c);
        int initialSize = size;

        for (PassengerCar car : this) {
            if (!c.contains(car)) {
                remove(car);
            }
        }

        return !(size == initialSize);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Objects.requireNonNull(c);
        int initialSize = size;
        for (Object element : c) {
            remove(element);
        }
        return !(size == initialSize);
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "PassengerCarSet{}";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("PassengerCarSet:\n");

        Node current = head;
        while (current != null) {
            sb.append(current.data.toString());
            current = current.next;
        }

        return sb.toString();
    }
}
