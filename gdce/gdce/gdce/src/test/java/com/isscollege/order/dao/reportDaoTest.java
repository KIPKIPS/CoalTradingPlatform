package com.isscollege.order.dao;

import java.util.Calendar;

import org.junit.Test;



public class reportDaoTest {

	@Test
	public void CalendarTest(){
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(calendar.get(Calendar.MONTH));
		System.out.println(calendar.get(Calendar.DATE));
	}
}
