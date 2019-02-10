package com.wierzbicki;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;



public class Extentions implements Map<String, Extention>{

    // Map for containing extention shortcut and corresponding object of Extention class
    private  static Map<String, Extention> extentions = new HashMap<String, Extention>();








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
