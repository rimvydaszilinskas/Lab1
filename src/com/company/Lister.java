package com.company;

import java.util.Iterator;

public class Lister<E> implements List<E>, Iterable<E>{

    private Node<E> first;
    private Node<E> last;
    private Node<E> current;
    private int size;

    Lister(){
        clear();
    }

    @Override
    public boolean add(E element, E... data){
        if(element == null)
            return false;
        else if(first == null){
            first = new Node<>(element, first, last, data);
            last = first;
        } else{
            Node<E> el = new Node<>(element, null, last);
            last.next = el;
            last = el;
        }
        size++;
        current = first;
        return true;
    }

    @Override
    public int size(){
        return this.size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0 || first == null;
    }

    @Override
    public void clear(){
        size = 0;
        first = null;
        last = null;
        current = null;
    }

    @Override
    public E get(int index){
        current = first;

        for(int i = 0; i<index; i++)
            current = current.next;

        return current.element;
    }

    @Override
    public E getNext(){
        E element = current.next.element;
        if(current.next == null)
            current = first;
        else
            current = current.next;
        return element;
    }

    @Override
    public Object[] toArray(){
        Object[] array = new Object[size];

        current = first;

        for(int i = 0; i < size; i++){
            array[i] = current.element;
            current = current.next;
        }

        return array;
    }

    @Override
    public Object[] toArrayLine(){
        Object[] array = new Object[size];
        current = first;
        for(int i = 0; i<size; i++){
            array[i] = current.element + " ";
            for(int y = 0; y<current.data.length; y++)
                array[i] += current.data[y] + " ";
        }

        return array;
    }

    @Override
    public boolean hasElement(E element){
        return false;
    }

    @Override
    public String returnRouteString(E start, E finish){
        String route = "";

        if(existsE(start) && existsE(finish)){//continue only if start and finish exist
            int position = findPosition(finish);
            int departure = findPosition(start);

            findElement(start); //set the current element to the start one
            if(departure > position){
                for(int i = position; i <= departure; i++){
                    route += current.element.toString() + " ";
                    current = current.previous;
                }
            }


            if(position != -1){
                for(int i = departure; i <= position; i++){
                    route += current.element.toString() + " ";
                    current = current.next;
                }
            }
        }
        else
            route = null;

        return route;
    }

    @Override
    public Object[] getData(int pos){
        current = first;
        for(int i = 0; i<pos; i++)
            current = current.next;
        if(current.data == null)
            return null;
        return current.data;
    }

    @Override
    public Object[] getData(E element){
        if(!findElement(element))
            return null;
        return current.data;
    }

    @Override
    public Object[][] bigArray(){
        Object[][] object = new Object[size][current.data.length + 1];

        current = first;

        for(int i = 0; i<size; i++){
            object[i][0] = current.element;
            if(first.data != null)
            for(int y = 1; y<current.data.length+1; y++)
                object[i][y] = current.data[y-1];

            current = current.next;
        }

        return object;
    }

    public Object[] returnRouteArray(E start, E finish){
        Object[] route;

        if(existsE(start) && existsE(finish)){//continue only if start and finish exist

            int departure = findPosition(start);
            int destination = findPosition(finish);
            int hold = 0;

            if(departure > destination)
                route = new Object[departure - destination + 1];
            else
                route = new Object[destination - departure + 1];

            findElement(start); //set the current element to the start one
            if(departure > destination){

                for(int i = destination; i <= departure; i++){
                    route[hold] = current.element;
                    current = current.previous;
                    hold++;
                }
            }

            for(int i = departure; i <= destination; i++){
                route[hold] = current.element;

                if(current.next != null)
                    current = current.next;
                hold++;
            }
        }
        else
            route = null;

        return route;
    }

    //point current to the right element
    private boolean findElement(E element){
        current = first;

        //loop through the list and return true if theres a match
        for(int i = 0; i < size; i++){
            if(element.equals(current.element))
                return true;
            current = current.next;
        }

        return false;
    }

    private int findPosition(E element){
        current = first;

        for(int i = 0; i < size; i++){
            if(element.equals(current.element))
                return i;
            current = current.next;
        }

        return -1;
    }

    public boolean existsE(E element){
        current = first;

        //loop through the list and return true if theres a match
        for(int i = 0; i < size; i++) {
            if (element.equals(current.element))
                return true;
            current = current.next;
        }
        return false;
    }

    private static class Node<E>{
        private E element;
        private E[] data;
        private Node<E> next;
        private Node<E> previous;

        Node(E element, Node<E> next, Node<E> previous){
            this.next = next;
            this.previous = previous;
            this.element = element;
            this.data = null;
        }

        Node(E element, Node<E> next, Node<E> previous, E... data){
            this.next = next;
            this.previous = previous;
            this.element = element;
            this.data = data;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    //internal iterator class
    private class ListIterator implements Iterator<E> {
        private Node<E> iterPosition;

        ListIterator() {
            iterPosition = first;
        }

        @Override
        public boolean hasNext() {
            return iterPosition.next != null;
        }

        @Override
        public E next() {
            E d = iterPosition.element;
            iterPosition = iterPosition.next;
            current = current.next;
            return d;
        }
    }


}