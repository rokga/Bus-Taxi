
public class Main {
    public static void main(String[] args) {


        Bus bus = new Bus(2);
        bus.passengerride(10);        //탑승승객수  & 잔여승객수 & 요금확인
        bus.operate(100);              //주유량
        bus.oilwarn(10);             // 주유경고 기준 값.
        bus.breaktime(0);            //  주유량에 따라 정해짐


        Taxi taxi = new Taxi(2);                          //택시 생성
        taxi.operate(10);                                  //주유 량
        taxi.oilwarn(10);                                   //주유 경고
        taxi.passengerride(0);                              //택시 탑승 승객
        taxi.destination("서울역" , 12);       // 목적지 , 거리 입력
        taxi.breaktime(0);                                   //  주유량에 따라 정해짐
    }
}

