package dao;

import com.jolbox.bonecp.BoneCPDataSource;

public abstract class DataSource extends BoneCPDataSource
{
    public abstract String getType();

    public DataSource()
    {
        super();
    }

    public static DataSource getDataSource(String identifier)
    {
        return new MySQLDataSource(identifier);
    }
}
