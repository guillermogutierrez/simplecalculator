package org.guillermo.katas.simplecalculator.services.separator;

import org.guillermo.katas.simplecalculator.services.separator.separator.parsers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class SeparatorParserService {
    
    private final List<SeparatorParser> parsers;
    
    public SeparatorParserService(){
        parsers = new ArrayList<>();
        parsers.add(new MultiSeparatorParser());
        parsers.add(new MultiLengthSeparatorParser());
        parsers.add(new CustomSeparatorsParser());
        parsers.add(new BaseSeparatorParser());
    }
    
    public String[] identifySeparators(String text){
        for (SeparatorParser parser: parsers) {
            String [] separators = parser.extractSeparators(text);
            if (separators.length != 0)
                return separators;
        }
        return new String[0];
    }
    
    public String concatenateSeparators(String[] separators){
        return String.join("|", separators);
    }
    
    public Boolean containsSeparatorPattern(String text){
        return text.matches("//.*\\\\n.*$");
    }
    
    public final static String DEFAULT_SEPARATOR_COMA = ",";
}
