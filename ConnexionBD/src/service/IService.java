/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

/**
 *
 * @author MSI
 * @param <T>
 */
public interface IService<T> {
    
    public void insert (T t);
    public void delete (T t);
    public void update (T t);
}


    