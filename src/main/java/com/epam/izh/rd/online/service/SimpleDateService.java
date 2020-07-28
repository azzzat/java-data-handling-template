package com.epam.izh.rd.online.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SimpleDateService implements DateService {

    /**
     * Метод парсит дату в строку
     *
     * @param localDate дата
     * @return строка с форматом день-месяц-год(01-01-1970)
     */
    @Override
    public String parseDate(LocalDate localDate) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return dtf.format(localDate);
    }

    /**
     * Метод парсит строку в дату
     *
     * @param string строка в формате год-месяц-день часы:минуты (1970-01-01 00:00)
     * @return дата и время
     */
    @Override
    public LocalDateTime parseString(String string) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime date = LocalDateTime.parse(string, dtf);
        return date;
    }

    /**
     * Метод конвертирует дату в строку с заданным форматом
     *
     * @param localDate исходная дата
     * @param formatter формат даты
     * @return полученная строка
     */
    @Override
    public String convertToCustomFormat(LocalDate localDate, DateTimeFormatter formatter) {
        return formatter.format(localDate);
    }

    /**
     * Метод получает следующий високосный год
     *
     * @return високосный год
     */
    @Override
    public long getNextLeapYear() {
        long ld = LocalDate.now().getYear();
        boolean isLeap = false;

        while (!isLeap) {
            if (ld % 100 == 0 && ld % 400 == 0) {
                isLeap = true;
                break;
            } else if (ld % 4 == 0 && ld % 100 != 0) {
                isLeap = true;
                break;
            } else if (ld % 100 == 0) {
                isLeap = true;
                break;
            }
            ld++;
        }

        return ld;
    }

    /**
     * Метод считает число секунд в заданном году
     *
     * @return число секунд
     */
    @Override
    public long getSecondsInYear(int year) {
        long sec;
        boolean isLeap = false;
        if (year % 100 == 0 && year % 400 == 0) {
            isLeap = true;
        } else if (year % 4 == 0 && year % 100 != 0) {
            isLeap = true;
        } else if (year % 100 == 0) {
            isLeap = true;
        }
        if (isLeap) {
            sec = 86400 * 366;
        } else {
            sec = 86400 * 365;
        }

        return sec;
    }


}
