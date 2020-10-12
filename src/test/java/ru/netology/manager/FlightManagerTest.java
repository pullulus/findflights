package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.comparator.FlightByDurationAscComparator;
import ru.netology.domain.Flight;
import ru.netology.repository.FlightRepository;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class FlightManagerTest {
    private FlightRepository repository = new FlightRepository();
    private FlightManager manager = new FlightManager(new FlightRepository());
    private Flight first = new Flight(1, 3598, "VKO", "LED", 85);
    private Flight second = new Flight(2, 5591, "DME", "SIP", 145);
    private Flight third = new Flight(3, 5591, "DME", "SIP", 150);
    private Flight fourth = new Flight(4, 3280, "VKO", "LED", 90);
    private Flight fifth = new Flight(5, 3734, "VKO", "LED", 85);
    private FlightByDurationAscComparator comparator = new FlightByDurationAscComparator();


    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }

    @Test
    void getAllIfOne() {

        Flight[] actual = manager.getAll("DME", "SIP", new FlightByDurationAscComparator());
        Flight[] expected = new Flight[]{second, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    void getAllIfSome() {

        Flight[] actual = manager.getAll("VKO", "LED", new FlightByDurationAscComparator());
        Flight[] expected = new Flight[]{first, fifth, fourth};

        assertArrayEquals(expected, actual);
    }
}