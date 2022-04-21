package com.test.utils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DateTimeExample {

    public static Map<String, List<DateTime>> getDataGroupingDate(List<DateTime> list) {

        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        return list.stream().collect(Collectors.groupingBy(e ->
                dateFormat.format(new Date(e.getMillis())), Collectors.toList()));
    }

    private static List<DateTime> getList() {

        return List.of(new DateTime(2022, 04, 21, 00, 00, 00, DateTimeZone.UTC),
                       new DateTime(2022, 04, 21, 00, 00, 01, DateTimeZone.UTC),
                       new DateTime(2022, 04, 21, 01, 00, 00, DateTimeZone.UTC),
                       new DateTime(2022, 04, 21, 01, 00, 02, DateTimeZone.UTC),
                       new DateTime(2022, 04, 21, 11, 59, 59, DateTimeZone.UTC),
                       new DateTime(2022, 04, 22, 00, 00, 00, DateTimeZone.UTC));
    }

    public static void main(String[] args) {
        Map<String, List<DateTime>> groupData = getDataGroupingDate(getList());
        groupData.keySet().forEach(k -> System.out.println(k + ":" + groupData.get(k)));
    }
}