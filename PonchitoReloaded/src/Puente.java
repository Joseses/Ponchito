import java.sql.*;
import java.io.*;

public class Puente {

	Connection conn = null;
	Statement stmt = null;

    static final String CONN_URL = "jdbc:mysql://localhost/"; //Por defecto 127.0.0.1 o localhost
    static final String USER = "root"; //usuario de la base de datos
    static final String PASSWD = ""; //contraseña
    static final String DB_NAME = "metadata_search";      /* nombre de la base de datos */
    static final String PRE_STMT = "select * from document";

	public Puente(String pass) throws SQLException, Exception {

		// this will load the MySQL driver, each DB has its own driver
		Class.forName( "com.mysql.jdbc.Driver" );
		System.out.print( "Connecting to the database... " );

		// setup the connection with the DB
        conn = DriverManager.getConnection( CONN_URL + DB_NAME,
                USER, pass );
		System.out.println( "connected\n\n" );

		conn.setAutoCommit( false );
		stmt = conn.createStatement();
	}

	private void dumpResultSet( ResultSet rset ) throws SQLException {

		ResultSetMetaData rsetmd = rset.getMetaData();
		int i = rsetmd.getColumnCount();

		while( rset.next() ) {

			for( int j = 1; j <= i; j++ ) {
				System.out.print( rset.getString(j) + "\t" );
			}
			System.out.println();
		}
	}

	private void close() throws SQLException {

		stmt.close();
		conn.close();
	}

    public void commitChanges() throws SQLException {
        conn.commit();
    }

    public void cancelChanges() throws SQLException {
        conn.rollback();
    }

    public ResultSet getQueryResults(String statement) throws SQLException {
        return stmt.executeQuery( statement );
    }

    public void addModification(String statement) throws SQLException {
        stmt.executeUpdate(statement);
    }

	public static void main( String arg[] ) throws SQLException, Exception {

        String pass = "";
		for(int i = 0; i<arg.length;i++) {
			pass = pass + arg[i];
		}
		Puente transaction = new Puente(pass);

		transaction.close();
	}
}