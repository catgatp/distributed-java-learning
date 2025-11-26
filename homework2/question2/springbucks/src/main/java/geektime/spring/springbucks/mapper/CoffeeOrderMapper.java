package geektime.spring.springbucks.mapper;

import geektime.spring.springbucks.model.CoffeeOrder;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CoffeeOrderMapper {

    @Select("SELECT id, customer, state AS stateOrdinal, create_time AS createTime, update_time AS updateTime FROM t_order")
    List<CoffeeOrder> selectAll();

    @Select("SELECT id, customer, state AS stateOrdinal, create_time AS createTime, update_time AS updateTime FROM t_order WHERE id = #{id}")
    CoffeeOrder selectById(@Param("id") Long id);

    @Insert("INSERT INTO t_order(customer, state, create_time, update_time) VALUES(#{customer}, #{stateOrdinal}, #{createTime}, #{updateTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(CoffeeOrder order);

    @Update("UPDATE t_order SET state = #{state} WHERE id = #{id}")
    void updateState(@Param("id") Long id, @Param("state") Integer state);
}
