package io.samlr.heiken.service.impl;

import io.samlr.heiken.dao.NodeDao;
import io.samlr.heiken.entity.Node;
import io.samlr.heiken.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeServiceImpl implements NodeService {

    @Autowired
    NodeDao NodeDao;

    @Override
    public Node addNode(Node Node) {
        return NodeDao.create(Node);
    }

    @Override
    public Node getNodeById(Long id) {
        return NodeDao.getById(id);
    }

    @Override
    public List<Node> getAllNodes() {
        return NodeDao.getList();
    }

    @Override
    public Node getNodeByName(String name) {
        return NodeDao.getNodeByName(name);
    }

    @Override
    public Node updateNode(Node Node) {
        return NodeDao.update(Node);
    }

}
