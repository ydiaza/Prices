package com.inditex.ecommerce.infrastructure.helpers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeConverter {

    public static final String PATTERN = "yyyy-MM-dd-HH.mm.ss";

    public static LocalDateTime dateConverterFromStringToLocalDateTime (String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);
        return LocalDateTime.parse(date, formatter);
    }
}
