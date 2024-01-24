package ch08.sec06;

public class ReniteControlExample {
	
	public static void main(String[] args) {
		
		RemoteControl rc;
		
		rc = new Television();
		rc.turnOn();
		rc.setVolume(5);
		rc.turnOff();
		
		rc.setMute(true);
		rc.setMute(false);
		System.out.println("현재 볼륨: " + rc.getVolume());
		
		rc = new Audio();
		rc.setVolume(7);
		rc.setMute(true);
		rc.setMute(false);
		System.out.println("현재 볼륨: " + rc.getVolume());
		
		RemoteControl.changeBattery();
	}
}
