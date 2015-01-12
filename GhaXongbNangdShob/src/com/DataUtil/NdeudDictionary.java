package com.DataUtil;

import com.Model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class NdeudDictionary {
	private ArrayList<NdeudLeb> ndeulist;

	public NdeudDictionary() {

	}

	public ArrayList<NdeudLeb> queryByNdeudx(String ndeudx) {

		ArrayList<NdeudLeb> list = new ArrayList<NdeudLeb>();

		SingleConnection instance = SingleConnection.getSingleInstance();
		try {
			Connection conn = instance.getConn();
			Statement stm = conn.createStatement();
			String sqlstd = "Select * from stdndeud where ndeudx like\'"
					+ ndeudx + "%\'";
			// String
			// sqldlt="Select * from dialect where ndeudx like\'"+ndeudx+"%\'";
			ResultSet rs = stm.executeQuery(sqlstd);
			while (rs.next()) {
				NdeudLeb leb = new NdeudLeb();
				leb.setNdeudx(rs.getString("ndeudx"));
				leb.setNdeudz(rs.getString("ndeudz"));
                leb.setEnglish(rs.getString("english"));
                leb.setGhade(rs.getString("ghade"));
                leb.setStdNdeud(rs.getString("stdndeud"));
                	
				list.add(leb);
			}
			instance.Close(conn, stm, rs);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(list.size() + "  numberx");
		return list;

	}

	public ResultSet queryByNdeudxd(String ndeudxd) {
		SingleConnection instance = SingleConnection.getSingleInstance();
		ResultSet rs = null;
		try {
			Connection conn = instance.getConn();
			Statement stm = conn.createStatement();
			String sql = "Select * from stdlib where ndeudx like\'" + ndeudxd
					+ "%\'";
			rs = stm.executeQuery(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public static void main(String[] args) {

		NdeudDictionary ndd = new NdeudDictionary();
		ndd.queryByNdeudx("b");
	}
}
