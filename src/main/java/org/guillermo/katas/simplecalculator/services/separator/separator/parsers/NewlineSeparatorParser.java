package org.guillermo.katas.simplecalculator.services.separator.separator.parsers;

public class NewlineSeparatorParser extends BaseSeparatorParser{
    
    @Override
    public String[] extractSeparators(final String text) {
        return new String[0];
    }
    
    private static final String SEPARATOR_REGEX = ",";
    private static final String SIMPLE_SEPARATOR_NEW_LINE = "\\n";
}
