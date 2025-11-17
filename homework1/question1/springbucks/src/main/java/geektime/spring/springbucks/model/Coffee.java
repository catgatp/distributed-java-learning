package geektime.spring.springbucks.model;

import lombok.Builder;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
@ToString(callSuper = true)
@Builder
public class Coffee {
    private Long id;
    private String name;
    private BigDecimal price; // 改为 BigDecimal，MyBatis 默认支持
    private Date createTime;
    private Date updateTime;

    // getter 和 setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
