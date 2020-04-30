package sync;

public class Clock {
	private int minute = 0; 
	private int hour = 0; 
	
	public void setMinute(int minute){
		this.minute = minute;
		
	}

	public void setHour(int hour){
		this.hour = hour;
		
	}
	
	public String getClock(int minute, int hour) {
		String Minute, Hour; 
		Hour = String.valueOf(hour);
		Minute = String.valueOf(minute);
		String clock = (Hour + Minute);
		return clock; 
	}
}
