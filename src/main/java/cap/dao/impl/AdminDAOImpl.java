import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository(value = "adminDAO")
public class AdminDAOImpl implements AdminDAO {
    @@ -23,4 +25,18 @@ public Admin login(Admin admin) {
        return this.jdbcTemplate.queryForObject(sql, new Object[]{admin.getUsername(), admin.getPassword()}, ParameterizedBeanPropertyRowMapper.newInstance(Admin.class));

    }

    @Override
    public List<Admin> findByPage(int pageNo, int pageSize) {
        String sql = "select * from admin limit ?,?";
        int start = (pageNo - 1) * pageSize;
        return this.jdbcTemplate.query(sql, new Object[]{start, pageSize}, ParameterizedBeanPropertyRowMapper.newInstance(Admin.class));
    }

    @Override
    public int getTotalCount() {
        String sql = "select count(*) from admin";
        return jdbcTemplate.queryForObject(sql, Integer.class);

    }
}