package cn.wuxr.entity.po;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_customer")
@GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
public class Customer {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "cus_id")
    private String cusId;

    @Column(name = "cus_name")
    private String cusName;

    @Column(name = "cus_address")
    private String cusAddress;

    public Customer() {
    }

    public Customer(String cusId) {
        this.cusId = cusId;
    }

    public Customer(String cusName, String cusAddress) {
        this.cusName = cusName;
        this.cusAddress = cusAddress;
    }

    public Customer(String cusId, String cusName, String cusAddress) {
        this.cusId = cusId;
        this.cusName = cusName;
        this.cusAddress = cusAddress;
    }
}
