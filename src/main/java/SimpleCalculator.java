import java.util.Arrays;

public class SimpleCalculator {
    
    int add(String numbers){
        if (numbers.length() == 0)
            return 0;
    
        numbers = parseNumbersString(numbers);
        
        return Arrays.stream(Arrays.stream(numbers.split(DEFAULT_SEPARATOR_COMA)).mapToInt(Integer::parseInt).toArray()).reduce(Integer.parseInt("0"), Integer::sum);
    }
    
    private String findSeparator(String text){
        if (! text.startsWith(CUSTOM_SEPARATOR_START))
            return ",";
        
        return text.substring(2, text.lastIndexOf("\n"));
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
}
