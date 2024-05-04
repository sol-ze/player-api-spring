package com.sol.playerapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Date;
import java.util.Calendar;
import org.junit.jupiter.api.Test;
import com.sol.Utils.DateUtils;

public class DateUtilsTest {
	
	@Test
    public void testBuildSQLDateValidateReturnsCorrectDate() {
        int year = 2023;
        int month = 1;
        int day = 1;

        Date date = DateUtils.buildSQLDate(year, month, day);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        assertEquals(year, calendar.get(Calendar.YEAR));
        assertEquals(month - 1, calendar.get(Calendar.MONTH));
        assertEquals(day, calendar.get(Calendar.DAY_OF_MONTH));
    }
	
	@Test
    public void testBuildSQLDateValidateReturnsNonExistDate() {
        int year = 2023;
        int month = 2;
        int day = 31;

        assertThrows(IllegalArgumentException.class, () -> {
            DateUtils.buildSQLDate(year, month, day);
        });
    }
	
	@Test
    public void testBuildSQLDateValidateReturnsWrongDate() {
        int year = 2023;
        int month = 20;
        int day = 333;

        assertThrows(IllegalArgumentException.class, () -> {
            DateUtils.buildSQLDate(year, month, day);
        });
    }


}
