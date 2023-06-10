package model;

public class CDDVD {
	private String ma,tieude,loaidia;
	private int nam;
	@Override
	public String toString() {
		return this.tieude;
	}
	public CDDVD() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CDDVD(String ma, String tieude, String loaidia, int nam) {
		super();
		this.ma = ma;
		this.tieude = tieude;
		this.loaidia = loaidia;
		this.nam = nam;
	}
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getTieude() {
		return tieude;
	}
	public void setTieude(String tieude) {
		this.tieude = tieude;
	}
	public String getLoaidia() {
		return loaidia;
	}
	public void setLoaidia(String loaidia) {
		this.loaidia = loaidia;
	}
	public int getNam() {
		return nam;
	}
	public void setNam(int nam) {
		this.nam = nam;
	}
}
