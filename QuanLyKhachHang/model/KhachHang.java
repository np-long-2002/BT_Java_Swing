package model;

public class KhachHang {
	private String maKH;
	private String tenKH;
	private int namSinh;
	private String maNhom;
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return this.tenKH;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public int getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}
	public String getMaNhom() {
		return maNhom;
	}
	public void setMaNhom(String maNhom) {
		this.maNhom = maNhom;
	}
}
