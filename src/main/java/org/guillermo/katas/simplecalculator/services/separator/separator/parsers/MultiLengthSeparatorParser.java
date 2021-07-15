package org.guillermo.katas.simplecalculator.services.separator.separator.parsers;

public class MultiLengthSeparatorParser extends  BaseSeparatorParser {
    
    @Override
    public String[] extractSeparators(final String text) {
        
        if (evaluatePattern(text, SEPARATOR_REGEX))
            return new String[]{text.substring(3, text.lastIndexOf(SEPARATOR_SUFFIX))};
        
        return null;
    }
    private static final String SEPARATOR_SUFFIX = "]\\n";
    private static final String SEPARATOR_REGEX = "//\\[.*\\]\\n.*$";
}