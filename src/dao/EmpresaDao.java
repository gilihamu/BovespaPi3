/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Empresa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Giliard
 */
public class EmpresaDao {

    protected EntityManager entityManager;

    public EmpresaDao() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("WeHaveSciencePU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public Empresa getById(final Integer id) {
        return entityManager.find(Empresa.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Empresa> findAll() {
        return entityManager.createQuery("FROM " + Empresa.class.getName())
                .getResultList();
    }
    
        public Empresa pesquisaRzSocial(String razaoSocial) {
            Query createQuery = entityManager.createQuery("select e FROM Empresa e where e.razaoSocial = ?1" );
         createQuery.setParameter(1, razaoSocial);
         return (Empresa)createQuery.getSingleResult();
        
    }

    public void persist(Empresa empresa) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(empresa);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Empresa empresa) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(empresa);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Empresa empresa) {
        try {
            entityManager.getTransaction().begin();
            empresa = entityManager.find(Empresa.class, empresa.getId());
            entityManager.remove(empresa);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final Integer id) {
        try {
            Empresa pessoa = getById(id);
            remove(pessoa);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
