public class Taxi extends Transportation implements OilWarn,Operatable,PassengerRide,BreakTime {
    public Taxi(int num, int oil, int speed, int max_passenger  ) {
        super(num, oil, speed, max_passenger );
    }

    public Taxi(int num){
        this(num,100,0,4  );
        int[] taxi_group = new int[num];
        for (int i = 0; i < num; i++) {
            taxi_group[i] = (num % 2 == 0) ? 990 + i*10 : 997 + i*7;
            System.out.println("택시 " + taxi_group[i] + " 이 생성되었습니다.");
        }
    }

    @Override
    public void breaktime(int r) {

    }

    @Override
    public void oilwarn(int x ) {

    }


    @Override
    public void operate(int x) {

    }

    @Override
    public void passengerride(int x) {

    }

    }

