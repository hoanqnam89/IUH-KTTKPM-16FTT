package se.iuh.demo.entites;

import java.util.Date;

public class KeToan {
	private int maKeToan;
    private int maThietBi;
    private double soTienThanhToan;
    private Date ngayThanhToan;
    private String phuongThucThanhToan;

    // Constructors, getters, and setters
    public KeToan() {}
    public KeToan(int maThietBi, double soTienThanhToan, Date ngayThanhToan, String phuongThucThanhToan) {
        this.maThietBi = maThietBi;
        this.soTienThanhToan = soTienThanhToan;
        this.ngayThanhToan = ngayThanhToan;
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    // Getters and setters
    public int getMaKeToan() {
        return maKeToan;
    }
    public void setMaKeToan(int maKeToan) {
        this.maKeToan = maKeToan;
    }
    public int getMaThietBi() {
        return maThietBi;
    }
    public void setMaThietBi(int maThietBi) {
        this.maThietBi = maThietBi;
    }
    public double getSoTienThanhToan() {
        return soTienThanhToan;
    }
    public void setSoTienThanhToan(double soTienThanhToan) {
        this.soTienThanhToan = soTienThanhToan;
    }
    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }
    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }
    public String getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }
    public void setPhuongThucThanhToan(String phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }
}
