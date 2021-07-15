package org.guillermo.katas.simplecalculator.services.separator.separator.parsers;

import org.apache.commons.lang3.StringUtils;

public class MultiSeparatorParser extends BaseSeparatorParser {
    private static final String SEPARATOR_REGEX = "//\\[\\S+\\]\\\\n.*$";
    
    protected String getSeparatorRegex() {
        return SEPARATOR_REGEX;
    }
    
    protected String[] extractSeparatorsFromString(final String text) {
        return StringUtils.replaceEachRepeatedly(StringUtils.substringBetween(text, "//", "\\n"), new String[]{"[", "]"}, new String[]{"", ","}).split(",");
    }
    
}
