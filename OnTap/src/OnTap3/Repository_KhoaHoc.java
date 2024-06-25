package OnTap3;

import java.sql.*;
import java.util.ArrayList;

public class Repository_KhoaHoc {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public ArrayList<Model_KhoaHoc> getAll() {
        sql = "select MaKH,HocPhi,ThoiLuong,GhiChu from KhoaHoc";
        ArrayList<Model_KhoaHoc> list_khoaHoc = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maKH;
                double hocPhi;
                int thoiLuong;
                String ghiChu;
                maKH = rs.getInt(1);
                hocPhi = rs.getDouble(2);
                thoiLuong = rs.getInt(3);
                ghiChu = rs.getString(4);
                Model_KhoaHoc model_KhoaHoc = new Model_KhoaHoc(maKH, hocPhi, thoiLuong, ghiChu);
                list_khoaHoc.add(model_KhoaHoc);
            }
            return list_khoaHoc;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //update
    public int update(int ma, Model_KhoaHoc m) {
        sql = "update KhoaHoc set HocPhi = ?, ThoiLuong = ?, GhiChu = ?\n"
                + "where MaKH = ?;";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, m.getHocPhi());
            ps.setObject(2, m.getThoiLuong());
            ps.setObject(3, m.getGhiChu());
            ps.setObject(4, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    //remove
    public int remove(int ma) {
        sql = "delete from KhoaHoc where MaKH = ?";
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
    
}
