package br.com.scandura.store.dao;

import br.com.scandura.store.model.Category;

import javax.persistence.EntityManager;

public class CategoryDAO {
    private EntityManager em;

    public CategoryDAO(EntityManager em){
        this.em=em;
    }

    public void insert(Category c){
        this.em.persist(c);
    }

    public void update(Category c){
        this.em.merge(c);
    }

    public void delete(Category c){
        c=em.merge(c);
        this.em.remove(c);
    }
}
