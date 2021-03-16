package com.gridnine.testing.filter;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IdleLessThen2HoursFilter implements Filter {
    @Override
    public List<Flight> applyFilter(List<Flight> flights) {
        return flights.stream().filter(flight -> !findMoreThen2HoursSegment(flight)).collect(Collectors.toList());
    }

    private boolean findMoreThen2HoursSegment(Flight flight) {
        List<Segment> segments = flight.getSegments();
        return IntStream.range(0, segments.size() - 1)
                .anyMatch(i -> Duration.between(segments.get(i).getArrivalDate(), segments.get(i + 1)
                        .getDepartureDate()).toHours() >= 2);
    }
}
