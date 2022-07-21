public class Taxi extends Transportation implements OilWarn,Operatable,Passenger_Taxi,BreakTime, PassengerRide, Speed_Change {
    public Taxi(int num, int oil, int speed, int speedVar, int max_passenger) {
        super(num, oil, speed, speedVar, max_passenger);
    }

    public Taxi(int num) {
        this(num, 100, 0, 0, 4);
        int[] taxi_group = new int[num];
        for (int i = 0; i < num; i++) {
            taxi_group[i] = (num % 2 == 0) ? 990 + i * 10 : 997 + i * 7;
            System.out.println("택시 " + taxi_group[i] + " 이 생성되었습니다.");
            System.out.println("주유량: "+oil);
            System.out.println(Taxi.Status.RUN.getName());
            speed+=1;
        }
    }

    public void passengerride(int x) {
        if (speed==0){
            System.out.println("-*--*--*--*--*--*--*--*--*--*-");
            System.out.println("alert: 승객을 태울 수 없습니다!");
            System.out.println("-*--*--*--*--*--*--*--*--*--*-");
        }else
        if (max_passenger - x < 0) {
            System.out.println("-*--*--*--*--*--*--*--*--*--*-");
            System.out.println("alert: 최대 승객수 초과!!");
            System.out.println("-*--*--*--*--*--*--*--*--*--*-");
        }else {
            System.out.println("--------------------");
            System.out.println("탑승 승객 수: " + x);
            System.out.println("잔여 승객 수: " + (max_passenger - x));
        }

    }


    @Override
    public void breaktime(int x) {
        oil += x;
        System.out.println(Taxi.Status.STOP.getName());
        System.out.println("............................");
        System.out.println("주유: +"+x);
        System.out.println("현재 주유량: "+oil);
        System.out.println("............................");
        speed=1;
        System.out.println(Taxi.Status.RUN.getName());
    }

    @Override
    public void oilwarn() {
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        System.out.println("주유 필요!!");
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        speed=0;
    }

    @Override
    public void operate(int x) {
        oil -= x;
        System.out.println("............................");
        System.out.println("잔여 주유량: "+oil);
        System.out.println("............................");
        if (oil<10){oilwarn();
        }else{
            speed=1;
        }
    }


    @Override
    public void destination(String destination, int distance) {
        System.out.println("기본 요금 확인: " + 3000);
        System.out.println("목적지: " + destination);
        System.out.println("목적지까지 거리: " + distance);
        int payment = 3000+((distance-1) * 1000);
        System.out.println("요금 확인: " + (payment) + "원");
        System.out.println("--------------------");
    }

    @Override
    public void speed_change(int x) {
        speed_Var=x;
        speed+=speed_Var;
        System.out.println("............................");
        System.out.println("속도가 "+x+"만큼 증가하였습니다.");
        System.out.println("현재속도: "+speed);
        System.out.println("............................");
    }

    public enum Status{
        RUN("상태: 일반"),
        STOP("상태: 운행 정지");
        public String name;
        Status(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }



}


