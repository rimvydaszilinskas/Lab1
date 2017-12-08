package com.company;

public class Main {

    public static void main(String[] args) {
        Interactions dialog = new Interactions();

        Cities cities = new Cities();

        cities.populateList("Kaunas", "20", "0", "A small city");
        cities.populateList("Vilnius", "20", "0", "A small city");
        System.out.println(cities.getRoutPrice("Kaunas", "Vilnius"));


    }


}
