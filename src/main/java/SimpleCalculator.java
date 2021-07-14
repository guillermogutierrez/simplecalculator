import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SimpleCalculator {
    
    int add(String numbers) throws NegativeValueException{
        if (numbers.length() == 0)
            return 0;
    
        String numbersParsed = parseNumbersString(numbers);
    
        int[] inputNumbers = extractNumbers(numbersParsed);
        
        int[] negativeNumbers = findNegativeNumbers(inputNumbers);
        
        if (negativeNumbers.length > 0){
            throw new NegativeValueException(negativeNumbers);
        }
        
        return sumNumbers(inputNumbers);
    }
    
    private int[] extractNumbers(String numbers){
        return Arrays.stream(numbers.split(DEFAULT_SEPARATOR_COMA)).mapToInt(Integer::parseInt).toArray();
    }
    
    private int[] findNegativeNumbers(int[] inputNumbers){
        return Arrays.stream(inputNumbers).filter(a -> a <0).toArray();
    }
    
    private String findSeparator(String text){
        return (text.startsWith(CUSTOM_SEPARATOR_START)) ? text.substring(2, text.lastIndexOf(DEFAULT_SEPARATOR_NEW_LINE)) : DEFAULT_SEPARATOR_COMA;
    }
    
    private int sumNumbers(int[] inputNumbers){
        return Arrays.stream(inputNumbers).filter(a -> a <= TOP_THRESHOLD).reduce(Integer.parseInt("0"), Integer::sum);
    }
    
    private String parseNumbersString(String numbers){
        String separator = findSeparator(numbers);
        
        if (! separator.equals(","))
            numbers = numbers.replaceAll(CUSTOM_SEPARATOR_REGEX, "");
        
        return numbers.replaceAll(separator, DEFAULT_SEPARATOR_COMA).replaceAll(DEFAULT_SEPARATOR_NEW_LINE, DEFAULT_SEPARATOR_COMA);
    }
    
    private static final String CUSTOM_SEPARATOR_START = "//";
    private static final String CUSTOM_SEPARATOR_END = "\n";
    private static final String DEFAULT_SEPARATOR_COMA = ",";
    private static final String DEFAULT_SEPARATOR_NEW_LINE = "\n";
    private static final String CUSTOM_SEPARATOR_REGEX = CUSTOM_SEPARATOR_START + "." + CUSTOM_SEPARATOR_END;
    private static final Integer TOP_THRESHOLD = 1000;
}
