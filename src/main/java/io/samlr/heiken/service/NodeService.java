package io.samlr.heiken.service;

import io.samlr.heiken.entity.Node;

import java.util.List;

public interface NodeService {

    Node addNode(Node Node);

    Node getNodeById(Long id);

    List<Node> getAllNodes();

    Node getNodeByName(String name);

    Node updateNode(Node Node);
}
