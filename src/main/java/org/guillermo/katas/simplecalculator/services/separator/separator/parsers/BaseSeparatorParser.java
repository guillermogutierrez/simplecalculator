package org.guillermo.katas.simplecalculator.services.separator.separator.parsers;

import org.guillermo.katas.simplecalculator.services.separator.SeparatorParser;

import java.util.Arrays;
import java.util.regex.Pattern;

public class BaseSeparatorParser implements SeparatorParser {
    
    protected static final String SEPARATOR_SUFFIX = "\\n";
    private static final String SEPARATOR_REGEX = ".*$";
    private static final String COMA_SEPARATOR = ",";
    private static final String NEW_LINE_SEPARATOR = "\\n";
    
    public String[] extractSeparators(final String text) {
        return patternQuoteSeparators(parseNumbersString(text));
    }
    
    protected String[] patternQuoteSeparators(String[] separators) {
        
        if (separators.length == 0)
            return new String[0];
        
        Arrays.setAll(separators, separator -> Pattern.quote(separators[separator]));
        
        return separators;
    }
    
    protected String[] parseNumbersString(final String text) {
        
        if (evaluatePattern(text, getSeparatorRegex())) {
            return extractSeparatorsFromString(text);
        }
        
        return new String[0];
    }
    
    protected boolean evaluatePattern(String text, String pattern) {
        return text.matches(pattern);
    }
    
    protected String getSeparatorRegex() {
        return SEPARATOR_REGEX;
    }
    
    protected String[] extractSeparatorsFromString(final String text) {
        return new String[]{COMA_SEPARATOR, NEW_LINE_SEPARATOR};
    }
}
