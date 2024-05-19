package se.iuh.demo.entites;

public class KhachHang {
	    private int maKhachHang;
	    private String hoTen;
	    private String email;
	    private String soDienThoai;
	    private String diaChi;

	    // Constructors, getters, and setters
	    public KhachHang() {}
	    public KhachHang(String hoTen, String email, String soDienThoai, String diaChi) {
	        this.hoTen = hoTen;
	        this.email = email;
	        this.soDienThoai = soDienThoai;
	        this.diaChi = diaChi;
	    }
	    
	    
	    
	    public KhachHang(int maKhachHang) {
			super();
			this.maKhachHang = maKhachHang;
		}
	
		
		public KhachHang(int maKhachHang, String hoTen, String email, String soDienThoai, String diaChi) {
			super();
			this.maKhachHang = maKhachHang;
			this.hoTen = hoTen;
			this.email = email;
			this.soDienThoai = soDienThoai;
			this.diaChi = diaChi;
		}
		// Getters and setters
	    public int getMaKhachHang() {
	        return maKhachHang;
	    }
	    public void setMaKhachHang(int maKhachHang) {
	        this.maKhachHang = maKhachHang;
	    }
	    public String getHoTen() {
	        return hoTen;
	    }
	    public void setHoTen(String hoTen) {
	        this.hoTen = hoTen;
	    }
	    public String getEmail() {
	        return email;
	    }
	    public void setEmail(String email) {
	        this.email = email;
	    }
	    public String getSoDienThoai() {
	        return soDienThoai;
	    }
	    public void setSoDienThoai(String soDienThoai) {
	        this.soDienThoai = soDienThoai;
	    }
	    public String getDiaChi() {
	        return diaChi;
	    }
	    public void setDiaChi(String diaChi) {
	        this.diaChi = diaChi;
	    }
}
