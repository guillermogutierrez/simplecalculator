package org.guillermo.katas.simplecalculator.model;

import java.util.Arrays;

public class NegativeValueException extends  RuntimeException{
    
    public NegativeValueException(final String exceptionMessage) {
        super(exceptionMessage);
    }
    
    public NegativeValueException(final int[] negativeValues) {
        super(generateMessage(negativeValues));
    }
    
    private static String generateMessage(final int[] negativeValues){
        StringBuilder exceptionMessage = new StringBuilder();
        exceptionMessage.append(DEFAULT_MESSAGE);
        Arrays.stream(negativeValues).forEach(a -> exceptionMessage.append(" ").append(a));
        return exceptionMessage.toString();
    }
    
    private static final String DEFAULT_MESSAGE = "negatives not allowed:";
}
