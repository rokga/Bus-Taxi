

public class Main {
    public static void main(String[] args) {

       Bus bus = new Bus(2);
       System.out.println("------------------------------------------");
       bus.passengerride(30);        //탑승승객수  & 잔여승객수 & 요금확인
       bus.operate(10);       //주유량
       bus.oilwarn(10);    // 주유경고 기준 값.
       bus.breaktime(11);
            }
        };


