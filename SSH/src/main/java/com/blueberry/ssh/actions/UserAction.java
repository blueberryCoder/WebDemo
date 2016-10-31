package com.blueberry.ssh.actions;

import com.blueberry.ssh.bo.UserBo;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Created by Administrator on 2016/10/27.
 */
public class UserAction extends ActionSupport {
    @Override
    public String execute() throws Exception {

        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(
                ServletActionContext.getServletContext()
        );
        UserBo userBo= (UserBo) context.getBean("userBo");
        userBo.printUser();
        return SUCCESS;
    }
}
