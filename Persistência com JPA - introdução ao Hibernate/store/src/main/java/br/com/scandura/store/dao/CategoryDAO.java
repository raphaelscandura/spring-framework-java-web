package br.com.scandura.store.dao;

import br.com.scandura.store.model.Category;

import javax.persistence.EntityManager;

public class CategoryDAO {
    private EntityManager em;

    public CategoryDAO(EntityManager em){
        this.em=em;
    }

    public void insert(Category p){
        this.em.persist(p);
    }
}
