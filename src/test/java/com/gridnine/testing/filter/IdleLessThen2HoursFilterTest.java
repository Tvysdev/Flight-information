package com.gridnine.testing.filter;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IdleLessThen2HoursFilterTest {
    Filter idleLessThen2HoursFilter;
    private final LocalDateTime DATE_TIME = LocalDateTime.now();
    private List<Flight> flights;
    private List<Flight> expected;

    @BeforeEach
    public void init() {
        idleLessThen2HoursFilter = new IdleLessThen2HoursFilter();
        flights = List.of(
                new Flight(List.of(new Segment(DATE_TIME.plusHours(4), DATE_TIME.plusHours(6)))),
                new Flight(List.of(
                        new Segment(DATE_TIME, DATE_TIME.plusHours(2)),
                        new Segment(DATE_TIME.plusHours(5), DATE_TIME.plusHours(7)))));

        expected = new ArrayList<>(flights);
        expected.remove(1);
    }

    @Test
    public void applyFilterTest(){
        assertEquals(expected , idleLessThen2HoursFilter.applyFilter(flights));
    }
}