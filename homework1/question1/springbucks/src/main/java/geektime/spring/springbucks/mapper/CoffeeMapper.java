package geektime.spring.springbucks.mapper;

import geektime.spring.springbucks.model.Coffee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface CoffeeMapper {
    List<Coffee> selectAll();
    Coffee selectByName(@Param("name") String name);
    int insert(Coffee coffee);
}
