package PackageAccessQue;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskExample 
{
	
	//To run code automatical
	 //	public void run() 
	 	{
	        System.out.println("Start time:" + new Date());
	        doSomeWork();
	        System.out.println("End time:" + new Date());
	    }
	 
	    // simulate a time consuming task
	    private void doSomeWork()
	    {
	        try 
	        {
	            Thread.sleep(10000);
	        } 
	        catch (InterruptedException e)
	        {
	            e.printStackTrace();
	        }
	    }
	 
	    public static void main(String args[]) 
	    {
	 
	        TimerTaskExample timerTask = new TimerTaskExample();
	       
	        // running timer task as daemon thread
	        Timer timer = new Timer(true);
	        timer.scheduleAtFixedRate(timerTask, 0, 10 * 1000);
	        System.out.println("TimerTask begins! :" + new Date());
	       
	        // cancel after sometime
	        try 
	        {
	            Thread.sleep(20000);
	        } 
	        catch (InterruptedException e)
	        {
	            e.printStackTrace();
	        }
	        timer.cancel();
	        System.out.println("TimerTask cancelled! :" + new Date());
	        try 
	        {
	            Thread.sleep(30000);
	        }
	        catch (InterruptedException e) 
	        {
	            e.printStackTrace();
	        }
	    }
	 
	}


/*

import java.util.Timer;
import java.util.TimerTask;

public class KeepMeAwake {

 *
 * @param args
 */
public static void main(String[] args) {

    TimerTask action = new TimerTask() {
        public void run() {
            Beep b = Beep.getInstance();
            b.beep();
        }
    };

    Timer caretaker = new Timer();
    caretaker.schedule(action, 1000, 5000);
    }
}
*/