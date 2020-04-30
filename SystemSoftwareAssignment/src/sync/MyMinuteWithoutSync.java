package sync;

public class MyMinuteWithoutSync {
	private MyMinute Minute = new MyMinute();
	  private Thread[] thread = new Thread[59]; 

	  public static void main(String[] args)
	  {
		  MyMinuteWithoutSync test = new MyMinuteWithoutSync();
	    System.out.println("What is Minute ? " +
	      test.Minute.getMinute());
	  }

	  public MyMinuteWithoutSync()
	  {
	    ThreadGroup g = new ThreadGroup("group");
	    boolean done = false;

	    // Create and launch 100 threads
	    for (int i=0; i<59; i++)
	    {
	      thread[i] = new Thread(g, new AddAPennyThread(), "t");
	      thread[i].start();
	    }

	    // Check if all the threads are finished
	    while(!done)
	      if (g.activeCount() == 0)
	        done = true;
	  }


	  // A thread for adding a penny to the MY Minute
	  class AddAPennyThread extends Thread
	  {
	    public void run()
	    {
	      int newMinute = Minute.getMinute() + 1;

	      try
	      {
	        Thread.sleep(5);
	      }
	      catch (InterruptedException ex)
	      {
	        System.out.println(ex);
	      }

	      Minute.setMinute(newMinute);
	    }
	  }

}
