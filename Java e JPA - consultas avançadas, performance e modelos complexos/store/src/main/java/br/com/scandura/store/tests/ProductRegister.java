package br.com.scandura.store.tests;

import br.com.scandura.store.dao.CategoryDAO;
import br.com.scandura.store.dao.ProductDAO;
import br.com.scandura.store.model.Category;
import br.com.scandura.store.model.Product;
import br.com.scandura.store.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProductRegister {
    public static void main(String[] args) {
        //Connect to the database
        EntityManager em = JPAUtil.getEntityManager();
        ProductDAO pDAO = new ProductDAO(em);
        CategoryDAO cDAO = new CategoryDAO(em);
        dataSetup(em,pDAO,cDAO);

        //Read product from the database using ID
        Product pID = pDAO.readById(1L);
        System.out.println(pID.getPrice());

        //Read product from the database using the name attribute
        List<Product> pNAME = pDAO.readByName("iPear");
        pNAME.forEach(products -> System.out.println(products.getName()));

        //Read product from the database using the name attribute
        List<Product> pCATEGORY = pDAO.readByCategoryName("Phones");
        pCATEGORY.forEach(products -> System.out.println(products.getName()));

        //Read all products from the database
        List<Product> readAll =  pDAO.readAll();
        readAll.forEach(products -> System.out.println(products.getName()));
    }

    public static void dataSetup(EntityManager em,ProductDAO pDAO,CategoryDAO cDAO) {
        //Instantiate category
        Category phones = new Category("Phones");

        //Instantiate product
        Product phone = new Product("iPear","Very cool electronic device to watch funny m3m3s",new BigDecimal(1250.56),phones);

        //Insert product & category
        em.getTransaction().begin();

        cDAO.insert(phones);
        pDAO.insert(phone);

        em.flush();
    }
}
