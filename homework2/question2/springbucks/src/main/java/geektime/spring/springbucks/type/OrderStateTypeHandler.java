package geektime.spring.springbucks.type;

import geektime.spring.springbucks.model.OrderState;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import java.sql.*;

public class OrderStateTypeHandler extends BaseTypeHandler<OrderState> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, OrderState parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.ordinal());
    }

    @Override
    public OrderState getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int i = rs.getInt(columnName);
        return OrderState.values()[i];
    }

    @Override
    public OrderState getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int i = rs.getInt(columnIndex);
        return OrderState.values()[i];
    }

    @Override
    public OrderState getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int i = cs.getInt(columnIndex);
        return OrderState.values()[i];
    }
}
