package br.com.scandura.store.dao;

import br.com.scandura.store.model.Category;
import br.com.scandura.store.model.Product;

import javax.persistence.EntityManager;
import java.util.List;

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

    public Category readOne(Long id){
        return em.find(Category.class,id);
    }

    public List<Category> readAll(){
        String jpql = "SELECT c FROM Category c";
        return em.createQuery(jpql, Category.class).getResultList();
    }
}
