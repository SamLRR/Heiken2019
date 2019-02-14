package io.samlr.heiken.dao;

import io.samlr.heiken.entity.Node;

import java.util.List;

public interface NodeDao extends BasicDao<Node> {

    Node getNodeByName(String name);

    List<Node> getNodeById(String id);

    List<Node> getAllNodes(Long id);
}
