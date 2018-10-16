package dao;

import wherehows.models.table.Project;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectRowMapper implements RowMapper<Project>
{
    public static String APP_ID_COLUMN = "app_id";
    public static String APP_CODE_COLUMN = "app_code";
    public static String PROJECT_NAME_COLUMN = "project_name";
    public static String FLOW_GROUP_COLUMN = "flow_group";

    @Override
    public Project mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        String name = rs.getString(PROJECT_NAME_COLUMN);
        String flowGroup = rs.getString(FLOW_GROUP_COLUMN);
        Integer appID = rs.getInt(APP_ID_COLUMN);
        String appCode = rs.getString(APP_CODE_COLUMN);
        Project project = new Project();
        project.appId = appID;
        project.appCode = appCode;
        project.name = name;
        project.flowGroup = flowGroup;
        return project;
    }
}
