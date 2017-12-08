package com.company;

interface List<E> {

    boolean add(E element, E... data);

    int size();

    boolean isEmpty();

    void clear();

    E get(int number);

    E getNext();

    Object[] toArray();

    Object[] toArrayLine();

    boolean hasElement(E element);

    String returnRouteString(E start, E finish);

    Object[] returnRouteArray(E start, E finish);

    Object[] getData(int pos);

    Object[] getData(E element);

    Object[][] bigArray();
}
