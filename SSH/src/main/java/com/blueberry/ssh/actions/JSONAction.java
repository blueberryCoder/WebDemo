package com.blueberry.ssh.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Created by Administrator on 2016/11/1.
 */
public class JSONAction extends ActionSupport implements ModelDriven<JSONData> {
    private JSONData jsonData = new JSONData();
    public JSONData getModel() {
        return jsonData;
    }


}
