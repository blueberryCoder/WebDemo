package com.blueberry.weibo.user.actions;

import com.blueberry.weibo.common.Extendable;
import com.blueberry.weibo.common.SecretHolder;
import com.blueberry.weibo.user.bean.User;
import com.blueberry.weibo.user.bo.UserBo;
import com.blueberry.weibo.user.exceptions.RegisterException;
import com.blueberry.weibo.utils.Base64Utils;
import com.blueberry.weibo.utils.RSAUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.io.Charsets;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2016/11/1.
 */
public class RegisterAction extends ActionSupport implements ModelDriven<User> {

    private Logger logger = Logger.getLogger(RegisterAction.class);

    private User user = new User();

    private UserBo userBo;

    public UserBo getUserBo() {
        return userBo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUserBo(UserBo userBo) {
        this.userBo = userBo;
    }

    @Override
    public String execute() throws Exception {
        if (StringUtils.isEmpty(user.getAccount())) {
            return INPUT;
        }

        if (StringUtils.isEmpty(user.getName())) {
            user.setName(user.getAccount());
        }

        // 这里要用base64将密码解密，因为 js中使用了base64加密
        String decrypted = new String(RSAUtils.decryptByPrivateKey(
                Base64Utils.decode(user.getPassword())
                ,
                SecretHolder.getPrivateKey()));
        user.setPassword(decrypted);
        ((Extendable)userBo).extend();
        try {
            userBo.register(user);
            return SUCCESS;
        } catch (RegisterException e) {
            addActionError(e.getMessage());
            logger.error(e);
        }

        return INPUT;
    }


    public User getModel() {
        return user;
    }
}
