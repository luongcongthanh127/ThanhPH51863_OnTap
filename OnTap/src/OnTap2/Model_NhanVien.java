package OnTap2;

public class Model_NhanVien {

    private String maNV;
    private String hoTen;
    private String matKhau;
    private boolean vaiTro;

    public Model_NhanVien() {
    }

    public Model_NhanVien(String maNV, String hoTen, String matKhau, boolean vaiTro) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public boolean isVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(boolean vaiTro) {
        this.vaiTro = vaiTro;
    }

    public Object[] toDataRow() {
        return new Object[]{this.getMaNV(), this.getHoTen(), this.getMatKhau(), this.isVaiTro() ? "Quản lý" : "Nhân viên"};
    }
}
