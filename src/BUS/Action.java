/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BUS;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author agond
 */
public interface Action<A> {
    public boolean write(A data) throws IOException;   
    public boolean delete(A data) throws IOException;   
    public boolean update(A data) throws IOException;   
    public A getObjectbyID(String ID);
}