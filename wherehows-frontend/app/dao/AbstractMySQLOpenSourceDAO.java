package dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


public class AbstractMySQLOpenSourceDAO {
  private static String MYSQL_DB_WHEREHOWS_OPENSOURCE = "wherehows_opensource_mysql";

  private static JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSource.getDataSource(MYSQL_DB_WHEREHOWS_OPENSOURCE));

  private static NamedParameterJdbcTemplate namedJdbcTemplate =
      new NamedParameterJdbcTemplate(DataSource.getDataSource(MYSQL_DB_WHEREHOWS_OPENSOURCE));

  public static JdbcTemplate getJdbcTemplate() {
    return jdbcTemplate;
  }

  public static NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
    return namedJdbcTemplate;
  }
}
