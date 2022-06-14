package br.com.scandura.store.tests;

import br.com.scandura.store.dao.CategoryDAO;
import br.com.scandura.store.dao.CustomerDAO;
import br.com.scandura.store.dao.OrderDAO;
import br.com.scandura.store.dao.ProductDAO;
import br.com.scandura.store.model.*;
import br.com.scandura.store.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class OrderRegister {

    public static void main(String[] args) {
        //Connect to the database
        EntityManager em = JPAUtil.getEntityManager();
        ProductDAO pDAO = new ProductDAO(em);
        CategoryDAO cDAO = new CategoryDAO(em);
        CustomerDAO cuDAO = new CustomerDAO(em);
        OrderDAO oDAO = new OrderDAO(em);
        dataSetup(em,pDAO,cDAO,cuDAO, oDAO);
    }

    public static void dataSetup(EntityManager em, ProductDAO pDAO, CategoryDAO cDAO, CustomerDAO cuDAO, OrderDAO oDAO) {
        //Instantiate category
        Category phones = new Category("Phones");

        //Instantiate product
        Product phone = new Product("iPear","Very cool electronic device to watch funny m3m3s",new BigDecimal(1250.56),phones);

        //Instantiate customer
        Customer c = new Customer("Johnny","51N5");

        //Instantiate order
        Order o = new Order(c);
        o.addProduct(new ProductOrder(10,o,phone));

        //Insert product & category
        em.getTransaction().begin();

        cDAO.insert(phones);
        pDAO.insert(phone);
        cuDAO.insert(c);
        oDAO.insert(o);

        em.flush();
        System.out.println(oDAO.salesReport());
    }
}
