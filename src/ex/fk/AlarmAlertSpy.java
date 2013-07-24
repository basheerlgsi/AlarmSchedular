package ex.fk;

import ex.alarm.driver.AlarmAlert;

public class AlarmAlertSpy implements AlarmAlert{

	    boolean bAlert=false;
		public boolean isAlerted() {
		// TODO Auto-generated method stub
		return bAlert;
	}

	@Override
	public void startAlarm() {
		bAlert = true;
		
	}

}
