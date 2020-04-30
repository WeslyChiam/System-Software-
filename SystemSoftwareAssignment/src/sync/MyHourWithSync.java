package sync;

public class MyHourWithSync {
	private MyHour Hour = new MyHour();
	  private Thread[] thread = new Thread[59];

	  public static void main(String[] args)
	  {
	    MyHourWithSync test = new MyHourWithSync();
	    System.out.println("What is Hour ? " +
	      test.Hour.getHour());
	  }

	  public MyHourWithSync()
	  {
	    ThreadGroup g1 = new ThreadGroup("group");
	    boolean done = false;

	    for (int i=0; i<24; i++)
	    {
	      thread[i] = new Thread(g1, new AddAPennyThread(), "t");
	      thread[i].start();
	    }

	    while(!done)
	      if (g1.activeCount() == 0)
	        done = true;
	  }

	  // Synchronize: add a penny one at a time
	  private static synchronized void addAPenny(MyHour Hour)
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

	  // A thread for adding a penny to MY Hour
	  class AddAPennyThread extends Thread
	  {
	    public void run()
	    {
	      addAPenny(Hour);
	    }
	  }

}
