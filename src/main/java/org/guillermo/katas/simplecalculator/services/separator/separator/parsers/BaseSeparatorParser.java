package org.guillermo.katas.simplecalculator.services.separator.separator.parsers;

import org.guillermo.katas.simplecalculator.services.separator.SeparatorParser;

public class BaseSeparatorParser implements SeparatorParser {
    
    private static final String DEFAULT_SEPARATOR_COMA = ",";
    
    public String[] extractSeparators(final String text) {
        return new String[]{DEFAULT_SEPARATOR_COMA};
    }
    
    protected boolean evaluatePattern(String text, String pattern) {
        return text.matches(pattern);
    }
     
     
     protected static final String SEPARATOR_SUFFIX = "\\n";
}
