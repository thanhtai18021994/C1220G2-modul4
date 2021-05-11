package com.example.demo.repository.impl;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CustomerRepoImpliment implements CustomerRepo {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Customer> showAll() {
        TypedQuery<Customer> typedQuery=em.createQuery("select c from Customer c",Customer.class);
        return typedQuery.getResultList();
    }

    @Override
    public Customer findById(Long id) {
        TypedQuery<Customer> typedQuery=em.createQuery("select c from Customer c where c.id=:id",Customer.class);
        typedQuery.setParameter("id",id);
        try{
            return typedQuery.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void save(Customer object) {
        if(object.getId()!=null){
            em.merge(object);
        }else {
            em.persist(object);
        }
    }

    @Override
    public void update(Customer object, Long id) {

    }

    @Override
    public List<Customer> search(String text) {
        return null;
    }

    @Override
    public void remove(Long id) {
        Customer customer=findById(id);
        if(customer!=null){
            em.remove(customer);
        }
    }
}
