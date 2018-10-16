package dao;

import wherehows.models.table.User;
import wherehows.models.table.UserSetting;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User>
{
    public static String USER_ID_COLUMN = "id";
    public static String USER_FULL_NAME_COLUMN = "name";
    public static String USER_EMAIL_COLUMN = "email";
    public static String USER_NAME_COLUMN = "username";
    public static String USER_DEPARTMENT_NUMBER_COLUMN = "department_number";
    public static String USER_SETTING_DETAIL_DEFAULT_VIEW_COLUMN = "detail_default_view";
    public static String USER_SETTING_DEFAULT_WATCH_COLUMN = "default_watch";
    public static String CATEGORY_COLUMN = "category";

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        int id = rs.getInt(USER_ID_COLUMN);
        String name = rs.getString(USER_FULL_NAME_COLUMN);
        String email = rs.getString(USER_EMAIL_COLUMN);
        String username = rs.getString(USER_NAME_COLUMN);
        Integer departmentNum = rs.getInt(USER_DEPARTMENT_NUMBER_COLUMN);
        String defaultView = rs.getString(USER_SETTING_DETAIL_DEFAULT_VIEW_COLUMN);
        String defaultWatch = rs.getString(USER_SETTING_DEFAULT_WATCH_COLUMN);

        User user = new User();
        UserSetting userSetting = new UserSetting();
        userSetting.setDetailDefaultView(defaultView);
        userSetting.setDefaultWatch(defaultWatch);
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setUserName(username);
        user.setDepartmentNum(departmentNum);
        user.setUserSetting(userSetting);

        return user;
    }
}