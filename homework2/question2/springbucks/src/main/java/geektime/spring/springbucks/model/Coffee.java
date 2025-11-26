package geektime.spring.springbucks.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Getter
@ToString(callSuper = true)
@Builder
public class Coffee implements Serializable {
    // getter 和 setter
    private Long id;
    private String name;
    private BigDecimal price; // 改为 BigDecimal，MyBatis 默认支持
    private Date createTime;
    private Date updateTime;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
