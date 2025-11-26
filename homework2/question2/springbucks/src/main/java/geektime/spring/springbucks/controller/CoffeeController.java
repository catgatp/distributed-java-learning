package geektime.spring.springbucks.controller;

import geektime.spring.springbucks.model.Coffee;
import geektime.spring.springbucks.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coffee")
@Slf4j
public class CoffeeController {
    @Autowired
    private CoffeeService coffeeService;
    @GetMapping(path = "/",  params = "!name", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Coffee> getAll() {

        return coffeeService.findAllCoffee();
    }
    @GetMapping(path = "/", params = "name", produces = {MediaType.APPLICATION_XML_VALUE})
    public Optional<Coffee> getByName(@RequestParam String name) {
        return coffeeService.findOneCoffee(name);
    }
}
