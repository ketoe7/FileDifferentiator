package com.wierzbicki;

/*


*/

public class Extention {
    private final String extentionSymbol;
    private final String[] magicNumbers;

    public Extention(String extentionSymbol, String[] magicNumbers) {
        this.extentionSymbol = extentionSymbol;
        this.magicNumbers = magicNumbers;
    }

    public String getExtentionSymbol() {
        return extentionSymbol;
    }

    public String[] getMagicNumbers() {
        return magicNumbers;
    }

    // Method which judges if extention of given file is true
    public boolean checkIfExtentionIsTrue(String path){

        return true;
    }

}
