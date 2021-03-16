package com.gridnine.testing.filter;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FutureFlightsFilterTest {
    Filter futureFlightsFilter;
    private final LocalDateTime DATE_TIME = LocalDateTime.now();
    private List<Flight> flights;
    private List<Flight> expected;

    @Before
    public void init() {
       futureFlightsFilter= new FutureFlightsFilter();
        flights = List.of(
                new Flight(List.of(new Segment(DATE_TIME.plusHours(4), DATE_TIME.plusHours(6)))),
                new Flight(List.of(new Segment(DATE_TIME.minusHours(2), DATE_TIME))));

        expected = new ArrayList<>(flights);
        expected.remove(1);
    }

    @Test
    public void applyFilterTest(){
        assertEquals(expected , futureFlightsFilter.applyFilter(flights));
    }

}