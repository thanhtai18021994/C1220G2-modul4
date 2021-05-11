//package com.codegym.demo.repository.impl;
//
//import com.codegym.demo.entity.Customer;
//import com.codegym.demo.entity.Manufacture;
//import com.codegym.demo.repository.CustomerRepository;
//import org.springframework.stereotype.Service;
//
//import javax.persistence.EntityManager;
//import javax.persistence.NoResultException;
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Service
//@Transactional
//public class CustomerRepoImplement implements CustomerRepository {
//
//    @PersistenceContext
//    private EntityManager em;
//
//
//    @Override
//    public List<Customer> showList() {
//        TypedQuery<Customer> query=em.createQuery("select c from Customer c",Customer.class);
//        return query.getResultList();
//    }
//    public List<Manufacture> listManufacture(){
//        TypedQuery<Manufacture> query=em.createQuery("select c from Manufacture c",Manufacture.class);
//        return query.getResultList();
//    }
//    @Override
//    public Customer findById(Integer id) {
//        TypedQuery<Customer> query=em.createQuery("select c from Customer c where c.id=:id",Customer.class);
//        query.setParameter("id",id);
//        try {
//            return query.getSingleResult();
//        }catch (NoResultException e){
//            return null;
//        }
//    }
//
//    @Override
//    public void save(Customer object) {
//        if (object.getId()==null){
//            em.merge(object);
//        }else {
//            em.persist(object);
//        }
//    }
//}
