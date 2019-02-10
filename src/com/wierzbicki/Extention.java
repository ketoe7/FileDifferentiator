package com.wierzbicki;

/*


*/

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

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
        boolean indicator = false;
        InputStream is = null;
        StringBuilder sbHex = new StringBuilder();
        try{
            File file = new File(path);
            is = new FileInputStream(file);
            int value;
            //Getting the first bytes of file as hexadecimal numbers (the longest magic number has 32 bytes)
            for(int i=0; (i<32 && (value = is.read()) != -1); i++){
                sbHex.append(String.format("%02x", value));
            }
            /*Printing first bytes of file as hex number (testing purpose only)
            System.out.println("sbHex = " + sbHex.toString());
            */

            for(int i=0; i<magicNumbers.length; i++){ //Check if first bytes of file match to magic number of its extention
                if(sbHex.toString().matches(magicNumbers[i])){
                    System.out.println(sbHex.toString().matches(magicNumbers[i]));
                    indicator = true;
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return indicator;
    }

}
