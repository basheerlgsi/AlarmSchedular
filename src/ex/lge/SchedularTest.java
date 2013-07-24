package ex.lge;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ex.fk.AlarmAlertSpy;
import ex.fk.FakeTimeService;

public class SchedularTest {

//public static final String MONDAY = null;

	Scheduler scheduler;
	AlarmAlertSpy alarmAlertSpy;
	FakeTimeService fakeTimeService;
	@Before
	public void setUp() throws Exception {
		 
		 alarmAlertSpy = new AlarmAlertSpy();
		 fakeTimeService = new FakeTimeService();
		 scheduler = new Scheduler(alarmAlertSpy,fakeTimeService);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void noAlertIfNoScheduledAlarms() {
	fakeTimeService.setTime("MONDAY", 12*60);
	System.out.print(""+alarmAlertSpy.isAlerted());
	scheduler.wakeup();
	//AlarmAlertSpy alarmAlertSpy = new AlarmAlertSpy();
	System.out.print(""+alarmAlertSpy.isAlerted());
	assertFalse(alarmAlertSpy.isAlerted());
	}
	@Test
	public void alertIfSheduledAndItsTheTime() throws Exception {
	scheduler.addSchedule("MONDAY", 12*60);
	
	fakeTimeService.setTime("MONDAY", 12*60);
	scheduler.wakeup();
	System.out.print(""+alarmAlertSpy.isAlerted());
	//AlarmAlertSpy alarmAlertSpy = new AlarmAlertSpy();
	assertTrue(alarmAlertSpy.isAlerted());
	}
	
}
