package br.com.scandura.store.dao;

import br.com.scandura.store.model.Customer;
import br.com.scandura.store.model.Order;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomerDAO {
    private EntityManager em;

    public CustomerDAO(EntityManager em){
        this.em=em;
    }

    public void insert(Customer c){
        this.em.persist(c);
    }

    public void update(Customer c){
        this.em.merge(c);
    }

    public void delete(Customer c){
        c=this.em.merge(c);
        this.em.remove(c);
    }

    public Customer readById(Long id){
        return em.find(Customer.class,id);
    }

    public List<Customer> readByName(String name){
        String jpql = "SELECT c FROM Customer c WHERE c.name=:name";
        return em.createQuery(jpql, Customer.class)
                .setParameter("name",name)
                .getResultList();
    }

    public List<Customer> readByCategoryName(String name){
        String jpql = "SELECT c FROM Customer c WHERE c.category.name=:name";
        return em.createQuery(jpql, Customer.class)
                .setParameter("name",name)
                .getResultList();
    }

    public List<Customer> readAll(){
        String jpql = "SELECT c FROM Customer c";
        return em.createQuery(jpql, Customer.class).getResultList();
    }
}
