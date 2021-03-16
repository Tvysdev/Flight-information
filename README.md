# Flight-information
Take-home coding challenge (Gridnine Systems)

Flight Information Display System with filters

-----------------------

### Requirements:
- [Java 8+](https://www.oracle.com/ru/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)

------------------------

## Installation guide
#### Build project with Maven
```
$ cd ~/Projects/{Project-name}
$ mvn package
```
#### Running project
```
$ cd ~/Projects/{Project-name}
$ java -jar ./target/testing-0.1.jar
```
#### Running all tests
```
$ cd ~/Projects/{Project-name}
$ mvn test
```

------------------------
## Usage:
#### Create Flights
```Java
List<Flight> allFlights = FlightBuilder.createFlights();
```
#### Create and apply filter
```Java
Filter filteredFlights = new {Filter-name}();
filteredFlights.applyFilter(allFlights)
```
#### FutureFlightsFilter - exclude all departed flights
```Java
filteredFlights = new FutureFlightsFilter();
```
#### DepartureBeforeArrivalFilter - exclude flights with error dates (if arrival date is earlier then departure date)
```Java
filteredFlights = new DepartureBeforeArrivalFilter();
```
#### IdleLessThen2HoursFilter - exclude flights with idle time more then 2 hours
```Java
filteredFlights = new IdleLessThen2HoursFilter();
```
