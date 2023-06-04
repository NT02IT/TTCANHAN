/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ThongTinDAO;
import DTO.ThongTin;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author agond
 */
public class ThongTinBUS implements Action<ThongTin>{
    private ThongTinDAO ttDAO;
    private ArrayList<ThongTin> list;    

    public ThongTinBUS() throws ClassNotFoundException, SQLException, IOException {
        ttDAO = new ThongTinDAO();
        this.list = new ArrayList<>(ttDAO.getList());
    }

    public ArrayList<ThongTin> getList() {
        return list;
    }

    @Override
    public boolean write(ThongTin data) throws IOException {
        for (ThongTin tt : list){
            if(data.getID().equals(tt.getID())) return false;
        }        
        if(ttDAO.write(data)){
            list.add(data);
            return true;
        } else return false; 
    }

    @Override
    public boolean delete(ThongTin data) throws IOException {
        String ID = data.getID().trim();
        int index = 0;
        for (ThongTin tt : list){
            if(tt.getID().equals(ID)){
                if(ttDAO.delete(data)){
                    list.remove(index);
                    return true;
                }
            }
            index++;
        }
        return false;
    }

    @Override
    public boolean update(ThongTin data) throws IOException {
        String ID = data.getID().trim();
        int index = 0;
        for (ThongTin tt : list){
            if(tt.getID().equals(ID)){
                if(ttDAO.update(data)){
                    list.set(index, data);
                    return true;
                }
            }
            index++;
        }        
        return false;
    }

    @Override
    public ThongTin getObjectbyID(String ID) {
        for (ThongTin tt : list){
            if(tt.getID().equals(ID)) return tt;
        }
        return null;
    }
    
}
