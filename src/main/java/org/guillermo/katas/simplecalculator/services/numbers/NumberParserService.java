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
        
        int[] parsedNumbers = extractNumbers(numbers, separators);
        
        return new StringNumber(separators, parsedNumbers);
    }
    
    private int[] extractNumbers(String numbers, String[] separators) {
        
        numbers = parseNumbersString(numbers, separators);
        
        return Arrays.stream(numbers.split(SeparatorParserService.DEFAULT_SEPARATOR_COMA)).mapToInt(Integer::parseInt).toArray();
    }
    
    private String parseNumbersString(String numbers, String[] separators) {
        
        if (separatorService.containsSeparatorPattern(numbers))
            numbers = numbers.substring(numbers.indexOf(CUSTOM_SEPARATOR_REGEX_END) + CUSTOM_SEPARATOR_REGEX_END.length());
        
        return numbers.replaceAll(separatorService.concatenateSeparators(separators), SeparatorParserService.DEFAULT_SEPARATOR_COMA);
    }
}
