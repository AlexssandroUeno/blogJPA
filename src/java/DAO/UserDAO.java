/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.User;
import javax.persistence.NoResultException;

/**
 *
 * @author Alexssandro Ueno
 */
public class UserDAO extends GenericDAO<User> {
    
    public UserDAO(){
        super();
    }
    
    public User buscaPorId(Integer id){
        try{
          return (User) em.createNamedQuery("User.findByIdUser").setParameter("idUser", id)
                .getSingleResult();  
        }catch(NoResultException ex){
            return null;
        }        
    }
    
    public User buscaPorUsername(String username){
        try{
            return (User) em.createNamedQuery("User.findByUsername").setParameter("username", username)
            .getSingleResult();
        }catch(NoResultException ex){
            return null;
        }        
    }
    
    public User buscaPorEmail(String email){
        try{
            return (User) em.createNamedQuery("User.findByEmail").setParameter("email", email)
            .getSingleResult();
        }catch(NoResultException ex){
            return null;
        }
    }

}
