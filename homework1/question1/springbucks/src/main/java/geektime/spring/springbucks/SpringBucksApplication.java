package geektime.spring.springbucks;

import com.github.pagehelper.PageInfo;
import geektime.spring.springbucks.model.Coffee;
import geektime.spring.springbucks.model.CoffeeOrder;
import geektime.spring.springbucks.model.OrderState;
import geektime.spring.springbucks.mapper.CoffeeMapper;
import geektime.spring.springbucks.service.CoffeeOrderService;
import geektime.spring.springbucks.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@SpringBootApplication
@EnableCaching(proxyTargetClass = true)
public class SpringBucksApplication implements ApplicationRunner {

    @Autowired
    private CoffeeMapper coffeeMapper;

    @Autowired
    private CoffeeService coffeeService;

    @Autowired
    private CoffeeOrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBucksApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        log.info("All Coffee: {}", coffeeMapper.selectAll());

        Optional<Coffee> latte = coffeeService.findOneCoffee("latte");
        if (latte.isPresent()) {
            // 将单个 Coffee 包装成 List
            CoffeeOrder order = orderService.createOrder("Li Lei", Collections.singletonList(latte.get()));
            log.info("Created Order: {}", order);

            // 更新状态
            boolean successPaid = orderService.updateState(order, OrderState.PAID);
            log.info("Update INIT -> PAID: {}", successPaid);

            boolean successInit = orderService.updateState(order, OrderState.INIT);
            log.info("Update PAID -> INIT (should fail): {}", successInit);


        }
        List<Coffee> batch = coffeeService.findByIds(List.of(1L, 2L, 3L));
        log.info("findByIds {}",batch);
        PageInfo<Coffee> pageInfo = coffeeService.findAllPaged(1, 5);
        log.info("pageInfo {}",pageInfo);
        runCache();
    }
    private void runCache() throws Exception{
        log.info("Count: {}", coffeeService.findAllCoffee().size());
        for (int i = 0; i < 5; i++) {
            log.info("Reading from cache.");
            coffeeService.findAllCoffee();
        }
        Thread.sleep(5_000);
        log.info("Reading after refresh.");
        coffeeService.findAllCoffee().forEach(c -> log.info("Coffee {}", c.getName()));
    }



}
