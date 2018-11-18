/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Alexssandro Ueno
 */
public abstract class GenericDAO<T> {
    
    protected EntityManager em;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("blogJPAPU"); 
    private EntityTransaction tx = null;
    
    public GenericDAO() {
        em = emf.createEntityManager();
    }
    
    private final Class<T> entityClass
            = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    
    public void save(T t){
        try{
            this.tx = em.getTransaction();
            tx.begin();
            em.persist(t);
            tx.commit();
        }catch(Exception e){
            System.out.println(e);
            tx.rollback();
        }
    }
    public void update(T t){
        try{
            this.tx = em.getTransaction();
            tx.begin();
            em.merge(t);
            tx.commit();
        }catch(Exception e){
            System.out.println(e);
            tx.rollback();
        }
    }
    
    public void delete(T t){
        try{
            this.tx = em.getTransaction();
            tx.begin();
            em.remove(t);
            tx.commit();
        }catch(Exception e){
            System.out.println(e);
            tx.rollback();
        }
    }
    
    public List<T> findAll() {
        return em.createNamedQuery(entityClass.getSimpleName() + ".findAll")
                .getResultList();
    }
    
    
}
