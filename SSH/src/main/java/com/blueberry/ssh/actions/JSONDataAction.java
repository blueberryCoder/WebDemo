package com.blueberry.ssh.actions;

import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/1.
 */
public class JSONDataAction extends ActionSupport {
    private String string1;
    private String[] stringsArray2 = {"A1","A2"};
    private int number1 =10;
    private int[] numberArray1 = {1,2,3,4,5};
    private List<String> lists = new ArrayList<String>(){
        {
            add("list1");
            add("list2");
            add("list3");
            add("list4");
        }
    };

    private Map<String,String> map = new HashMap<String,String>(){
        {
            put("key1","value1");
            put("key2","value2");
            put("key3","value3");
        }
    };

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public String[] getStringsArray2() {
        return stringsArray2;
    }

    public void setStringsArray2(String[] stringsArray2) {
        this.stringsArray2 = stringsArray2;
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int[] getNumberArray1() {
        return numberArray1;
    }

    public void setNumberArray1(int[] numberArray1) {
        this.numberArray1 = numberArray1;
    }

    public List<String> getLists() {
        return lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
