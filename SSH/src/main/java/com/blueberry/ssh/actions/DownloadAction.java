package com.blueberry.ssh.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/10/31.
 */
public class DownloadAction extends ActionSupport {

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public InputStream getDownloadFile()  {
        return ServletActionContext.getServletContext().getResourceAsStream(path);
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
