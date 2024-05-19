package se.iuh.demo.entites;

import java.util.Date;

public class TrangThai {
	private int maTrangThai;
    private int maThietBi;
    private String trangThai;
    private Date ngayCapNhat;


    public TrangThai() {}
    public TrangThai(int maThietBi, String trangThai, Date ngayCapNhat) {
        this.maThietBi = maThietBi;
        this.trangThai = trangThai;
        this.ngayCapNhat = ngayCapNhat;
    }

    // Getters and setters
    public int getMaTrangThai() {
        return maTrangThai;
    }
    public void setMaTrangThai(int maTrangThai) {
        this.maTrangThai = maTrangThai;
    }
    public int getMaThietBi() {
        return maThietBi;
    }
    public void setMaThietBi(int maThietBi) {
        this.maThietBi = maThietBi;
    }
    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    public Date getNgayCapNhat() {
        return ngayCapNhat;
    }
    public void setNgayCapNhat(Date ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }
    
}
