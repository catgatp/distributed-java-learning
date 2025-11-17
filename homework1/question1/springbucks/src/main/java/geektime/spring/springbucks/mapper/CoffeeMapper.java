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

    // 更新
    int update(Coffee coffee);

    // 删除
    int deleteById(Long id);

    // 根据 id 查询
    Coffee findById(Long id);

    // 批量查询
    List<Coffee> findByIds(@Param("ids") List<Long> ids);

    // 查询所有
    List<Coffee> findAll();
}
