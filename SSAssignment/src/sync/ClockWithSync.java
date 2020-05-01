package sync;

import java.text.DecimalFormat;

public class ClockWithSync {
	private MyClock Clock = new MyClock();
	private Thread[] min_thread = new Thread[59];
	private Thread[] hr_thread = new Thread[24];
	static ClockWithSync test = new ClockWithSync();

	  public static void main(String[] args)
	  {
		//First get the integer value of hour and minute
		int hrs = test.Clock.getHour();
		int min = test.Clock.getMinute();
	    //Set the integer value into 2 digit represented for hour and minute 
	    DecimalFormat formatter = new DecimalFormat("00");
	    String hrsFormatted = formatter.format(hrs);
	    String minFormatted = formatter.format(min);
	    //Second get the combined string value of hour and minute, which mark as time
	    String time = test.Clock.mergeClock(hrsFormatted, minFormatted);
		//Output
		System.out.println("What is Time ? " + time);
	  }

	public ClockWithSync()
	  {
	    ThreadGroup g1 = new ThreadGroup("group");
	    boolean done = false;

	    // Create and launch 24 threads for hour
	    for (int i=0; i<24; i++)
	    {
	      hr_thread[i] = new Thread(g1, new AddADigitThread(), "t");
	      hr_thread[i].start();
	    }
	    
	    // Create and launch 59 threads for minute
	    for (int j=0; j<59; j++)
	    {
	      min_thread[j] = new Thread(g1, new AddADigitThread(), "t");
	      min_thread[j].start();
	    }

	    while(!done)
	      if (g1.activeCount() == 0)
	        done = true;
	  }

	  // Synchronize: add a digit one at a time
	  private static synchronized void addADigit(MyClock Clock)
	  {
	    int newHour = Clock.getHour() + 1;
	    int newMin = Clock.getMinute() + 1; 

	    try
	    {
	      Thread.sleep(5);
	    }
	    catch (InterruptedException ex)
	    {
	      System.out.println(ex);
	    }

	    Clock.setHour(newHour);
	    Clock.setMinute(newMin);
	  }

	  // A thread for adding a digit to MyClock
	  class AddADigitThread extends Thread
	  {
	    public void run()
	    {
	      addADigit(Clock);
	    }
	  }
}
