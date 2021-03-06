package br.com.scandura.store.dao;

import br.com.scandura.store.model.Product;

import javax.persistence.EntityManager;
import java.util.List;

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

    public void delete(Product p){
        p=this.em.merge(p);
        this.em.remove(p);
    }

    public Product readById(Long id){
        return em.find(Product.class,id);
    }

    public List<Product> readByName(String name){
        String jpql = "SELECT p FROM Product p WHERE p.name=:name";
        return em.createNamedQuery("Product.readByName", Product.class)
                .setParameter("name",name)
                .getResultList();
    }

    public List<Product> readByCategoryName(String name){
        String jpql = "SELECT p FROM Product p WHERE p.category.name=:name";
        return em.createQuery(jpql, Product.class)
                .setParameter("name",name)
                .getResultList();
    }

    public List<Product> readAll(){
        String jpql = "SELECT p FROM Product p";
        return em.createQuery(jpql, Product.class).getResultList();
    }
}
