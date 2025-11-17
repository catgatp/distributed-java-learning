package geektime.spring.springbucks.service;

import geektime.spring.springbucks.mapper.CoffeeMapper;
import geektime.spring.springbucks.model.Coffee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CoffeeService {
    @Autowired
    private CoffeeMapper coffeeMapper;

    public Optional<Coffee> findOneCoffee(String name) {
        List<Coffee> all = coffeeMapper.selectAll();
        return all.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
