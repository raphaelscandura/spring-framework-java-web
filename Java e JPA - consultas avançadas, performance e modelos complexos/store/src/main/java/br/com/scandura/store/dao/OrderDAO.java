package br.com.scandura.store.dao;

import br.com.scandura.store.model.Order;
import br.com.scandura.store.vo.SalesReportVo;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
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

    public BigDecimal orderTotal(){
        String jpql = "SELECT SUM(o.totalPrice) from Order o";
        return em.createQuery(jpql,BigDecimal.class)
                .getSingleResult();
    }

    public List<SalesReportVo> salesReport(){
        String jpql = "SELECT new br.com.scandura.store.vo.SalesReportVo(" +
                "product.name," +
                "SUM(item.quantity)," +
                "MAX(o.date))" +
                "FROM Order o " +
                "JOIN o.products item " +
                "JOIN item.product product " +
                "GROUP BY product.id " +
                "ORDER BY item.quantity DESC";
        return em.createQuery(jpql, SalesReportVo.class)
                .getResultList();
    }
}
