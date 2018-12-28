package io.samlr.heiken.dao.impl;

import io.samlr.heiken.dao.EquipmentDao;
import io.samlr.heiken.entity.Equipment;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EquipmentDaoImpl extends BasicDaoImpl<Equipment> implements EquipmentDao {
    public EquipmentDaoImpl(Class<Equipment> entityClass) {
        super(entityClass);
    }

    @Override
    public Equipment getEquipmentByName(String name) {
        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Equipment> criteriaQuery = builder.createQuery(Equipment.class);
        Root<Equipment> root = criteriaQuery.from(Equipment.class);

        criteriaQuery.select(root);
        criteriaQuery.where(builder.equal(root.get("name"), name));

        Query<Equipment> typedQuery = session.createQuery(criteriaQuery);
        return typedQuery.getSingleResult();
    }


    @Override
    public List<Equipment> getEquipmentById(String id) {
        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Equipment> criteriaQuery = builder.createQuery(Equipment.class);
        Root<Equipment> root = criteriaQuery.from(Equipment.class);

        criteriaQuery.select(root);
        criteriaQuery.where(builder.like(root.get("description"), "%" + id + "%"));

        Query<Equipment> typedQuery = session.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    @Override
    public List<Equipment> getAllEquipmentsOfComputer(Long id) {
        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Equipment> criteriaQuery = builder.createQuery(Equipment.class);
        Root<Equipment> root = criteriaQuery.from(Equipment.class);

        criteriaQuery.select(root);
        criteriaQuery.where(builder.equal(root.get("computer"), id));

        Query<Equipment> typedQuery = session.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }
}
