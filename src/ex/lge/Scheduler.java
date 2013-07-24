package ex.lge;

import ex.alarm.driver.AlarmAlert;
import ex.os.service.TimeService;
import ex.lge.EnumScheduleDay;

public class Scheduler {

	EnumScheduleDay scheduleDay;
	int ScheduleTime;
	AlarmAlert alarmAlert;
	TimeService timeService;

	public Scheduler(AlarmAlert almspy, TimeService tmservice) {
		alarmAlert = almspy;
		timeService = tmservice;
		ScheduleTime = -1;
		scheduleDay = EnumScheduleDay.SUNDAY;
	}

	public void wakeup() {
		if(scheduleDay.getday()== EnumScheduleDay.WORKINGDAY.getday()) //working days
		{
			for(int enumday =EnumScheduleDay.MONDAY.getday(); enumday < EnumScheduleDay.SATURDAY.getday();enumday++)
			{
				if(timeService.getCurrentMinute() == ScheduleTime)
					alarmAlert.startAlarm();
			}
		}
		else if(scheduleDay.getday()== EnumScheduleDay.ALL.getday() && timeService.getCurrentMinute() == ScheduleTime ) //Alldays
			alarmAlert.startAlarm();
		else if (timeService.getCurrentDay() == scheduleDay.getday()
				&& timeService.getCurrentMinute() == ScheduleTime) {
			alarmAlert.startAlarm();
		}

	}

	public void addSchedule(EnumScheduleDay inputScheduleDay,
			int inputScheduleTime) {
		scheduleDay = inputScheduleDay;
		ScheduleTime = inputScheduleTime;
	}

}
