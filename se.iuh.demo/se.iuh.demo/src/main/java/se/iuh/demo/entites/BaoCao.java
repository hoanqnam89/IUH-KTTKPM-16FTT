package se.iuh.demo.entites;

import java.util.Date;

public class BaoCao {
	 private int maBaoCao;
	    private String loaiBaoCao;
	    private Date ngayTao;
	    private String duLieuBaoCao;

	    // Constructors, getters, and setters
	    public BaoCao() {}
	    public BaoCao(String loaiBaoCao, Date ngayTao, String duLieuBaoCao) {
	        this.loaiBaoCao = loaiBaoCao;
	        this.ngayTao = ngayTao;
	        this.duLieuBaoCao = duLieuBaoCao;
	    }

	    // Getters and setters
	    public int getMaBaoCao() {
	        return maBaoCao;
	    }
	    public void setMaBaoCao(int maBaoCao) {
	        this.maBaoCao = maBaoCao;
	    }
	    public String getLoaiBaoCao() {
	        return loaiBaoCao;
	    }
	    public void setLoaiBaoCao(String loaiBaoCao) {
	        this.loaiBaoCao = loaiBaoCao;
	    }
	    public Date getNgayTao() {
	        return ngayTao;
	    }
	    public void setNgayTao(Date ngayTao) {
	        this.ngayTao = ngayTao;
	    }
	    public String getDuLieuBaoCao() {
	        return duLieuBaoCao;
	    }
	    public void setDuLieuBaoCao(String duLieuBaoCao) {
	        this.duLieuBaoCao = duLieuBaoCao;
	    }
}
