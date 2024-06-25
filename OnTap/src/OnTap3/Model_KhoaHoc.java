
package OnTap3;


public class Model_KhoaHoc {
    private int maKH;
    private double hocPhi;
    private int thoiLuong;
    private String ghiChu;

    public Model_KhoaHoc() {
    }

    public Model_KhoaHoc(int maKH, double hocPhi, int thoiLuong, String ghiChu) {
        this.maKH = maKH;
        this.hocPhi = hocPhi;
        this.thoiLuong = thoiLuong;
        this.ghiChu = ghiChu;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public double getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(double hocPhi) {
        this.hocPhi = hocPhi;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    public Object[] toDataRow() {
        return new Object[] {this.getMaKH(),this.getHocPhi(),this.getThoiLuong(),this.getGhiChu()};
    }
}
