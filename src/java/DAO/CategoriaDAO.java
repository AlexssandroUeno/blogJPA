/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Category;

/**
 *
 * @author Alexssandro Ueno
 */
public class CategoriaDAO extends GenericDAO<Category>{
    
    public Category buscaPorId(Integer id){
        return (Category) em.createNamedQuery("Category.findByIdCategory").setParameter("idCategory", id)
                .getSingleResult();
    }

}
