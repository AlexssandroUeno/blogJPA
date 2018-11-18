/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Role;
import java.util.List;
import javax.persistence.NoResultException;

/**
 *
 * @author Alexssandro Ueno
 */
public class RoleDAO extends GenericDAO<Role>{
    
    public RoleDAO(){
        super();
    }
    
    public Role buscaPorId(Integer id){
        try{
          return (Role) em.createNamedQuery("Role.findByIdRole").setParameter("idRole", id)
                .getSingleResult();  
        }catch(NoResultException ex){
            return null;
        }        
    }
    
    public List<Role> buscaTudo(){
        try{
          return (List<Role>) em.createNamedQuery("Role.findAll");  
        }catch(NoResultException ex){
            return null;
        }        
    }
}
