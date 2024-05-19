package se.iuh.demo.entites;

public class ThietBi {
	private int maThietBi;

    private String loaiThietBi;
    private String hangSanXuat;
    private String mauThietBi;
    private String soSeri;
    private KhachHang khachHang ;

    // Constructors, getters, and setters
    public ThietBi() {}

    
    public ThietBi(int maThietBi, String loaiThietBi, String hangSanXuat, String mauThietBi, String soSeri) {
		super();
		this.maThietBi = maThietBi;
		this.loaiThietBi = loaiThietBi;
		this.hangSanXuat = hangSanXuat;
		this.mauThietBi = mauThietBi;
		this.soSeri = soSeri;
	}
    
	public ThietBi(int maThietBi, String loaiThietBi, String hangSanXuat, String mauThietBi, String soSeri,
			KhachHang khachHang) {
		super();
		this.maThietBi = maThietBi;
		this.loaiThietBi = loaiThietBi;
		this.hangSanXuat = hangSanXuat;
		this.mauThietBi = mauThietBi;
		this.soSeri = soSeri;
		this.khachHang = khachHang;
	}


	// Getters and setters
    public int getMaThietBi() {
        return maThietBi;
    }
    public void setMaThietBi(int maThietBi) {
        this.maThietBi = maThietBi;
    }
    
    public String getLoaiThietBi() {
        return loaiThietBi;
    }
    public void setLoaiThietBi(String loaiThietBi) {
        this.loaiThietBi = loaiThietBi;
    }
    public String getHangSanXuat() {
        return hangSanXuat;
    }
    public void setHangSanXuat(String hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }
    public String getMauThietBi() {
        return mauThietBi;
    }
    public void setMauThietBi(String mauThietBi) {
        this.mauThietBi = mauThietBi;
    }
    public String getSoSeri() {
        return soSeri;
    }
    public void setSoSeri(String soSeri) {
        this.soSeri = soSeri;
    }
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	
    
}
