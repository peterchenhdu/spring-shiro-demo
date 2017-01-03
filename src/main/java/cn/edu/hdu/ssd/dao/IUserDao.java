package cn.edu.hdu.ssd.dao;

import java.util.List;
import java.util.Map;

import cn.edu.hdu.ssd.model.User;

/**
 * @author Pi Chen
 * @version ssd V1.0.0, 2016年8月12日
 * @see
 * @since ssd V1.0.0
 */

public interface IUserDao
{
    public List<User> query(Map<String, Object> param);

    public int saveUser(Map<String, Object> param);

    public void deleteUser(Map<String, Object> param);

    public int updateUser(User user);
}
