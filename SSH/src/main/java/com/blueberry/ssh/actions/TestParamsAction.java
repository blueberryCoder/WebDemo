package com.blueberry.ssh.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.config.entities.Parameterizable;

import java.util.Map;

/**
 * Created by Administrator on 2016/10/31.
 */
public class TestParamsAction extends ActionSupport implements Parameterizable{

    Map<String,String> params;

    String englishParam;
    String chineseParam;
    String franceParam;

    public String getEnglishParam() {
        return englishParam;
    }

    public void setEnglishParam(String englishParam) {
        this.englishParam = englishParam;
    }

    public String getChineseParam() {
        return chineseParam;
    }

    public void setChineseParam(String chineseParam) {
        this.chineseParam = chineseParam;
    }

    public String getFranceParam() {
        return franceParam;
    }

    public void setFranceParam(String franceParam) {
        this.franceParam = franceParam;
    }

    public void addParam(String s, String s1) {

        params.put(s,s1);
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public Map<String, String> getParams() {
        return params;
    }
}
