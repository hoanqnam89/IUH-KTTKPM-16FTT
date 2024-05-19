package se.iuh.demo.entites;

import java.util.Date;

public class DanhGia {
	 private int maDanhGia;
	    private int maThietBi;
	    private String tinhTrang;
	    private Date ngayDanhGia;
	    private String ghiChu;

	    // Constructors, getters, and setters
	    public DanhGia() {}
	    public DanhGia(int maThietBi, String tinhTrang, Date ngayDanhGia, String ghiChu) {
	        this.maThietBi = maThietBi;
	        this.tinhTrang = tinhTrang;
	        this.ngayDanhGia = ngayDanhGia;
	        this.ghiChu = ghiChu;
	    }

	    // Getters and setters
	    public int getMaDanhGia() {
	        return maDanhGia;
	    }
	    public void setMaDanhGia(int maDanhGia) {
	        this.maDanhGia = maDanhGia;
	    }
	    public int getMaThietBi() {
	        return maThietBi;
	    }
	    public void setMaThietBi(int maThietBi) {
	        this.maThietBi = maThietBi;
	    }
	    public String getTinhTrang() {
	        return tinhTrang;
	    }
	    public void setTinhTrang(String tinhTrang) {
	        this.tinhTrang = tinhTrang;
	    }
	    public Date getNgayDanhGia() {
	        return ngayDanhGia;
	    }
	    public void setNgayDanhGia(Date ngayDanhGia) {
	        this.ngayDanhGia = ngayDanhGia;
	    }
	    public String getGhiChu() {
	        return ghiChu;
	    }
	    public void setGhiChu(String ghiChu) {
	        this.ghiChu = ghiChu;
	    }
}
