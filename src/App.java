/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import DAO.ThongTinDAO;
import DTO.ThongTin;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 *
 * @author agond
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException, ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        ThongTinDAO ttDAO = new ThongTinDAO();
        ThongTin tt = new ThongTin("TT3", "Nguyễn Đức", "Toàn", formatter.parse("2005-05-10"), '1');
        
        ttDAO.update(tt);
        System.out.println(ttDAO.getList());
        
    }
    
}
