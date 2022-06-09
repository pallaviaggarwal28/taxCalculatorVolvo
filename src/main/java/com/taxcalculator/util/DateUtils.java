package com.taxcalculator.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.validation.constraints.NotNull;

public class DateUtils {

  private static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

  @NotNull
  public static LocalDateTime getDateFromString(@NotNull String date) {
    return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
  }
}
