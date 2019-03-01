package io.samlr.heiken.controller;

import io.samlr.heiken.entity.Node;
import io.samlr.heiken.service.ComputerService;
import io.samlr.heiken.service.EquipmentService;
import io.samlr.heiken.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/node")
public class NodeController {
    private final EquipmentService equipmentService;
    private final ComputerService computerService;
    private final NodeService nodeService;

    @Autowired
    public NodeController(EquipmentService equipmentService, ComputerService computerService, NodeService nodeService) {
        this.equipmentService = equipmentService;
        this.computerService = computerService;
        this.nodeService = nodeService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Node addNode(@RequestBody Node Node) {
        return nodeService.addNode(Node);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Node getNodeById(@PathVariable(value = "id") String id) {
        return nodeService.getNodeById(Long.parseLong(id));
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Node> getAllNodes() {
        return nodeService.getAllNodes();
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Node updateEvent(@RequestBody Node node) {
        return nodeService.updateNode(node);
    }


    @RequestMapping(value = {"/edit-node-{id}"}, method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public String editNode(@PathVariable String id, ModelMap model) {
        Node node = nodeService.getNodeById(Long.valueOf(id));
        model.addAttribute("node", node);
        model.addAttribute("edit", true);
        return "registrationNode";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * updating node in database. It also validates the node input
     */
    @RequestMapping(value = {"/edit-node-{id}"}, method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String updateNode(@Valid Node node, BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "registrationNode";
        }

        nodeService.updateNode(node);

        model.addAttribute("success", "Узел СПД " + node.getName() + " успешно обновлен.");
        return "registrationSuccess";
    }

    @RequestMapping(value = "all_nodes",method = RequestMethod.GET)
    public String getAllNodes(ModelMap model){
        model.addAttribute("node", nodeService.getAllNodes());
        return "all_nodes";
    }

}
