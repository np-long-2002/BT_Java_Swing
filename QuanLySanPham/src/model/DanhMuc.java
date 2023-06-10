package model;

public class DanhMuc {
	private String maDM;
	private String tenDM;
	private int isDelete;
	public DanhMuc(String maDM, String tenDM, int isDelete) {
		super();
		this.maDM = maDM;
		this.tenDM = tenDM;
		this.isDelete = isDelete;
	}
	public String getMaDM() {
		return maDM;
	}
	public void setMaDM(String maDM) {
		this.maDM = maDM;
	}
	public String getTenDM() {
		return tenDM;
	}
	public void setTenDM(String tenDM) {
		this.tenDM = tenDM;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public DanhMuc() {
		super();
	}
	 @Override
	    public String toString() {
	        return this.tenDM;
	        
	    }
}
