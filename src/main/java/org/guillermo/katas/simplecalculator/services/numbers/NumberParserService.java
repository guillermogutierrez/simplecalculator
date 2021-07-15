package org.guillermo.katas.simplecalculator.services.numbers;

import org.guillermo.katas.simplecalculator.model.StringNumber;
import org.guillermo.katas.simplecalculator.services.separator.SeparatorParserService;

import java.util.Arrays;

public class NumberParserService {
    
    private static final String CUSTOM_SEPARATOR_REGEX_END = "\\n";
    private final SeparatorParserService separatorService;
    
    public NumberParserService() {
        this.separatorService = new SeparatorParserService();
    }
    
    public int[] findNegativeNumbers(int[] inputNumbers) {
        return Arrays.stream(inputNumbers).filter(a -> a < 0).toArray();
    }
    
    public StringNumber parseInputNumbers(String numbers) {
        String[] separators = separatorService.identifySeparators(numbers);
        
        if (!separators[0].equals(","))
            numbers = numbers.substring(numbers.indexOf(CUSTOM_SEPARATOR_REGEX_END) + 1);
        
        return new StringNumber(separators, extractNumbers(parseNumbersString(numbers, separators)));
    }
    
    public int[] extractNumbers(String numbers) {
        return Arrays.stream(numbers.split(SeparatorParserService.DEFAULT_SEPARATOR_COMA)).mapToInt(Integer::parseInt).toArray();
    }
    
    private String parseNumbersString(String numbers, String[] separators) {
        
        if (!separators[0].equals(","))
            numbers = numbers.substring(numbers.indexOf(CUSTOM_SEPARATOR_REGEX_END) + 2);
        
        return numbers.replaceAll(separatorService.concatenateSeparators(separators), SeparatorParserService.DEFAULT_SEPARATOR_COMA);
    }
}
