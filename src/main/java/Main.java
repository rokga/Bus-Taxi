
public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus(2);
        bus.passengerride(2);
        bus.operate(50);
        bus.breaktime(10);
        bus.passengerride(45);
        bus.passengerride(5);
        bus.operate(55);
//        택시
        Taxi taxi = new Taxi(2);
        taxi.passengerride(2);
        taxi.destination("서울역", 2);
        taxi.operate(80);
        taxi.passengerride(5);
        taxi.passengerride(3);
        taxi.destination("구로디지털 단지역", 12);
        taxi.operate(20);
        taxi.passengerride(3);
        taxi.breaktime(60);

    }

};


