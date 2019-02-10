package com.wierzbicki;

import java.io.*;
import java.util.*;


public class Extentions implements Map<String, Extention>{

    // Map for containing extention shortcut and corresponding object of Extention class
    private  static Map<String, Extention> extentions = new HashMap<String, Extention>();


    // Reading all extentions and their magic numbers from the text file 'extentions.txt'
    static{

        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader("extentions.txt"));
            String line = reader.readLine();
            while(line!=null){

                String[] parts = line.split(",");
                String[] magicNumbers = new String[parts.length-1];
                for(int i=0; i<parts.length-1; i++){
                    magicNumbers[i] = parts[i+1];
                }
                /* Testing purpose only
                    System.out.println("Imported ext. " + parts[0] + " with magicNumbers: " + Arrays.toString(magicNumbers));
                */
                extentions.put(parts[0], new Extention(parts[0], magicNumbers));
                line = reader.readLine();
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }


    //Method for checking what is the real extention in case of detecting the lie
    public boolean searchForRealExtention(String path){
        boolean indicator = false;
        InputStream is = null;
        StringBuilder sbHex = new StringBuilder();

        BufferedReader reader = null;
        try {
            File file = new File(path);
            is = new FileInputStream(file);
            int value;
            //Getting first bytes of file in format of hex number
            for(int i=0; (i<32 && (value = is.read()) != -1); i++){
                sbHex.append(String.format("%02x", value));
            }

            reader = new BufferedReader(new FileReader(
                    "extentions.txt"));
            String line = reader.readLine();
            //Go through all extentions to check if any of them match the file
            while (line != null) {
                String[] magicNumbers = line.split(",");
                for(int i=1; i<magicNumbers.length; i++){
                    if(sbHex.toString().matches(magicNumbers[i])){
                        System.out.println("The real extention is " + magicNumbers[0]);
                        indicator = true;
                    }
                }
                line = reader.readLine();
            }
            if(!indicator) {
                System.out.println("The real extention is unknown.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader != null){
                try{
                    reader.close();
                } catch (IOException e){
                    e.printStackTrace();
                }

            }
        }
        return indicator;
    }



    @Override
    public int size() {
        return extentions.size();
    }

    @Override
    public boolean isEmpty() {
        return extentions.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return extentions.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return extentions.containsValue(value);
    }

    @Override
    public Extention get(Object key) {
        return extentions.get(key);
    }

    @Override
    public Extention put(String key, Extention value) {
        return extentions.put(key, value);
    }

    @Override
    public Extention remove(Object key) {
        return extentions.remove(key);
    }

    @Override
    public void putAll(Map<? extends String, ? extends Extention> m) {

    }

    @Override
    public void clear() {
        extentions.clear();
    }

    @Override
    public Set<String> keySet() {
        return extentions.keySet();
    }

    @Override
    public Collection<Extention> values() {
        return extentions.values();
    }

    @Override
    public Set<Map.Entry<String, Extention>> entrySet() {
        return extentions.entrySet();
    }
}
