package com.epam.izh.rd.online.service;

import java.io.IOException;
import java.nio.charset.*;
import java.nio.file.*;

public class SimpleRegExpService implements RegExpService {

    /**
     * Метод должен читать файл sensitive_data.txt (из директории resources) и маскировать в нем конфиденциальную информацию.
     * Номер счета должен содержать только первые 4 и последние 4 цифры (1234 **** **** 5678). Метод должен содержать регулярное
     * выражение для поиска счета.
     *
     * @return обработанный текст
     */
    @Override
    public String maskSensitiveData() {
        String[] text;
        StringBuilder answ = new StringBuilder();
        try {
            text = new String(Files.readAllBytes(Paths.get("C:\\Users\\anpuc\\Desktop\\EpamIntroJava\\java-data-handling-template\\src\\main\\resources\\sensitive_data.txt")), StandardCharsets.UTF_8)
                    .replace("\r", "").replace("\n", "").split(" ");

            String reg = "\\d{4}";
            String change = "****";
            for (int i = 3; i < text.length; i++) {
                if (text[i].matches(reg) && text[i - 1].matches(reg) && text[i - 2].matches(reg) && text[i - 3].matches(reg)) {
                    text[i - 1] = change;
                    text[i - 2] = change;
                }
            }

            for (int i = 0; i < text.length - 1; i++) {
                answ.append(text[i] + " ");
            }
            answ.append(text[text.length - 1]);

        } catch (IOException e) {

        }

        return answ.toString();
    }

    /**
     * Метод должен считыввать файл sensitive_data.txt (из директории resources) и заменять плейсхолдер ${payment_amount} и ${balance} на заданные числа. Метод должен
     * содержать регулярное выражение для поиска плейсхолдеров
     *
     * @return обработанный текст
     */
    @Override
    public String replacePlaceholders(double paymentAmount, double balance) {
        String[] text;
        StringBuilder ans = new StringBuilder("");

        try {
            text = new String(Files.readAllBytes(Paths.get("C:\\Users\\anpuc\\Desktop\\EpamIntroJava\\java-data-handling-template\\src\\main\\resources\\sensitive_data.txt")), StandardCharsets.UTF_8)
                    .replace("\r", "").replace("\n", "").split(" ");

            for (int i = 0; i < text.length; i++) {
                if (text[i].equals("${payment_amount}")) {
                    text[i] = (int) paymentAmount + "";
                }
                if (text[i].equals("${balance}")) {
                    text[i] = (int) balance + "";
                }
            }
            for (int i = 0; i < text.length - 1; i++) {
                ans.append(text[i] + " ");
            }
            ans.append(text[text.length - 1]);

        } catch (IOException e) {

        }

        return ans.toString();

    }
}
