
import  java.util.Arrays;

public class Bus extends Transportation implements Operatable, BreakTime, PassengerRide, OilWarn, Speed_Change{
    public Bus(int num, int oil, int speed, int speedVar, int max_passenger) {
        super(num, oil, speed, speedVar, max_passenger);
    }
    public enum Status{
        RUN("상태: 운행 중"),
        STOP("상태: 차고지 행");
        public String name;
        Status(String name) {
            this.name = name;
        }
        public String getName(){
            return name;
        }
    }

    public Bus(int num){
        this(num, 100, 0, 0, 30);
        int[] bus_group = new int[num];
        for (int i = 0; i < num; i++) {
            bus_group[i] = (num % 2 == 0) ? 1000 + i : 10 + i;
            System.out.println("버스 " + bus_group[i] + " 이 생성되었습니다.");
            System.out.println(Bus.Status.RUN.getName());
            speed+=1;
        }
    }

    @Override
    public void passengerride(int x) {
        if (speed==0){
            System.out.println("-*--*--*--*--*--*--*--*--*--*-");
            System.out.println("alert: 승객을 태울 수 없습니다!");
            System.out.println("-*--*--*--*--*--*--*--*--*--*-");
        } else if (max_passenger - x < 0) {
            System.out.println("-*--*--*--*--*--*--*--*--*--*-");
            System.out.println("alert: 최대 승객수 초과!!");
            System.out.println("-*--*--*--*--*--*--*--*--*--*-");
        } else {
            System.out.println("--------------------");
            System.out.println("탑승 승객 수: " + x);
            System.out.println("잔여 승객 수: " + (max_passenger - x));
            int payment = x * 1000;
            System.out.println("요금 확인: " + (payment) + "원");
            System.out.println("--------------------");
        }

    }

    @Override
    public void breaktime(int x) {
        System.out.println(Bus.Status.STOP.getName());
        oil += x;
        System.out.println("............................");
        System.out.println("주유: +"+x);
        System.out.println("현재 주유량: "+oil);
        System.out.println("............................");
        System.out.println(Bus.Status.RUN.getName());
        speed+=1;
    }

    @Override
    public void oilwarn() {
        System.out.println("-*--*--*--*--*--*--*--*--*--*-");
        System.out.println("주유 필요!!");
        System.out.println("-*--*--*--*--*--*--*--*--*--*-");
        speed=0;
    }

    @Override
    public void operate(int x) {
        oil -= x;
        System.out.println("............................");
        System.out.println("잔여 주유량: " + oil);
        System.out.println("............................");
        if (oil < 10) {
            oilwarn();
        } else {
            speed = 0;
        }
    }

    @Override
    public void speed_change(int x) {
        if(speed==0){
            System.out.println("-*--*--*--*--*--*--*--*--*--*-");
            System.out.println("현재는 속도를 높일 수 없습니다!!");
            System.out.println("-*--*--*--*--*--*--*--*--*--*-");
        }else {
            speed_Var = x;
            speed += speed_Var;
            System.out.println("............................");
            System.out.println("속도가 " + x + "만큼 증가하였습니다.");
            System.out.println("현재속도: " + speed);
            System.out.println("............................");
        }
    }


}
