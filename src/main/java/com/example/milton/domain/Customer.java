package com.example.milton.domain;

import ch.qos.logback.core.boolex.EvaluationException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name ="customer")
public class Customer extends  BaseEntity{
    private String customerName;
    private String address;
    private String mobile;
    private String email;
    private String password;
   @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();


   public void add(Order order){
       if(order != null){
           if(orders == null){
               orders = new ArrayList<>();
           }
           orders.add(order);
           order.setCustomer(this);
       }
   }
}
