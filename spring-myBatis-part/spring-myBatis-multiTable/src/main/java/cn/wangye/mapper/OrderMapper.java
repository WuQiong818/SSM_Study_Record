package cn.wangye.mapper;

import cn.wangye.pojo.Customer;
import cn.wangye.pojo.Order;

public interface OrderMapper {
//    根据ID查询订单，以及订单关联的用户的信息！
    Order selectOrderWithCustomer(Integer orderId);

//    查询客户和客户关联的订单信息！
    Customer selectCustomerWithOrder(Integer customerId);
}
