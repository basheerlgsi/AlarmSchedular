package ex.schedulertest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ex.lge.EnumScheduleDay;
import ex.lge.Scheduler;

public class SchedularTest {

	Scheduler scheduler;
	AlarmAlertSpy alarmAlertSpy;
	FakeTimeService fakeTimeService;
	int scheduleTime;

	@Before
	public void setUp() throws Exception {

		alarmAlertSpy = new AlarmAlertSpy();
		fakeTimeService = new FakeTimeService();
		scheduler = new Scheduler(alarmAlertSpy, fakeTimeService);
		scheduleTime = -1;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void noAlertIfNoScheduledAlarms() {
		scheduleTime = 12 * 60; // 12 Noon
		fakeTimeService.setTime(EnumScheduleDay.MONDAY, scheduleTime);
		scheduler.wakeup();
		assertFalse(alarmAlertSpy.isAlerted());
	}
	
	@Test
	public void alertIfSheduledAndItsTheTime() throws Exception {
		scheduleTime = 12 * 60; // 12 Noon
		scheduler.addSchedule(EnumScheduleDay.MONDAY, scheduleTime);
		fakeTimeService.setTime(EnumScheduleDay.MONDAY, scheduleTime);
		scheduler.wakeup();
		assertTrue(alarmAlertSpy.isAlerted());
	}
	
	@Test
	public void noalertIfSheduledAndItsNotTheTime() throws Exception {
		scheduleTime = 12 * 60; // 12 Noon
		scheduler.addSchedule(EnumScheduleDay.MONDAY, scheduleTime);
		fakeTimeService.setTime(EnumScheduleDay.THURSDAY, scheduleTime);
		scheduler.wakeup();
		assertFalse(alarmAlertSpy.isAlerted());
	}
	
	@Test
	public void alertItsTheTimeForAllDays() throws Exception {
		scheduleTime = 12 * 60; // 12 Noon
		scheduler.addSchedule(EnumScheduleDay.ALL, scheduleTime);
		for (EnumScheduleDay enumDay : EnumScheduleDay.values())
		{
			fakeTimeService.setTime(enumDay, scheduleTime);
			scheduler.wakeup();
			assertTrue(alarmAlertSpy.isAlerted());
			if (enumDay.getday()==EnumScheduleDay.SATURDAY.getday()){
				break;
			}			
		}
		
	}
	
	@Test
	public void alertIfItsScheduleTimeAndIfWorkingDays() throws Exception {
		scheduleTime = 12 * 60; // 12 Noon
		scheduler.addSchedule(EnumScheduleDay.WORKINGDAY, 300);
		fakeTimeService.setTime(EnumScheduleDay.TUESDAY, scheduleTime);
		scheduler.wakeup();
		assertFalse(alarmAlertSpy.isAlerted());
	}
	
	

}
