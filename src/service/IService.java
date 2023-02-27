/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import entity.trajet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author MSI
 * @param <T>
 */
public interface IService<T> {
    
    public void insert (T t);
    public boolean supprimer (T t)throws SQLException;
    public boolean update (T t)throws SQLException ;

    /**
     *
     * @return
     */
    public List<trajet> DisplayAll();}