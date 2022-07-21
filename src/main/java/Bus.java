
public class Bus extends Transportation implements Operatable, BreakTime, PassengerRide, OilWarn {
    public Bus(int num, int oil, int speed, int max_passenger) {
        super(num, oil, speed, max_passenger);
    }

    public Bus(int num){
        this(num,100,0,30);
        int[] bus_group = new int[num];
        for (int i = 0; i < num; i++) {
            bus_group[i] = (num % 2 == 0) ? 1000 + i : 10 + i;
            System.out.println("버스 " + bus_group[i] + " 이 생성되었습니다.");
            System.out.println(bus_group[i] + "버스 운행");
        }
    }

    @Override
    public void passengerride(int x) {
        if (x > 30) {
            System.out.println("***************************");
            System.out.println("탑승 승객 수 가 초과 되어 더이상 탑승이 불가능 합니다");
            System.out.println("***************************");
        } else if( x == 30){
            System.out.println("***************************");
            System.out.println("탑승객이 가득 찼습니다.");
            System.out.println("***************************");
            System.out.println("잔여 승객 수: " + (max_passenger - x));
            System.out.println("탑승 승객 수: " + x);
            int payment = x * 1000;
            System.out.println("요금 확인: " + (payment) + "원");
        } else {
            System.out.println("-----------------------------");
            System.out.println("탑승 승객 수: " + x);
            System.out.println("잔여 승객 수: " + (max_passenger - x));
            int payment = x * 1000;
            System.out.println("요금 확인: " + (payment) + "원");
            System.out.println("-----------------------------");
        }
    }

    @Override
    public void breaktime(int r) {
        if (oil > 10) {
            System.out.println("운행중");
        } else if(oil <= 10) {
            System.out.println("차고지행");
        }
        System.out.println("------------------");
    }

    @Override
    public void oilwarn(int x) {
        if( oil <= 10 ) {
            System.out.println("주유가 필요 합니다.");
        }
    }

    @Override
    public void operate(int x) {
        oil = x;
        System.out.println("주유량: "+x);
    }
}

