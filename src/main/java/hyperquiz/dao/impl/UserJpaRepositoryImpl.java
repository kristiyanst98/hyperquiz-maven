package hyperquiz.dao.impl;

import hyperquiz.dao.UserRepository;
import hyperquiz.exceptions.EntityAlreadyExistsException;
import hyperquiz.exceptions.EntityCreationException;
import hyperquiz.exceptions.EntityDataInvalidException;
import hyperquiz.model.User;

import javax.persistence.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class UserJpaRepositoryImpl implements UserRepository {
    EntityManagerFactory emf;
    EntityManager em;

    public void init(){
        emf= Persistence.createEntityManagerFactory("hyperQuizPU");
        em=emf.createEntityManager();
    }
    @Override
    public List<User> findAll() {
        return em.createQuery("SELECT u FROM User AS u").getResultList();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(em.find(User.class,id));
    }

    @Override
    public User create(User entity) throws EntityAlreadyExistsException, IOException {
        EntityTransaction transaction=em.getTransaction();
        transaction.begin();
        em.persist(entity);
        transaction.commit();
        return entity;
    }

    @Override
    public User update(User entity) throws Exception {
        Optional<User> currentUser=findById(entity.getId());
        if(currentUser.isEmpty()){
            throw new EntityDataInvalidException("Entity with ID: "+entity.getId()+" doesn't exist");
        }
        EntityTransaction transaction=em.getTransaction();
        transaction.begin();
        try{
            User updatedUser=em.merge(entity);
            transaction.commit();
            return updatedUser;
        }catch (IllegalArgumentException | PersistenceException e){
            transaction.rollback();
            throw new Exception("Error updating entity"+entity+", "+e);
        }
    }

    @Override
    public User deleteById(Long id) throws EntityDataInvalidException {
        Optional<User> userToDelete=findById(id);
        if(userToDelete.isPresent()){
            EntityTransaction transaction=em.getTransaction();
            transaction.begin();
            em.remove(userToDelete.get());
            transaction.commit();
            return userToDelete.get();
        }else{
            throw new EntityDataInvalidException("Error deleting user by ID: "+id);
        }
    }

    @Override
    public long count() {
        return (Long) em.createQuery("SELECT COUNT(u) FROM User u").getSingleResult();
    }

    @Override
    public List<User> createBatch(Collection<User> collection) throws EntityCreationException {
        List<User> allUsers=new ArrayList<>();
        EntityTransaction transaction=em.getTransaction();
        transaction.begin();
        try {
            for (User u : collection) {
                em.persist(u);
                allUsers.add(u);
            }
            transaction.commit();
        }catch (PersistenceException e){
            transaction.rollback();
            System.out.println(e.getMessage());
            throw new EntityCreationException("Batch Creation: Transaction Rollback");
        }
        return allUsers;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return findAll().stream().filter(user -> user.getUsername().equals(username)).findFirst();
        }
    }
