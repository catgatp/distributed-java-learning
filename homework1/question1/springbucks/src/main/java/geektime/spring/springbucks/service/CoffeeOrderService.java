package geektime.spring.springbucks.service;

import geektime.spring.springbucks.mapper.CoffeeOrderMapper;
import geektime.spring.springbucks.model.Coffee;
import geektime.spring.springbucks.model.CoffeeOrder;
import geektime.spring.springbucks.model.OrderState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CoffeeOrderService {

    @Autowired
    private CoffeeOrderMapper orderMapper;
    @Transactional
    public CoffeeOrder createOrder(String customer, List<Coffee> items) {
        CoffeeOrder order = CoffeeOrder.builder()
                .customer(customer)
                .items(items)
                .state(OrderState.INIT)
                .stateOrdinal(OrderState.INIT.ordinal())
                .createTime(new java.util.Date())
                .updateTime(new java.util.Date())
                .build();

        orderMapper.insert(order);
        return order;
    }
    @Transactional
    public boolean updateState(CoffeeOrder order, OrderState newState) {
        if (newState.compareTo(order.getState()) <= 0) {
            return false; // 状态不能回退
        }

        orderMapper.updateState(order.getId(), newState.ordinal());
        order.setState(newState);
        order.setStateOrdinal(newState.ordinal());
        order.setUpdateTime(new java.util.Date());
        return true;
    }

    public List<CoffeeOrder> findAll() {
        return orderMapper.selectAll();
    }
}
