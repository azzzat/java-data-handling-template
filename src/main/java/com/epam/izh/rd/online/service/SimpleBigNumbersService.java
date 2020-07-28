package com.epam.izh.rd.online.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class SimpleBigNumbersService implements BigNumbersService {

    /**
     * Метод делит первое число на второе с заданной точностью
     * Например 1/3 с точностью 2 = 0.33
     * @param range точность
     * @return результат
     */
    @Override
    public BigDecimal getPrecisionNumber(int a, int b, int range) {
        BigDecimal bA = BigDecimal.valueOf(a);
        BigDecimal bB = BigDecimal.valueOf(b);
        MathContext mc = new MathContext(range);

        BigDecimal divide = bA.divide(bB, mc);

        return divide;
    }


    /**
     * Метод находит простое число по номеру
     *
     * @param range номер числа, считая с числа 2
     * @return простое число
     */
    @Override
    public BigInteger getPrimaryNumber(int range) {
        long num = 2;
        int rangeNum = 1;

        while (rangeNum <= range) {
            num++;
            boolean isPrime = true;
            for (long i = 2; i < num ; i++) {

                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                rangeNum++;
            }

        }
        BigInteger BigNum = new BigInteger(num + "");
        return BigNum;
    }
}
