package br.com.scandura.store.tests;

import br.com.scandura.store.dao.CategoryDAO;
import br.com.scandura.store.dao.ProductDAO;
import br.com.scandura.store.model.Category;
import br.com.scandura.store.model.Product;
import br.com.scandura.store.util.JPAUtil;

import javax.persistence.*;
import java.math.BigDecimal;

public class ProductRegister {
    public static void main(String[] args) {
        //Instantiate category
        Category phones = new Category("Phones");

        //Instantiate product
        Product phone = new Product("iPear","Very cool electronic device to watch funny m3m3s",new BigDecimal(1250.56),phones);

        //Connect to the database and insert product
        EntityManager em = JPAUtil.getEntityManager();
        ProductDAO pDAO = new ProductDAO(em);
        CategoryDAO cDAO = new CategoryDAO(em);

        em.getTransaction().begin();
        
        cDAO.insert(phones);
        pDAO.insert(phone);
        phone.setName("iFruit");

        em.flush();
        em.clear();

        cDAO.update(phones);
        phones.setName("Smartphones");

        em.getTransaction().commit();
        em.close();
    }
}
