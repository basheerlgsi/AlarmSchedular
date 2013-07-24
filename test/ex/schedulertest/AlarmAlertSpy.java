package ex.schedulertest;

import ex.alarm.driver.AlarmAlert;

public class AlarmAlertSpy implements AlarmAlert {

	boolean booleanAlert = false;

	public boolean isAlerted() {
		// TODO Auto-generated method stub
		return booleanAlert;
	}

	@Override
	public void startAlarm() {
		booleanAlert = true;

	}

}
