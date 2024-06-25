package OnTap2;

import java.sql.*;
import java.util.ArrayList;

public class Repository_NhanVien {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public ArrayList<Model_NhanVien> getAll() {
        sql = "select MaNV,HoTen,MatKhau,VaiTro from NhanVien";
        ArrayList<Model_NhanVien> list_NhanVien = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String maNV;
                String hoTen;
                String matKhau;
                boolean vaiTro;
                maNV = rs.getString(1);
                hoTen = rs.getString(2);
                matKhau = rs.getString(3);
                vaiTro = rs.getBoolean(4);
                Model_NhanVien model_NhanVien = new Model_NhanVien(maNV, hoTen, matKhau, vaiTro);
                list_NhanVien.add(model_NhanVien);
            }
            return list_NhanVien;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //thêm
    public int them(Model_NhanVien m) {
        sql = "insert into NhanVien(MaNV,HoTen,MatKhau,VaiTro) values (?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, m.getMaNV());
            ps.setObject(2, m.getHoTen());
            ps.setObject(3, m.getMatKhau());
            ps.setObject(4, m.isVaiTro());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    //check Trùng
    public boolean checkTrung(String maMoi) {
        sql = "select MaNV,HoTen,MatKhau,VaiTro from NhanVien where MaNV = ?";
        Model_NhanVien model_NhanVien = null;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maMoi);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //remove
    public int xoa(String ma) {
        sql = "delete from NhanVien where MaNV = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    //update 
    public int update(String ma, Model_NhanVien m) {
        sql = "update NhanVien set HoTen = ?, MatKhau = ?, VaiTro = ?\n"
                + "where MaNV = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, m.getHoTen());
            ps.setObject(2, m.getMatKhau());
            ps.setObject(3, m.isVaiTro());
            ps.setObject(4, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    
    
}
