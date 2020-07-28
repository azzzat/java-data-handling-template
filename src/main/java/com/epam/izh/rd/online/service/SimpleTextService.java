package com.epam.izh.rd.online.service;

public class SimpleTextService implements TextService {

    /**
     * Реализовать функционал удаления строки из другой строки.
     *
     * Например для базовой строки "Hello, hello, hello, how low?" и строки для удаления ", he"
     * метод вернет "Hellollollo, how low?"
     *
     * @param base - базовая строка с текстом
     * @param remove - строка которую необходимо удалить
     */
    @Override
    public String removeString(String base, String remove) {
        String[] str = base.split(remove);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            ans.append(str[i]);
        }
        return ans.toString();
    }

    /**
     * Реализовать функционал проверки на то, что строка заканчивается знаком вопроса.
     *
     * Например для строки "Hello, hello, hello, how low?" метод вернет true
     * Например для строки "Hello, hello, hello!" метод вернет false
     */
    @Override
    public boolean isQuestionString(String text) {
        return text.endsWith("?");
    }

    /**
     * Реализовать функционал соединения переданных строк.
     *
     * Например для параметров {"Smells", " ", "Like", " ", "Teen", " ", "Spirit"}
     * метод вернет "Smells Like Teen Spirit"
     */
    @Override
    public String concatenate(String... elements) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < elements.length; i++) {
            ans.append(elements[i]);
        }
        return ans.toString();
    }

    /**
     * Реализовать функционал изменения регистра в вид лесенки.
     * Возвращаемый текст должен начинаться с прописного регистра.
     *
     * Например для строки "Load Up On Guns And Bring Your Friends"
     * метод вернет "lOaD Up oN GuNs aNd bRiNg yOuR FrIeNdS".
     */
    @Override
    public String toJumpCase(String text) {
        String lowText = text.toLowerCase();
        String upText = text.toUpperCase();

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (i % 2 == 0) {
                ans.append(lowText.charAt(i));
            } else {
                ans.append(upText.charAt(i));
            }
        }

        return ans.toString();
    }

    /**
     * Метод определяет, является ли строка палиндромом.
     *
     * Палиндром - строка, которая одинаково читается слева направо и справа налево.
     *
     * Например для строки "а роза упала на лапу Азора" вернется true, а для "я не палиндром" false
     */
    @Override
    public boolean isPalindrome(String string) {
       boolean polindrome = true;

       String text = string.toLowerCase().replace(" ", "");
       if (text.length() == 0) {
           return false;
       }
       for (int i = 0; i < text.length(); i++) {
           if (text.charAt(i) != text.charAt(text.length() - 1 - i)) {
               polindrome = false;
           }
       }
       return polindrome;
    }
}
