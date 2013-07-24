package ex.schedulertest;

import ex.os.service.TimeService;
import ex.lge.EnumScheduleDay;

public class FakeTimeService implements TimeService {

	EnumScheduleDay scheduleDay;
	int scheduleTime;

	public void setTime(EnumScheduleDay inputScheduleDay, int inputscheduleTime) {

		scheduleDay = inputScheduleDay;
		scheduleTime = inputscheduleTime;
	}

	@Override
	public int getCurrentDay() {

		return scheduleDay.getday();
	}

	@Override
	public int getCurrentMinute() {

		return scheduleTime;
	}

}
