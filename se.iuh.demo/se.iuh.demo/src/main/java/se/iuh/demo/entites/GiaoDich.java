package se.iuh.demo.entites;

import java.util.Date;

public class GiaoDich {
	private int maGiaoDich;
    private int maThietBi;
    private int maKhachHang;
    private String trangThai;
    private Date ngayGiaoDich;

    // Constructors, getters, and setters
    public GiaoDich() {}
    public GiaoDich(int maThietBi, int maKhachHang, String trangThai, Date ngayGiaoDich) {
        this.maThietBi = maThietBi;
        this.maKhachHang = maKhachHang;
        this.trangThai = trangThai;
        this.ngayGiaoDich = ngayGiaoDich;
    }

    // Getters and setters
    public int getMaGiaoDich() {
        return maGiaoDich;
    }
    public void setMaGiaoDich(int maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }
    public int getMaThietBi() {
        return maThietBi;
    }
    public void setMaThietBi(int maThietBi) {
        this.maThietBi = maThietBi;
    }
    public int getMaKhachHang() {
        return maKhachHang;
    }
    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }
    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    public Date getNgayGiaoDich() {
        return ngayGiaoDich;
    }
    public void setNgayGiaoDich(Date ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }
}
