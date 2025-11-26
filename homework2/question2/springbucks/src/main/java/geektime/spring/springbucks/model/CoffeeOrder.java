package geektime.spring.springbucks.model;

import lombok.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoffeeOrder implements Serializable {

    private Long id;

    private String customer;

    private List<Coffee> items;

    private OrderState state;

    // 对应数据库字段 state，存储枚举 ordinal
    private Integer stateOrdinal;

    private Date createTime;

    private Date updateTime;
}
