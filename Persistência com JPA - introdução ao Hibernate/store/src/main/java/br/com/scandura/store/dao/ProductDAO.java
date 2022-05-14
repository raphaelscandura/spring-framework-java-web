package br.com.scandura.store.dao;

import br.com.scandura.store.model.Product;

import javax.persistence.EntityManager;

public class ProductDAO {
    private EntityManager em;

    public ProductDAO(EntityManager em){
        this.em=em;
    }

    public void insert(Product p){
        this.em.persist(p);
    }

    public void update(Product p){
        this.em.merge(p);
    }
}
