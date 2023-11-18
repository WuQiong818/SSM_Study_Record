package cn.wangye.pojo;

import lombok.Data;

@Data
public class Order {
    private Integer orderId;
    private String orderName;

    private Customer customer;//体现对一的关系
}
