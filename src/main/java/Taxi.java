public class Taxi extends Transportation implements OilWarn,Operatable,PassengerRide,BreakTime,Distance {
    public Taxi(int num, int oil, int speed, int max_passenger, String object) {
        super(num, oil, speed, max_passenger);
    }

    public Taxi(int num) {
        this(num, 100, 0, 4, "목적지");
        int[] taxi_group = new int[num];
        for (int i = 0; i < num; i++) {
            taxi_group[i] = (num % 2 == 0) ? 990 + i * 10 : 997 + i * 7;
            System.out.println("택시 " + taxi_group[i] + " 이 생성되었습니다.");
            System.out.println(taxi_group[i] + "운행");
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
        if (oil <= 10) {
            System.out.println("주유가 필요 합니다.");
        }
    }


    @Override
    public void operate(int x) {
        oil = x;
        System.out.println("주유량: " + x );
        System.out.println("-----------------------");
    }

    @Override
    public void passengerride(int x) {
        if (x > 4) {
            System.out.println("‘최대 승객 수 초과’");
        } else if (x <= 4) {
            System.out.println("탑승 승객 수: " + x);
            System.out.println("기본요금은" + 3000 + "원이고," + 1 + "km 마다 요금이 " + 1000 + "원이 추가 됩니다");
        } else if (x == 0) {
            System.out.println("");
        }
        System.out.println("-----------------------");
    }


    @Override
    public void destination(String destination, int distance) {
        System.out.println("목적지: " + destination);
        System.out.println("목적지까지 거리: " + distance);
        int payment = 3000+((distance-1) * 1000);
        System.out.println("요금 확인: " + (payment) + "원");

    }
}
