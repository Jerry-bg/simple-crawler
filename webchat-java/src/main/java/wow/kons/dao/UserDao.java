package wow.kons.dao;

import wow.kons.bean.User;

public interface UserDao {
    User findUserById(int id);

    int registerCustom(User user);

    User loginCustom(String account,String pwd);
}
