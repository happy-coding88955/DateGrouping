package com.test;


import com.test.utils.DateTimeExample;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GroupingDateTimeExample {

    @Test
    public void testWithSingleDate() {
        List<DateTime> dateTimes = List.of(new DateTime(2022, 04, 21, 00, 00, 00, DateTimeZone.UTC),
                new DateTime(2022, 04, 21, 00, 00, 01, DateTimeZone.UTC));

        Assertions.assertTrue(DateTimeExample.getDataGroupingDate(dateTimes).keySet().size() == 1);
        Assertions.assertTrue(DateTimeExample.getDataGroupingDate(dateTimes).get("21-Apr-2022").size() == 2);
    }

    @Test
    public void testWithMultiDates() {
        List<DateTime> dateTimes = List.of(new DateTime(2022, 04, 21, 00, 00, 00, DateTimeZone.UTC),
                new DateTime(2022, 04, 22, 00, 59, 01, DateTimeZone.UTC));

        Assertions.assertTrue(DateTimeExample.getDataGroupingDate(dateTimes).keySet().size() == 2);
        Assertions.assertTrue(DateTimeExample.getDataGroupingDate(dateTimes).get("21-Apr-2022").size() == 1);
        Assertions.assertTrue(DateTimeExample.getDataGroupingDate(dateTimes).get("22-Apr-2022").size() == 1);
    }
}
