package io.samlr.heiken.entity;

import javax.persistence.*;

@Entity
@Table(name = "computers")
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "arm_name")
    private String armName;
    private Long code;

    @Column(name = "node_id")
    private Long nodeId;

    @Column(name = "department_id")
    private Long departmentId;
    private String description;

    @Column(name = "domain_name")
    private String domainName;

    private String name;
    private String phone;
    private Long tip_pk;
    private Long diap_ip;
    private String radmin_pass;

    @Column(name = "user_description")
    private String userDescription;
    private String radmin_port;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArmName() {
        return armName;
    }

    public void setArmName(String armName) {
        this.armName = armName;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getTip_pk() {
        return tip_pk;
    }

    public void setTip_pk(Long tip_pk) {
        this.tip_pk = tip_pk;
    }

    public Long getDiap_ip() {
        return diap_ip;
    }

    public void setDiap_ip(Long diap_ip) {
        this.diap_ip = diap_ip;
    }

    public String getRadmin_pass() {
        return radmin_pass;
    }

    public void setRadmin_pass(String radmin_pass) {
        this.radmin_pass = radmin_pass;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    public String getRadmin_port() {
        return radmin_port;
    }

    public void setRadmin_port(String radmin_port) {
        this.radmin_port = radmin_port;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }
}
