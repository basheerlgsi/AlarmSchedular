package ex.fk;

//import java.util.*;

import ex.os.service.TimeService;

public class FakeTimeService implements TimeService{

	String m_strDay;
	int m_iTime;
	
	public void setTime(String monday, int i) {
		
		m_strDay=monday;
		m_iTime =i;
	}

	@Override
	public int getCurrentDay() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getCurrentMinute() {
		// TODO Auto-generated method stub
		
		return m_iTime;
	}

}
