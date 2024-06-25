
package OnTap1;


public class Model_NguoiHoc {
    private String maNH;
    private String hoTen;
    private String ngaySinh;
    private String dienThoai;

    public Model_NguoiHoc() {
    }

    public Model_NguoiHoc(String maNH, String hoTen, String ngaySinh, String dienThoai) {
        this.maNH = maNH;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.dienThoai = dienThoai;
    }

    public String getMaNH() {
        return maNH;
    }

    public void setMaNH(String maNH) {
        this.maNH = maNH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }
    
    public Object[] toDataRow() {
        return new Object[] {this.getMaNH(),this.getHoTen(),this.getNgaySinh(),this.getDienThoai()};
    }
}
