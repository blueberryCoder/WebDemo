package com.blueberry.ssh.actions;

/**
 * Created by Administrator on 2016/11/1.
 */
public class JSONData {
    private String string1 ;
    private String[] stringArray = {"str1","str2","str3"};
    private int int1 = 10;
    private int[] intArray = {1,2,3,4,5,6,7};

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public String[] getStringArray() {
        return stringArray;
    }

    public void setStringArray(String[] stringArray) {
        this.stringArray = stringArray;
    }

    public int getInt1() {
        return int1;
    }

    public void setInt1(int int1) {
        this.int1 = int1;
    }

    public int[] getIntArray() {
        return intArray;
    }

    public void setIntArray(int[] intArray) {
        this.intArray = intArray;
    }
}
