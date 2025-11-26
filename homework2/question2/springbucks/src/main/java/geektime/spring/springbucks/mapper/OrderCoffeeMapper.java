package geektime.spring.springbucks.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderCoffeeMapper {
    void insertOrderCoffee(@Param("orderId") Long orderId, @Param("coffeeId") Long coffeeId);
}
