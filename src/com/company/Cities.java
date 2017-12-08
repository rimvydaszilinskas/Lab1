package com.company;

public class Cities {
    //Constants for easy access
    private final static int price = 0;
    private final static int coordinate = 1;
    private final static int info = 2;

    //end of constants

    private Lister<String> cities = new Lister<>();

    public void populateList(String... cities){
        for(String i : cities){
            this.cities.add(i);
        }
    }

    public String findRoute(String from, String to){
        return cities.returnRouteString(from, to);
    }

    public double getRoutPrice(String from, String to){
        double price = 0;

        //get the cities route array
        Object[] cities = this.cities.returnRouteArray(from, to);

        for(Object city : cities) {
            //get the data of the city
            Object[] data = this.cities.getData(city.toString());

            //price += (Double)(data[this.price]);

            for(Object i : data)
                System.out.println(i);

        }

        return price;
    }
}
