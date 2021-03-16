package com.gridnine.testing.filter;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DepartureBeforeArrivalFilterTest {
    Filter departureBeforeArrivalFilter;
    private final LocalDateTime DATE_TIME = LocalDateTime.now();
    private List<Flight> flights;
    private List<Flight> expected;

    @Before
    public void init() {
        departureBeforeArrivalFilter= new DepartureBeforeArrivalFilter();
        flights = List.of(
                new Flight(List.of(new Segment(DATE_TIME.plusHours(4), DATE_TIME.plusHours(6)))),
                new Flight(List.of(new Segment(DATE_TIME, DATE_TIME.minusHours(1)))));

        expected = new ArrayList<>(flights);
        expected.remove(1);
    }

    @Test
    public void applyFilterTest(){
        assertEquals(expected , departureBeforeArrivalFilter.applyFilter(flights));
    }
}