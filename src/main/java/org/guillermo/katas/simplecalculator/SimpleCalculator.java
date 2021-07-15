package org.guillermo.katas.simplecalculator;

import org.guillermo.katas.simplecalculator.model.NegativeValueException;
import org.guillermo.katas.simplecalculator.model.StringNumber;
import org.guillermo.katas.simplecalculator.services.numbers.NumberParserService;

import java.util.Arrays;

public class SimpleCalculator {
    
    private static final Integer TOP_THRESHOLD = 1000;
    private final NumberParserService numberParserService;
    
    public SimpleCalculator() {
        this.numberParserService = new NumberParserService();
    }
    
    public int add(String numbers) throws NegativeValueException {
        
        if (numbers.length() == 0)
            return 0;
        
        StringNumber stringNumber = numberParserService.parseInputNumbers(numbers);
        
        int[] negativeNumbers = numberParserService.findNegativeNumbers(stringNumber.getNumbers());
        
        if (negativeNumbers.length > 0) {
            throw new NegativeValueException(negativeNumbers);
        }
        
        return sumNumbers(stringNumber.getNumbers());
    }
    
    private int sumNumbers(int[] inputNumbers) {
        return Arrays.stream(inputNumbers).filter(a -> a <= TOP_THRESHOLD).reduce(Integer.parseInt("0"), Integer::sum);
    }
}
