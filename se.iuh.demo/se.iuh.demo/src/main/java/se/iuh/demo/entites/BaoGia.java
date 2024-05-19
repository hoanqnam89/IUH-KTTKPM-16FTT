package se.iuh.demo.entites;

import java.util.Date;

public class BaoGia {
	 private int maBaoGia;
	    private int maThietBi;
	    private double soTienBaoGia;
	    private Date ngayBaoGia;
	    private Date ngayHetHan;

	    // Constructors, getters, and setters
	    public BaoGia() {}
	    public BaoGia(int maThietBi, double soTienBaoGia, Date ngayBaoGia, Date ngayHetHan) {
	        this.maThietBi = maThietBi;
	        this.soTienBaoGia = soTienBaoGia;
	        this.ngayBaoGia = ngayBaoGia;
	        this.ngayHetHan = ngayHetHan;
	    }

	    // Getters and setters
	    public int getMaBaoGia() {
	        return maBaoGia;
	    }
	    public void setMaBaoGia(int maBaoGia) {
	        this.maBaoGia = maBaoGia;
	    }
	    public int getMaThietBi() {
	        return maThietBi;
	    }
	    public void setMaThietBi(int maThietBi) {
	        this.maThietBi = maThietBi;
	    }
	    public double getSoTienBaoGia() {
	        return soTienBaoGia;
	    }
	    public void setSoTienBaoGia(double soTienBaoGia) {
	        this.soTienBaoGia = soTienBaoGia;
	    }
	    public Date getNgayBaoGia() {
	        return ngayBaoGia;
	    }
	    public void setNgayBaoGia(Date ngayBaoGia) {
	        this.ngayBaoGia = ngayBaoGia;
	    }
	    public Date getNgayHetHan() {
	        return ngayHetHan;
	    }
	    public void setNgayHetHan(Date ngayHetHan) {
	        this.ngayHetHan = ngayHetHan;
	    }
}
