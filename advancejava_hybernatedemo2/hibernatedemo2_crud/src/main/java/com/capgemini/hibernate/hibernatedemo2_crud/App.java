package com.capgemini.hibernate.hibernatedemo2_crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {

       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");

      
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

           
            Customer newCustomer =
                    new Customer(107, "John Johnson", "Chicago");

            em.persist(newCustomer);

          
            Customer foundCustomer =
                    em.find(Customer.class, 107);

            System.out.println("Found Customer: " + foundCustomer);

          
            if (foundCustomer != null) {
                foundCustomer.setName("Alice Updated");
                foundCustomer.setCity("Seattle");

                em.merge(foundCustomer);

                System.out.println("Updated Customer: " + foundCustomer);
            }

          
            Customer customerToDelete =
                    em.find(Customer.class, 101);

            if (customerToDelete != null) {
                em.remove(customerToDelete);
                System.out.println("Deleted Customer: " + customerToDelete);
            }

            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
