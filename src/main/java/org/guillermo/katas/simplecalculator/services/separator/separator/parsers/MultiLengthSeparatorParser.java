package org.guillermo.katas.simplecalculator.services.separator.separator.parsers;

import org.apache.commons.lang3.StringUtils;

public class MultiLengthSeparatorParser extends BaseSeparatorParser {
    
    private static final String SEPARATOR_SUFFIX = "\\n";
    private static final String SEPARATOR_REGEX = "//\\[.*\\]\\n.*$";
    
    protected String getSeparatorRegex() {
        return SEPARATOR_REGEX;
    }

    protected String[] extractSeparatorsFromString(final String text) {
        return new String[]{StringUtils.substringBetween(text, "[", "]")};
    }
}