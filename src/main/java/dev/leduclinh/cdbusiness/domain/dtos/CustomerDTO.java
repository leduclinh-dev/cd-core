package dev.leduclinh.cdbusiness.domain.dtos;

import dev.leduclinh.cdbusiness.domain.entities.CustomerEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {

    private Long id;
    private String fullName;
    private String phone;
    private String email;
    private String address;
    private String code;
    private Integer debt;

    public CustomerDTO() {
    }

    public void buildResponse (CustomerEntity entity) {
        if (entity != null) {
            this.code = entity.getCode();
        }
    }
    public void buildListResponse (CustomerEntity entity) {
        if (entity != null) {
            this.id = entity.getId();
            this.fullName = entity.getFullName();
            this.phone = entity.getPhone();
            this.email = entity.getEmail();
            this.address = entity.getAddress();
            this.code = entity.getCode();
            this.debt = entity.getDebt();
        }
    }
}
