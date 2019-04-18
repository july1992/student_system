package com.vily.student_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019-03-27
 *  
 **/
@Entity(name = "user")
@Table(name = "user")
public class User implements Serializable {


    @Id
    @GenericGenerator(name="idGenerator",strategy="uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Column(length = 11)
    private String phoneNumber;  // 电话号码

    @Column(nullable = false)
    private String userName;       // 用户名

    @Column(nullable = false)
    private String password;   // 密码

    @Column(unique = true ,nullable = false)
    private String number;  // 学号，教职工编号

    @Column(length = 1)
    private String gender;     // 性别

    @Column(length = 18)
    private String idCard;  // 身份证

    private Integer work;  // 0：学生 1：老师

    @JsonIgnoreProperties(value = "parentNode")
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="parentNode")
    private List<User> nodes;

    @JsonIgnoreProperties(value = "nodes")
    @ManyToOne(cascade = {CascadeType.REFRESH},optional = true)
    @JoinColumn(name = "user_id")
    private User parentNode;



    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreationTimestamp
    private Timestamp createDate;   //创建时间

    @Column(name = "LAST_MODIFY_DATE",updatable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @UpdateTimestamp
    private Timestamp lastModifyDate;   //最后编辑时间






    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getWork() {
        return work;
    }

    public void setWork(Integer work) {
        this.work = work;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Timestamp lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    public List<User> getNodes() {
        return nodes;
    }

    public void setNodes(List<User> nodes) {
        this.nodes = nodes;
    }

    public User getParentNode() {
        return parentNode;
    }

    public void setParentNode(User parentNode) {
        this.parentNode = parentNode;
    }
}
