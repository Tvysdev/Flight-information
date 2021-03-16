package com.gridnine.testing.filter;

import com.gridnine.testing.model.Flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


public class FutureFlightsFilter implements Filter {
    @Override
    public List<Flight> applyFilter(List<Flight> flights) {
        return flights.stream().filter(flight -> flight.getSegments().stream()
                .allMatch(segment -> segment.getDepartureDate().isAfter(LocalDateTime.now())))
                .collect(Collectors.toList());
    }
}
