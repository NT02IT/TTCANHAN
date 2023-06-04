/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Connection.ConnectDB;
import DTO.ThongTin;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agond
 */
public class ThongTinDAO implements Action<ThongTin>{
    private ArrayList<ThongTin> list = new ArrayList<>();
    private int maxID = 0;

    public ThongTinDAO() throws ClassNotFoundException, SQLException, IOException {
        ConnectDB myConn = new ConnectDB();
        read();
        maxID = list.size();
    }

    public ArrayList<ThongTin> getList() {
        return list;
    }
    
    @Override
    public ArrayList<ThongTin> read() throws IOException {
        try {
            String sql = "Select * from THONGTIN";
            Statement stmt = ConnectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                ThongTin tt = new ThongTin();
                tt.setID(rs.getString(1));
                tt.setHoLot(rs.getString(2));
                tt.setTen(rs.getString(3));
                tt.setNgaySinh(rs.getDate(4));
                tt.setGioiTinh(rs.getString(5).charAt(0));                
                list.add(tt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongTinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public boolean write(ThongTin data) throws IOException {
        try {
            maxID++;
            data.setID("TT" + maxID);
            String sql = "INSERT INTO THONGTIN (ID, HoLot, Ten, NgaySinh, GioiTinh) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = ConnectDB.conn.prepareStatement(sql);
            pstmt.setString(1, data.getID());
            pstmt.setString(2, data.getHoLot());
            pstmt.setString(3, data.getTen());
            java.sql.Timestamp ngaySinh = new java.sql.Timestamp(data.getNgaySinh().getTime());
            pstmt.setTimestamp(4, ngaySinh);
            pstmt.setString(5, data.getGioiTinh()+"");
            pstmt.executeUpdate();    
            list.add(data);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ThongTinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(ThongTin data) throws IOException {
        try {
            String sql = "DELETE FROM THONGTIN WHERE ID = ?;";
            PreparedStatement pstmt = ConnectDB.conn.prepareStatement(sql);
            pstmt.setString(1, data.getID());
            pstmt.executeUpdate();     
            list.removeIf(tt -> tt.getID().equals(data.getID()));
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ThongTinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;    
    }

    @Override
    public boolean update(ThongTin data) throws IOException {
        try {
            String sql = "UPDATE THONGTIN SET Holot = ?, Ten = ?, NgaySinh = ?, GioiTinh = ? WHERE ID = ?;";
            PreparedStatement pstmt = ConnectDB.conn.prepareStatement(sql);
            pstmt.setString(1, data.getHoLot());
            pstmt.setString(2, data.getTen());
            
            java.sql.Timestamp ngaySinh = new java.sql.Timestamp(data.getNgaySinh().getTime());
            pstmt.setTimestamp(3, ngaySinh);
            pstmt.setString(4, data.getGioiTinh()+"");
            pstmt.setString(5, data.getID());
            pstmt.executeUpdate();  
            
            int index = 0;
            for (ThongTin tt : list){
                if (tt.getID().equals(data.getID())) break;
                index++;
            }
            list.set(index, data);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ThongTinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }    
    
}
