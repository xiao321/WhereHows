package dao;
import org.apache.commons.lang3.StringUtils;
import play.Play;

public class MySQLDataSource extends DataSource
{
    public static String DatabaseType = "mysql";
    public static String MYSQL_DRIVER_CLASS = "com.mysql.jdbc.Driver";
    public static String DATABASE_WHEREHOWS_OPENSOURCE = "wherehows_opensource_mysql";
    public static String DATABASE_WHEREHOWS_OPENSOURCE_USER_NAME_KEY = "database.opensource.username";
    public static String DATABASE_WHEREHOWS_OPENSOURCE_USER_PASSWORD_KEY = "database.opensource.password";
    public static String DATABASE_WHEREHOWS_OPENSOURCE_URL_KEY = "database.opensource.url";
    public static String DATABASE_WHEREHOWS_DB = "wherehows_mysql";
    public static String DATABASE_WHEREHOWS_DB_USER_NAME_KEY = "database.wherehows.username";
    public static String DATABASE_WHEREHOWS_DB_USER_PASSWORD_KEY = "database.wherehows.password";
    public static String DATABASE_WHEREHOWS_DB_URL_KEY = "database.wherehows.url";

  @Override
  public String getType()
  {
    return DatabaseType;
  }

  public MySQLDataSource(String identifier)
  {
      setDriverClass(MYSQL_DRIVER_CLASS);
      if (StringUtils.isNotBlank(identifier) && identifier.equalsIgnoreCase(DATABASE_WHEREHOWS_OPENSOURCE))
	  {
          setUsername(Play.application().configuration().getString(DATABASE_WHEREHOWS_OPENSOURCE_USER_NAME_KEY));
          setPassword(Play.application().configuration().getString(DATABASE_WHEREHOWS_OPENSOURCE_USER_PASSWORD_KEY));
          setJdbcUrl(Play.application().configuration().getString(DATABASE_WHEREHOWS_OPENSOURCE_URL_KEY));
	  }
      else if (StringUtils.isNotBlank(identifier) && identifier.equalsIgnoreCase(DATABASE_WHEREHOWS_DB))
      {
          setUsername(Play.application().configuration().getString(DATABASE_WHEREHOWS_DB_USER_NAME_KEY));
          setPassword(Play.application().configuration().getString(DATABASE_WHEREHOWS_DB_USER_PASSWORD_KEY));
          setJdbcUrl(Play.application().configuration().getString(DATABASE_WHEREHOWS_DB_URL_KEY));
      }

	  setIdleConnectionTestPeriodInMinutes(1);
	  setIdleMaxAgeInMinutes(1);
	  setMaxConnectionsPerPartition(10);
	  setMinConnectionsPerPartition(5);
	  setPartitionCount(3);
	  setAcquireIncrement(5);
	  setStatementsCacheSize(100);
  }
}
