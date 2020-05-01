package sync;

public class MyClock {
	private int minute = 0; 
	private int hour = 0; 
	private String clock = ""; 
	
	public int getMinute(){
		return minute;
		
	}
	
	public int getHour() {
		return hour; 
	}
	
	public void setMinute(int minute){
		this.minute = minute;
		
	}
	
	public void setHour(int hour) {
		this.hour = hour; 
	}
	
	public String mergeClock(String hour, String minute) {
		String strTime; 
		strTime = (hour + minute);
		return strTime; 
	}
	
	public String getClock(){
		return clock; 
	}
	
	public void setClock(String clock) {
		this.clock = clock; 
	}
	
}
