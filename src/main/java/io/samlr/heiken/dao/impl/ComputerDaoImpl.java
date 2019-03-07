package io.samlr.heiken.dao.impl;

import io.samlr.heiken.dao.ComputerDao;
import io.samlr.heiken.entity.Computer;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ComputerDaoImpl extends BasicDaoImpl<Computer> implements ComputerDao {
    public ComputerDaoImpl(Class<Computer> entityClass) {
        super(entityClass);
    }

    @Override
    public Computer getComputerByName(String name) {
        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Computer> criteriaQuery = builder.createQuery(Computer.class);
        Root<Computer> root = criteriaQuery.from(Computer.class);

        criteriaQuery.select(root);
        criteriaQuery.where(builder.equal(root.get("name"), name));

        Query<Computer> typedQuery = session.createQuery(criteriaQuery);
        return typedQuery.getSingleResult();
    }


    @Override
    public List<Computer> getComputerByDescription(String text) {
        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Computer> criteriaQuery = builder.createQuery(Computer.class);
        Root<Computer> root = criteriaQuery.from(Computer.class);

        criteriaQuery.select(root);
        criteriaQuery.where(builder.or(
                builder.like(builder.lower(root.get("armName")), "%"+text.toLowerCase()+"%"),
                builder.like(builder.lower(root.get("description")),"%"+text.toLowerCase()+"%"),
                builder.like(builder.lower(root.get("domainName")),"%"+text.toLowerCase()+"%"),
                builder.like(builder.lower(root.get("userDescription")), "%"+text.toLowerCase()+"%"),
                builder.like(builder.lower(root.get("name")), "%"+text.toLowerCase()+"%"),
                builder.like(root.get("phone"), "%"+text+"%")));

        Query<Computer> typedQuery = session.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }
}
