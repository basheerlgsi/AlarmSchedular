package ex.lge;

import ex.alarm.driver.AlarmAlert;
import ex.fk.AlarmAlertSpy;
import ex.fk.FakeTimeService;
import ex.os.service.TimeService;


public class Scheduler {

	String m_strDay;
	int m_iTime;
	AlarmAlert malmspy;
	TimeService mtmservice;
	
	public Scheduler(AlarmAlert almspy,TimeService tmservice){
		malmspy = almspy;
		mtmservice = tmservice;
		m_iTime=0;
	}
	
	
	public void wakeup() {
		
				
		if (mtmservice.getCurrentDay()== 1 && mtmservice.getCurrentMinute()== m_iTime)
		{
			malmspy.startAlarm();
		}
	
	}

	public void addSchedule(String monday, int i) {
		m_strDay = monday;
		m_iTime = i;
	}

}
