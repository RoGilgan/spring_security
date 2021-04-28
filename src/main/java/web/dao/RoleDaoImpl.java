package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role getRoleById(int id) {
        return entityManager.createQuery("SELECT r FROM Role r WHERE r.id =: id", Role.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public Role saveRole(Role role) {
        entityManager.persist(role);
        return role;
    }

    @Override
    public void deleteRole(int id) {
        entityManager.createQuery("DELETE FROM Role r WHERE r.id =: id")
                .setParameter("id", id).executeUpdate();
    }

    @Override
    public List<Role> getRoles(String[] arr) {
        List<Long> listOfId = Arrays.stream(arr).mapToLong(Long::parseLong)
                .boxed().collect(Collectors.toList());

        return entityManager.createQuery("SELECT r FROM Role r WHERE r.id IN (:id)", Role.class)
                .setParameter("id", listOfId)
                .getResultList();
    }
}
