package sync;

public class MyHourWithoutSync {
	private MyHour Hour = new MyHour();
	  private Thread[] thread = new Thread[59]; 

	  public static void main(String[] args)
	  {
		  MyHourWithoutSync test = new MyHourWithoutSync();
	    System.out.println("What is Hour ? " +
	      test.Hour.getHour());
	  }

	  public MyHourWithoutSync()
	  {
	    ThreadGroup g = new ThreadGroup("group");
	    boolean done = false;

	    // Create and launch 100 threads
	    for (int i=0; i<24; i++)
	    {
	      thread[i] = new Thread(g, new AddAPennyThread(), "t");
	      thread[i].start();
	    }

	    // Check if all the threads are finished
	    while(!done)
	      if (g.activeCount() == 0)
	        done = true;
	  }


	  // A thread for adding a penny to the MY Hour
	  class AddAPennyThread extends Thread
	  {
	    public void run()
	    {
	      int newHour = Hour.getHour() + 1;

	      try
	      {
	        Thread.sleep(5);
	      }
	      catch (InterruptedException ex)
	      {
	        System.out.println(ex);
	      }

	      Hour.setHour(newHour);
	    }
	  }

}
