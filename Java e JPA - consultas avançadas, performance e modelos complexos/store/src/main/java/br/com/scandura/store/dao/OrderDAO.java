package br.com.scandura.store.dao;

import br.com.scandura.store.model.Order;

import javax.persistence.EntityManager;
import java.util.List;

public class OrderDAO {
    private EntityManager em;

    public OrderDAO(EntityManager em){
        this.em=em;
    }

    public void insert(Order o){
        this.em.persist(o);
    }

    public void update(Order o){
        this.em.merge(o);
    }

    public void delete(Order o){
        o=this.em.merge(o);
        this.em.remove(o);
    }

    public Order readById(Long id){
        return em.find(Order.class,id);
    }

    public List<Order> readByName(String name){
        String jpql = "SELECT o FROM Order o WHERE o.name=:name";
        return em.createQuery(jpql, Order.class)
                .setParameter("name",name)
                .getResultList();
    }

    public List<Order> readByCategoryName(String name){
        String jpql = "SELECT o FROM Order o WHERE o.category.name=:name";
        return em.createQuery(jpql, Order.class)
                .setParameter("name",name)
                .getResultList();
    }

    public List<Order> readAll(){
        String jpql = "SELECT o FROM Order o";
        return em.createQuery(jpql, Order.class).getResultList();
    }
}
