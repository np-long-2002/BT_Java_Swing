package model;

public class SanPham {
	private String maSP;
	private String tenSP;
	private int soLuong;
	private int donGia;
	private String maDM;
	private int isDelete;
	public SanPham(String maSP, String tenSP, int soLuong, int donGia, String maDM, int isDelete) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.maDM = maDM;
		this.isDelete = isDelete;
	}
	public String getMaSP() {
		return maSP;
	}
	public SanPham() {
		super();
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getDonGia() {
		return donGia;
	}
	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}
	public String getMaDM() {
		return maDM;
	}
	public void setMaDM(String maDM) {
		this.maDM = maDM;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	@Override
	public String toString() {
		return this.tenSP;
	}
}
