package dao;

import wherehows.models.table.DatasetComment;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatasetCommentRowMapper implements RowMapper<DatasetComment>
{
    public static String ID_COLUMN = "id";
    public static String DATASET_ID_COLUMN = "dataset_id";
    public static String TEXT_COLUMN = "text";
    public static String CREATED_TIME_COLUMN = "created";
    public static String MODIFIED_TIME_COLUMN = "modified";
    public static String COMMENT_TYPE_COLUMN = "comment_type";
    public static String DEFAULT_COMMENT_TYPE = "Comment";
    public static String USER_FULL_NAME_COLUMN = "name";
    public static String USER_EMAIL_COLUMN = "email";
    public static String USER_NAME_COLUMN = "username";

    @Override
    public DatasetComment mapRow(ResultSet rs, int rowNum) throws SQLException {

        int id = rs.getInt(ID_COLUMN);
        int datasetId = rs.getInt(DATASET_ID_COLUMN);
        String text = rs.getString(TEXT_COLUMN);
        long created = rs.getTimestamp(CREATED_TIME_COLUMN).getTime();
        long modified = rs.getTimestamp(MODIFIED_TIME_COLUMN).getTime();
        String type = rs.getString(COMMENT_TYPE_COLUMN);
        if (StringUtils.isBlank(type)) {
            type = DEFAULT_COMMENT_TYPE;
        }
        String authorName = rs.getString(USER_FULL_NAME_COLUMN);
        String authorEmail = rs.getString(USER_EMAIL_COLUMN);
        String userName = rs.getString(USER_NAME_COLUMN);
        DatasetComment datasetComment = new DatasetComment();
        datasetComment.id = id;
        datasetComment.datasetId = datasetId;
        datasetComment.text = text;
        datasetComment.created = created;
        datasetComment.modified = modified;
        datasetComment.type = type;
        datasetComment.authorName = authorName;
        datasetComment.authorEmail = authorEmail;
        datasetComment.authorUserName = userName;

        return datasetComment;
    }
}