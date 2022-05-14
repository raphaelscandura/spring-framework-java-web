package br.com.scandura.store.tests;

import br.com.scandura.store.dao.ProductDAO;
import br.com.scandura.store.model.Product;
import br.com.scandura.store.util.JPAUtil;

import javax.persistence.*;
import java.math.BigDecimal;

public class ProductRegister {
    public static void main(String[] args) {
        //Instantiate product
        Product phone = new Product();
        phone.setName("iPear");
        phone.setDescription("Very cool electronic device to watch funny m3m3s");
        phone.setPrice(new BigDecimal(1250.56));

        //Connect to the database and insert product
        EntityManager em = JPAUtil.getEntityManager();
        ProductDAO pDAO = new ProductDAO(em);
        
        em.getTransaction().begin();
        pDAO.insert(phone);
        em.getTransaction().commit();
        em.close();
    }
}
