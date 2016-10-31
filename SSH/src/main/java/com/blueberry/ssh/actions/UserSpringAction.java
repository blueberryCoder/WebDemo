package com.blueberry.ssh.actions;

import com.blueberry.ssh.bo.UserBo;

/**
 * Created by Administrator on 2016/10/27.
 */
public class UserSpringAction {

    private UserBo userBo;

    public UserBo getUserBo() {
        return userBo;
    }

    public void setUserBo(UserBo userBo) {
        this.userBo = userBo;
    }

    public String execute() throws Exception {
        userBo.printUser();
        return "success";
    }
}
