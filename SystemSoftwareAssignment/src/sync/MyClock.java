package sync;

public class MyClock {
	private MyMinute Minute = new MyMinute();
	private MyHour Hour = new MyHour(); 
	private Clock clock = new Clock();
	public MyClock() {
		int Minute1 = Minute.getMinute() + 1;
		int Hour1 = Hour.getHour() + 1; 
		int Minute2 = Minute.getMinute() + 2;
		int Hour2 = Hour.getHour() + 2; 
		int Minute3 = Minute.getMinute() + 3;
		int Hour3 = Hour.getHour() + 3; 
		
	}
	
	  public static void main(String[] args)
	  {
	    MyClock test = new MyClock();
	    System.out.println("What time is it ? " +
	      test.clock.getClock());
	  }
	  //Get the clock data 
	  String newClock = clock.Clock(int Hour1, int Minute1);
}
