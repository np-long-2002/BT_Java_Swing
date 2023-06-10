package model;

public class PhieuNhapSach {
	private int id;
	private String ghiChu;
	private String ngay;
	private String nhanVien;
	public PhieuNhapSach() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PhieuNhapSach(int id, String ghiChu, String ngay, String nhanVien) {
		super();
		this.id = id;
		this.ghiChu = ghiChu;
		this.ngay = ngay;
		this.nhanVien = nhanVien;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public String getNgay() {
		return ngay;
	}
	public void setNgay(String ngay) {
		this.ngay = ngay;
	}
	public String getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(String nhanVien) {
		this.nhanVien = nhanVien;
	}
}
