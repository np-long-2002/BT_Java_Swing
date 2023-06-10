package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import model.LoaiSach;

public class LoaiSachDAO extends KetNoiDatabase{
	public ArrayList<LoaiSach> docLS(){
		ArrayList<LoaiSach> arrayList = new ArrayList<LoaiSach>();
		try {
			String sql = "select * from LoaiSach";
			Statement statement = conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()) {
				LoaiSach sach = new LoaiSach();
				sach.setId(set.getInt(1));
				sach.setTen(set.getString(2));
				sach.setMoTa(set.getString(3));
				arrayList.add(sach);
			}
			conn.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return arrayList;
	}
	public int luuSP(LoaiSach loaiSach) {
		try {
			String sql = "insert into LoaiSach values(?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, loaiSach.getId());
			preparedStatement.setString(2,loaiSach.getTen());
			preparedStatement.setString(3, loaiSach.getMoTa());
			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	public boolean xoaSP(String ma) {
		try {
			String sql ="delete from LoaiSach where LS_ID =?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, ma);
			return preparedStatement.executeUpdate() >0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public int capnhapSP(LoaiSach sach) {
		try {
			String sql = "update LoaiSach set Ten = ? , MoTa = ? where LS_ID = ? ";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, sach.getTen());
			preparedStatement.setString(2, sach.getMoTa());
			preparedStatement.setInt(3,sach.getId());
			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
}
