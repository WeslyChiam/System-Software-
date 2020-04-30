package sync;

public class MyMinuteWithSync {
	private MyMinute Minute = new MyMinute();
	  private Thread[] thread = new Thread[59];

	  public static void main(String[] args)
	  {
	    MyMinuteWithSync test = new MyMinuteWithSync();
	    System.out.println("What is Minute ? " +
	      test.Minute.getMinute());
	  }

	  public MyMinuteWithSync()
	  {
	    ThreadGroup g1 = new ThreadGroup("group");
	    boolean done = false;

	    for (int i=0; i<59; i++)
	    {
	      thread[i] = new Thread(g1, new AddAPennyThread(), "t");
	      thread[i].start();
	    }

	    while(!done)
	      if (g1.activeCount() == 0)
	        done = true;
	  }

	  // Synchronize: add a penny one at a time
	  private static synchronized void addAPenny(MyMinute Minute)
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

	  // A thread for adding a penny to MY Minute
	  class AddAPennyThread extends Thread
	  {
	    public void run()
	    {
	      addAPenny(Minute);
	    }
	  }

}
