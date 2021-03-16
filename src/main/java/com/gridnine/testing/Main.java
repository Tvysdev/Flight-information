package com.gridnine.testing;
import com.gridnine.testing.filter.DepartureBeforeArrivalFilter;
import com.gridnine.testing.filter.Filter;
import com.gridnine.testing.filter.FutureFlightsFilter;
import com.gridnine.testing.filter.IdleLessThen2HoursFilter;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.FlightBuilder;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Flight> allFlights = FlightBuilder.createFlights();

        System.out.println("Flights without filters:");
        allFlights.forEach(System.out::println);

        Filter filteredFlights = new FutureFlightsFilter();
        System.out.println("\n" + "Removed already departed flights:");
        filteredFlights.applyFilter(allFlights).forEach(System.out::println);

        filteredFlights = new DepartureBeforeArrivalFilter();
        System.out.println("\n" + "Removed flights with arrival before departure:");
        filteredFlights.applyFilter(allFlights).forEach(System.out::println);

        filteredFlights = new IdleLessThen2HoursFilter();
        System.out.println("\n" + "Removed flights with more then 2 hours idle:");
        filteredFlights.applyFilter(allFlights).forEach(System.out::println);
    }
}
