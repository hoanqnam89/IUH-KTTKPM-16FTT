package se.iuh.demo.entites;

import java.util.Date;

public class TaiChe {
	 private int maTaiChe;
	    private int maThietBi;
	    private String hanhDong;
	    private Date ngayHanhDong;
	    private String ghiChu;

	    // Constructors, getters, and setters
	    public TaiChe() {}
	    public TaiChe(int maThietBi, String hanhDong, Date ngayHanhDong, String ghiChu) {
	        this.maThietBi = maThietBi;
	        this.hanhDong = hanhDong;
	        this.ngayHanhDong = ngayHanhDong;
	        this.ghiChu = ghiChu;
	    }

	    // Getters and setters
	    public int getMaTaiChe() {
	        return maTaiChe;
	    }
	    public void setMaTaiChe(int maTaiChe) {
	        this.maTaiChe = maTaiChe;
	    }
	    public int getMaThietBi() {
	        return maThietBi;
	    }
	    public void setMaThietBi(int maThietBi) {
	        this.maThietBi = maThietBi;
	    }
	    public String getHanhDong() {
	        return hanhDong;
	    }
	    public void setHanhDong(String hanhDong) {
	        this.hanhDong = hanhDong;
	    }
	    public Date getNgayHanhDong() {
	        return ngayHanhDong;
	    }
	    public void setNgayHanhDong(Date ngayHanhDong) {
	        this.ngayHanhDong = ngayHanhDong;
	    }
	    public String getGhiChu() {
	        return ghiChu;
	    }
	    public void setGhiChu(String ghiChu) {
	        this.ghiChu = ghiChu;
	    }
}
