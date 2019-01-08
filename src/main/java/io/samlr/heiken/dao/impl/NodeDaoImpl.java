package io.samlr.heiken.dao.impl;

import io.samlr.heiken.dao.NodeDao;
import io.samlr.heiken.entity.Node;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class NodeDaoImpl extends BasicDaoImpl<Node> implements NodeDao {
    public NodeDaoImpl(Class<Node> entityClass) {
        super(entityClass);
    }

    @Override
    public Node getNodeByName(String name) {
        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Node> criteriaQuery = builder.createQuery(Node.class);
        Root<Node> root = criteriaQuery.from(Node.class);

        criteriaQuery.select(root);
        criteriaQuery.where(builder.equal(root.get("name"), name));

        Query<Node> typedQuery = session.createQuery(criteriaQuery);
        return typedQuery.getSingleResult();
    }


    @Override
    public List<Node> getNodeById(String id) {
        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Node> criteriaQuery = builder.createQuery(Node.class);
        Root<Node> root = criteriaQuery.from(Node.class);

        criteriaQuery.select(root);
        criteriaQuery.where(builder.like(root.get("description"), "%" + id + "%"));

        Query<Node> typedQuery = session.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    @Override
    public List<Node> getAllNodes(Long id) {
        return null;
    }
}
