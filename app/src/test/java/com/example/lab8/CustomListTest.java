package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void testHasCity() {
        list = MockCityList();

        list.addCity(new City("Edmonton", "Alberta"));

        assertTrue(list.hasCity(new City("Edmonton", "Alberta")));
    }

    @Test
    void testDelete() throws Exception {
        list = MockCityList();

        City city = new City("Calgary", "Alberta");
        list.add(city);

        // Test if city is properly deleted
        list.delete(city);
        assertEquals(0, list.getCount());

        list.add(city);

        // Test for other way of deleting City
        list.delete(new City("Calgary", "Alberta"));
        assertEquals(0, list.getCount());

        // Test Exception if City is not in the list
        assertThrows(Exception.class, () -> {
            list.delete(new City("Yellowknife", "Northwest Territories"));
        });
    }

}
