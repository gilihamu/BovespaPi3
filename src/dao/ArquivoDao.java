/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Arquivo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Giliard
 */
public class ArquivoDao {

    protected EntityManager entityManager;

    public ArquivoDao() {
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

    public Arquivo getById(final Integer id) {
        return entityManager.find(Arquivo.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Arquivo> findAll() {
        return entityManager.createQuery("FROM " + Arquivo.class.getName())
                .getResultList();
    }
    
    public void persist(Arquivo arquivo) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(arquivo);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Arquivo arquivo) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(arquivo);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Arquivo arquivo) {
        try {
            entityManager.getTransaction().begin();
            arquivo = entityManager.find(Arquivo.class, arquivo.getId());
            entityManager.remove(arquivo);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final Integer id) {
        try {
            Arquivo arquivo = getById(id);
            remove(arquivo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
