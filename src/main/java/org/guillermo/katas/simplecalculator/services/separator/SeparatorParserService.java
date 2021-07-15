package org.guillermo.katas.simplecalculator.services.separator;

import org.guillermo.katas.simplecalculator.services.separator.separator.parsers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class SeparatorParserService {
    
    private final List<SeparatorParser> parsers;
    
    public SeparatorParserService(){
        parsers = new ArrayList<SeparatorParser>();
        parsers.add(new SingleMultiSeparatorParser());
        parsers.add(new MultiLengthSeparatorParser());
        parsers.add(new CustomSeparatorsParser());
        parsers.add(new BaseSeparatorParser());
    }
    
    public String[] identifySeparators(String text){
        for (SeparatorParser parser: parsers) {
            String [] separators = parser.extractSeparators(text);
            if (separators != null)
                return separators;
        }
        return new String[0];
    }
    
    public String concatenateSeparators(String[] separators){
        
        StringBuilder stringSeparator = new StringBuilder();
        
        Arrays.stream(separators).forEach(s -> stringSeparator.append(Pattern.quote(s)).append("|"));
        
        stringSeparator.append("\\n");
        
        return stringSeparator.toString();
    }
    
    public final static String DEFAULT_SEPARATOR_COMA = ",";
}
