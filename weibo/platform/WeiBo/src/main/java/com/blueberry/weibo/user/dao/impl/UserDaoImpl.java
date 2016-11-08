package com.blueberry.weibo.user.dao.impl;

import com.blueberry.weibo.user.bean.User;
import com.blueberry.weibo.user.dao.UserDao;
import com.blueberry.weibo.user.exceptions.LoginException;
import com.blueberry.weibo.user.exceptions.RegisterException;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.ImportResource;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Administrator on 2016/11/2.
 */

@Transactional
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    public boolean register(User user) throws RegisterException {
        try {
            if(isExist(user)){
                throw new RegisterException(RegisterException.USER_EXIST,"用户已经存在");
            }
            getHibernateTemplate().save(user);
            return  true;
        } catch (DataAccessException e) {
            throw new RegisterException(RegisterException.OTHER,"数据库访问异常",e);
        }
    }

    public boolean login(User user) throws LoginException {
        try {
            if(isExist(user)){
                List<User> users = (List<User>) getHibernateTemplate()
                        .find("from User u where u.account=?", user.getAccount());
                if(users!=null && users.size()!=0){
                    if(  user.getPassword().equals(users.get(0).getPassword())){
                        return true;
                    }else{
                        throw new LoginException(LoginException.PASSWORD_ERROR,"密码错误");
                    }
                }
            }else{
                throw new LoginException(LoginException.USER_NOT_EXIST,"用户不存在");
            }
        }catch (DataAccessException e){
            throw new LoginException(LoginException.OTHER,"数据库访问失败",e);
        }
        return false;
    }

    private boolean isExist(User user) {
        List<?> objects = getHibernateTemplate().find("from User u where  u.account=?", user.getAccount());
        return objects != null && objects.size() != 0;
    }

}
