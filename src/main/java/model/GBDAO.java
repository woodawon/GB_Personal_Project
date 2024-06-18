package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GBDAO {
	private GBDAO() {

	}

	private static GBDAO instance = new GBDAO();

	public static GBDAO getInstance() throws SQLException {
		return instance;
	}

	public Connection getConnection() throws IOException, SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "admin";
		String pw = "1234";
		Connection con = DriverManager.getConnection(url, id, pw);
		return con;
	}

	public int set_itDB(String answer) {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			String sql = "insert into itDB values (default, ?)";
			con = getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, answer);
			rs = psmt.executeQuery();
			if (rs != null) {
				result = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (psmt != null) {
					psmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int reset_DB() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			String sql = "delete from itDB";
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs != null) {
				result = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
