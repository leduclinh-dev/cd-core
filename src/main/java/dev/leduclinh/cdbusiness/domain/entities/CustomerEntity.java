package dev.leduclinh.cdbusiness.domain.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String phone;

    private String email;

    private String address;

    private String code;

    private Integer debt;

    public CustomerEntity(Long customerId) {
        if (customerId != null) {
            id = customerId;
        }
    }

    public CustomerEntity() {
    }
}
