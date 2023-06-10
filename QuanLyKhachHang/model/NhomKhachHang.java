package model;

public class NhomKhachHang {
	private String maNhom;
	
	public String getMaNhom() {
		return maNhom;
	}

	public void setMaNhom(String maNhom) {
		this.maNhom = maNhom;
	}

	public String getTenNhom() {
		return tenNhom;
	}

	public void setTenNhom(String tenNhom) {
		this.tenNhom = tenNhom;
	}

	public NhomKhachHang(String maNhom, String tenNhom) {
		super();
		this.maNhom = maNhom;
		this.tenNhom = tenNhom;
	}

	private String tenNhom;

	@Override
	public String toString() {
		return this.tenNhom;
	}

	public NhomKhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
}

