package com.blueberry.weibo.user.actions;

import com.blueberry.weibo.user.bean.User;
import com.blueberry.weibo.user.bo.UserBo;
import com.blueberry.weibo.user.exceptions.LoginException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by Administrator on 2016/11/1.
 */
public class LoginAction extends ActionSupport implements ModelDriven<User> {

    private User user = new User();

    private UserBo userBo;

    public UserBo getUserBo() {
        return userBo;
    }

    public void setUserBo(UserBo userBo) {
        this.userBo = userBo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String execute() throws Exception {

        try {
            if(userBo.login(user)){
                return SUCCESS;
            }
        }catch (LoginException e){
            addActionError(e.getMessage());
        }
        return INPUT;
    }

    public User getModel() {
        return user;
    }
}
