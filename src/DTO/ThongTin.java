/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author agond
 */
public class ThongTin {
    // ID, HoLot, Ten, NgaySinh, GioiTinh
    private String ID, HoLot, Ten;
    private Date NgaySinh;
    private char GioiTinh;
    
    public ThongTin() {
    }

    public ThongTin(String ID, String HoLot, String Ten, Date NgaySinh, char GioiTinh) {
        this.ID = ID;
        this.HoLot = HoLot;
        this.Ten = Ten;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
    }

    @Override
    public String toString() {
        return "ThongTin{" + "ID=" + ID + ", HoLot=" + HoLot + ", Ten=" + Ten + ", NgaySinh=" + NgaySinh + ", GioiTinh=" + GioiTinh + '}';
    }    

    public String getID() {
        return ID;
    }

    public String getHoLot() {
        return HoLot;
    }

    public String getTen() {
        return Ten;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public char getGioiTinh() {
        return GioiTinh;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setHoLot(String HoLot) {
        this.HoLot = HoLot;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public void setGioiTinh(char GioiTinh) {
        this.GioiTinh = GioiTinh;
    }
    
}
