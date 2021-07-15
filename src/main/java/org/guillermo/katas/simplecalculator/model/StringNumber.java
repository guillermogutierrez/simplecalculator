package org.guillermo.katas.simplecalculator.model;

public class StringNumber {
    
    private String[] separators;
    private int[] numbers;
    
    public StringNumber(final String[] separators, final int[] numbers) {
        this.separators = separators;
        this.numbers = numbers;
    }
    
    public String[] getSeparators() {
        return separators;
    }
    
    public int[] getNumbers() {
        return numbers;
    }
    
    public void setSeparators(final String[] separators) {
        this.separators = separators;
    }
    
    public void setNumbers(final int[] numbers) {
        this.numbers = numbers;
    }
}
