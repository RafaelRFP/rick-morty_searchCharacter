package com.RRF.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateUtils {
    public static String formatoFechaHora(String fecha) {
        String date = fecha;
        OffsetDateTime inst = OffsetDateTime.ofInstant(Instant.parse(date), ZoneId.systemDefault());
        return (DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").format(inst));
    }
    public static String formatoFechaESP(String fecha) {
        String date = fecha;
        OffsetDateTime inst = OffsetDateTime.ofInstant(Instant.parse(date), ZoneId.systemDefault());
        return (DateTimeFormatter.ofPattern("dd/MM/yyyy").format(inst));
    }

    public static String formatoFechaJson(String fecha) {
        String dateStr = fecha;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        //LocalDate date = LocalDate.parse(dateStr, formatter);
        return (LocalDate.parse(dateStr, formatter)).toString();
    }


}
