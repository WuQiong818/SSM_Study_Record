package cn.wangye.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Customer {
    private Integer customerId;
    private String customerName;

    private List<Order> orderList;//体现对多的关系
}
