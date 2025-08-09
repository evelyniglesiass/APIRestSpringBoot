package br.com.evelyniglesiass.controllers;

import br.com.evelyniglesiass.services.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @Autowired
    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @RequestMapping(value="/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        return mathService.sum(numberOne, numberTwo);
    }

    @RequestMapping(value="/substraction/{numberOne}/{numberTwo}")
    public Double substraction(@PathVariable("numberOne") String numberOne,
                               @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        return mathService.substraction(numberOne, numberTwo);
    }

    @RequestMapping(value="/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne") String numberOne,
                                 @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        return mathService.multiplication(numberOne, numberTwo) ;
    }

    @RequestMapping(value="/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable("numberOne") String numberOne,
                           @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        return mathService.division(numberOne, numberTwo);
    }

    @RequestMapping(value="/mean/{numberOne}/{numberTwo}")
    public Double mean(@PathVariable("numberOne") String numberOne,
                       @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        return mathService.mean(numberOne, numberTwo);
    }

    @RequestMapping(value="/squareroot/{number}")
    public Double squareRoot(@PathVariable("number") String number
    ) throws Exception {
        return mathService.squareRoot(number);
    }
}