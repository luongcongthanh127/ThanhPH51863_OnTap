package OnTap1;

import java.sql.*;
import java.util.ArrayList;

public class Repository_NguoiHoc {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public ArrayList<Model_NguoiHoc> getAll() {
        sql = "select MaNH,HoTen,NgaySinh,DienThoai from NguoiHoc";
        ArrayList<Model_NguoiHoc> list_NguoiHoc = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String maNH;
                String hoTen;
                String ngaySinh;
                String dienThoai;
                maNH = rs.getString(1);
                hoTen = rs.getString(2);
                ngaySinh = rs.getString(3);
                dienThoai = rs.getString(4);
                Model_NguoiHoc model_NguoiHoc = new Model_NguoiHoc(maNH, hoTen, ngaySinh, dienThoai);
                list_NguoiHoc.add(model_NguoiHoc);
            }
            return list_NguoiHoc;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //thêm
    public int them(Model_NguoiHoc m) {
        sql = "insert into NguoiHoc(MaNH,HoTen,NgaySinh,DienThoai) values (?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, m.getMaNH());
            ps.setObject(2, m.getHoTen());
            ps.setObject(3, m.getNgaySinh());
            ps.setObject(4, m.getDienThoai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    //check Trùng
    public boolean checkTrung(String maMoi) {
        sql = "select MaNH,HoTen,NgaySinh,DienThoai from NguoiHoc where MaNH = ?";
        Model_NguoiHoc model_NguoiHoc = null;
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
        sql = "delete from NguoiHoc where MaNH = ?";
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
    
    //tìm kiếm
    public ArrayList<Model_NguoiHoc> tim(String sđtCanTim) {
        sql = "select MaNH,HoTen,NgaySinh,DienThoai from NguoiHoc \n"
                + "where DienThoai like ?";
        ArrayList<Model_NguoiHoc> list_NguoiHoc = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, '%' + sđtCanTim + '%');
            rs = ps.executeQuery();
            while (rs.next()) {
                String maNH;
                String hoTen;
                String ngaySinh;
                String dienThoai;
                maNH = rs.getString(1);
                hoTen = rs.getString(2);
                ngaySinh = rs.getString(3);
                dienThoai = rs.getString(4);
                Model_NguoiHoc model_NguoiHoc = new Model_NguoiHoc(maNH, hoTen, ngaySinh, dienThoai);
                list_NguoiHoc.add(model_NguoiHoc);
            }
            return list_NguoiHoc;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
