package com.example.lab8;

public class City implements Comparable<City> {

    private String city;
    private String province;

    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    String getCityName(){
        return this.city;
    }

    String getProvinceName(){
        return this.province;
    }

    @Override
    public int compareTo(City city) {
        return this.city.compareTo(city.getCityName());
    }

    @Override
    public boolean equals(Object o) {
        City city = (City) o;
        if (this.getCityName().equals(city.getCityName()) && this.getProvinceName().equals(city.getProvinceName())) return true;
        else return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }
}
