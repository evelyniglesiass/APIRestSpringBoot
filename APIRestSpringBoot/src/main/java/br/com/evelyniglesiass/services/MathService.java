package br.com.evelyniglesiass.services;

import br.com.evelyniglesiass.exception.UnsupportedMathOperationException;
import br.com.evelyniglesiass.utils.Functions;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    public Double sum(String numberOne, String numberTwo) {

        if(!Functions.isNumeric(numberOne) || !Functions.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        return Functions.convertToDouble(numberOne) + Functions.convertToDouble(numberTwo);
    }

    public Double substraction(String numberOne, String numberTwo) {

        if(!Functions.isNumeric(numberOne) || !Functions.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        return Functions.convertToDouble(numberOne) - Functions.convertToDouble(numberTwo);
    }

    public Double multiplication(String numberOne, String numberTwo) {

        if(!Functions.isNumeric(numberOne) || !Functions.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        return Functions.convertToDouble(numberOne) * Functions.convertToDouble(numberTwo);
    }

    public Double division(String numberOne, String numberTwo) {

        if(!Functions.isNumeric(numberOne) || !Functions.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        return Functions.convertToDouble(numberOne) / Functions.convertToDouble(numberTwo);
    }

    public Double mean(String numberOne, String numberTwo) {

        if(!Functions.isNumeric(numberOne) || !Functions.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        return (Functions.convertToDouble(numberOne) + Functions.convertToDouble(numberTwo)) / 2;
    }

    public Double squareRoot(String number) {

        if(!Functions.isNumeric(number))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        return Math.sqrt(Functions.convertToDouble(number));
    }
}
