package geektime.spring.springbucks.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import geektime.spring.springbucks.mapper.CoffeeMapper;
import geektime.spring.springbucks.model.Coffee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoffeeService {
    private final CoffeeMapper coffeeMapper;

    public CoffeeService(CoffeeMapper coffeeMapper) {
        this.coffeeMapper = coffeeMapper;
    }
    public Optional<Coffee> findOneCoffee(String name) {
        List<Coffee> all = coffeeMapper.selectAll();
        return all.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    // 分页查询
    public PageInfo<Coffee> findAllPaged(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Coffee> list = coffeeMapper.findAll();
        return new PageInfo<>(list);
    }

    // 批量查询
    public List<Coffee> findByIds(List<Long> ids) {
        return coffeeMapper.findByIds(ids);
    }

    // CRUD 直接调用 mapper
    public int insert(Coffee coffee) {
        return coffeeMapper.insert(coffee);
    }

    public int update(Coffee coffee) {
        return coffeeMapper.update(coffee);
    }

    public int deleteById(Long id) {
        return coffeeMapper.deleteById(id);
    }

    public Coffee findById(Long id) {
        return coffeeMapper.findById(id);
    }
}
