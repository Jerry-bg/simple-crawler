package wow.kons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import wow.kons.bean.User;
import wow.kons.dao.UserDao;

@Service
public class TestService {

    @Autowired
    private UserDao userDao;

    public User obtainUser(int id){
        return userDao.findUserById(id);
    }

    public User login(String account,String pwd){
        return userDao.loginCustom(account,pwd);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackForClassName = "TestService")
    public int register(User user){
        boolean isExit=userDao.loginCustom(user.getP_account(),null).getP_account().isEmpty();
        if(isExit)
            return userDao.registerCustom(user);
        else
            return -1;
    }
}
