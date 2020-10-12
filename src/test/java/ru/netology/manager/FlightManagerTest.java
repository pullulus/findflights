package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Flight;
import ru.netology.repository.FlightRepository;

import static org.junit.jupiter.api.Assertions.*;

class FlightManagerTest {
    private FlightRepository repository = new FlightRepository();
    private FlightManager manager = new FlightManager(new FlightRepository());
    private Flight first = new Flight(1, 3598, "VKO", "LED", 85);
    private Flight second = new Flight(2, 5591, "DME", "SIP", 145);
    private Flight third = new Flight(3, 3280, "VKO", "LED", 90);
    private Flight fourth = new Flight(4, 3734, "VKO", "LED", 85);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }

    @Test
    void getAllIfOne() {

        Flight[] actual = manager.getAll("DME", "SIP");
        Flight[] expected = new Flight[]{second};

        assertArrayEquals(expected, actual);
    }

    @Test
    void getAllIfSome() {

        Flight[] actual = manager.getAll("VKO", "LED");
        Flight[] expected = new Flight[]{third, first, fourth};

        assertArrayEquals(expected, actual);
    }

    @Test
    void getAllIfNone() {

        Flight[] actual = manager.getAll("VKO", "SIP");
        Flight[] expected = new Flight[0];

        assertArrayEquals(expected, actual);
    }

}