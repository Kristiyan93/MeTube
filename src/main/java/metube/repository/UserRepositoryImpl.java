package metube.repository;

import metube.domein.entities.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private final EntityManager entityManager;

    @Inject
    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public User save(User entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();

        return entity;
    }

    @Override
    public List<User> findAll() {
        this.entityManager.getTransaction().begin();

        List<User> users = this.entityManager.createQuery("SELECT u FROM users u", User.class)
                .getResultList();

        this.entityManager.getTransaction().commit();

        return users;
    }

    @Override
    public User findById(String id) {
        this.entityManager.getTransaction().begin();

        User user = this.entityManager.createQuery("SELECT u FROM users u " +
                "WHERE u.id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();

        this.entityManager.getTransaction().commit();

        return user;
    }

    @Override
    public long size() {
        this.entityManager.getTransaction().begin();

        long size = this.entityManager
                .createQuery("SELECT count(u) " +
                        "FROM users u", long.class)
                .getSingleResult();

        this.entityManager.getTransaction().commit();

        return size;
    }

    @Override
    public User findByUsernameAndPassword(String name, String password) {
        this.entityManager.getTransaction().begin();
        User user;

        try {
            user = this.entityManager.createQuery(
                    "SELECT u " +
                            "FROM users u " +
                            "WHERE u.username = :name " +
                            "AND u.password = :password", User.class
            )
                    .setParameter("name", name)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            this.entityManager.getTransaction().commit();
        }

        return user;
    }

    @Override
    public User findByUsername(String username) {
        this.entityManager.getTransaction().begin();
        User user;

        try {
            user = this.entityManager.createQuery(
                    "SELECT u " +
                            "FROM users u " +
                            "WHERE u.username = :name ", User.class
            )
                    .setParameter("name", username)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            this.entityManager.getTransaction().commit();
        }

        return user;
    }
}
