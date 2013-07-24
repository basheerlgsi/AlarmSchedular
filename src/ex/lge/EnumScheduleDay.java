package ex.lge;

public enum EnumScheduleDay {
	SUNDAY(0), MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(
			6), ALL(7), WORKINGDAY(8);
	private int scheduleday;
	

	EnumScheduleDay(int inuptDay) {
		scheduleday = inuptDay;
	}

	public int getday() {
		return scheduleday;
	}
}
