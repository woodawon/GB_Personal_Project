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
	
	public ArrayList<itVO> get_itDB() {
		ArrayList<itVO> list = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from itDB";
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				itVO vo = new itVO();
				vo.setQuestion(rs.getString("question"));
				vo.setAnswer(rs.getString("answer"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public ArrayList<psVO> get_psDB() {
		ArrayList<psVO> list = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from psDB";
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				psVO vo = new psVO();
				vo.setQuestion(rs.getString("question"));
				vo.setAnswer(rs.getInt("answer"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
}
