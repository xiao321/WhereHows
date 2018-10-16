package dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class AbstractMySQLDAO
{
    private static JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSource.getDataSource("wherehows_mysql"));
    private static NamedParameterJdbcTemplate nPJdbcTemplate =
      new NamedParameterJdbcTemplate(DataSource.getDataSource("wherehows_mysql"));

    protected static JdbcTemplate getJdbcTemplate()
    {
        return jdbcTemplate;
    }

    protected static NamedParameterJdbcTemplate getNamedParameterJdbcTemplate()
    {
        return nPJdbcTemplate;
    }
}
