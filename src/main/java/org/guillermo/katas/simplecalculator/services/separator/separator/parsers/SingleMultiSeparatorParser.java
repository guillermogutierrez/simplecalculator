package org.guillermo.katas.simplecalculator.services.separator.separator.parsers;

import java.util.regex.Pattern;

public class SingleMultiSeparatorParser extends BaseSeparatorParser {
    private static final String SEPARATOR_REGEX = "//\\[\\S+\\]\\\\n.*$";
    
    @Override
    public String[] extractSeparators(final String text) {
        
        if (evaluatePattern(text, SEPARATOR_REGEX)) {
            
            var separators = text.substring(2, text.lastIndexOf(SEPARATOR_SUFFIX));
            return separators.replaceAll(Pattern.quote("["), "").split("]");
        }
        return null;
    }
}
