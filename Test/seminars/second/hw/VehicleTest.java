package seminars.second.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    Car car;
    Motorcycle motorcycle;

    @BeforeEach
    void setUo() {
        car = new Car("Dodge", "Ram", 2010);
        motorcycle = new Motorcycle("Kawasaki", "ZX-10R", 2004);
    }

    /*
    - Проверить, что экземпляр объекта Car также является экземпляром
    транспортного средства (используя оператор instanceof).
     */
    @Test
    public void testCarIsInstanceOfVehicle() {
        assertTrue(car instanceof Vehicle);
    }

    /*
    - Проверить, что объект Car создается с 4-мя колесами.
     */
    @Test
    public void testCarIsFourWheels() {
        assertEquals(4, car.getNumWheels());
    }

    /*
    - Проверить, что объект Motorcycle создается с 2-мя колесами.
     */
    @Test
    public void testMotorcycleIsFourWheels() {
        assertEquals(2, motorcycle.getNumWheels());
    }

    /*
    - Проверить, что объект Car развивает скорость 60
    в режиме тестового вождения (используя метод testDrive()).
     */
    @Test
    public void testCarSpeedTestDrive() {
        car.testDrive();
        assertEquals(60, car.getSpeed());
    }

    /*
    - Проверить, что объект Motorcycle развивает скорость 75
    в режиме тестового вождения (используя метод testDrive()).
     */
    @Test
    public void testMotorcycleSpeedTestDrive() {
        motorcycle.testDrive();
        assertEquals(75, motorcycle.getSpeed());
    }

    /*
    - Проверить, что в режиме парковки
    (сначала testDrive, потом park, т.е. эмуляция движения транспорта)
    машина останавливается (speed = 0).
     */
    @Test
    public void testCarSpeedAfterParking() {
        car.testDrive();
        car.park();
        assertEquals(0, car.getSpeed());
    }

    /*
    - Проверить, что в режиме парковки
    (сначала testDrive, потом park, т.е. эмуляция движения транспорта)
    мотоцикл останавливается (speed = 0).
     */
    @Test
    public void testMotorcycleSpeedAfterParking() {
        motorcycle.testDrive();
        motorcycle.park();
        assertEquals(0, motorcycle.getSpeed());
    }
}