package dao;
//123465
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;


public class DBCPTest {

	public static void main(String[] args) throws SQLException {
		Connection conn = DBCPUtil.getConnection();
		DatabaseMetaData metaData = conn.getMetaData();
		System.out.format("URL=%s%nusername=%s%nDriverName=%s%n",
				metaData.getURL(),metaData.getUserName(),metaData.getDriverName());
	}

}
