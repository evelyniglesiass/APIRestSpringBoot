package br.com.evelyniglesiass.utils;

import br.com.evelyniglesiass.exception.UnsupportedMathOperationException;
import org.springframework.stereotype.Service;

@Service
public class Functions {

    private static final String REGEX_NUMBER = "[-+]?[0-9]*\\.?[0-9]+";

    public static Double convertToDouble(String strNumber) {
        if (strNumber == null || strNumber.isEmpty())
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        String number = strNumber.replace(",", ".");

        return Double.parseDouble(number);
    }

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");

        return number.matches(REGEX_NUMBER);
    }
}
