import cap.dao.AdminDAO;
import cap.model.Admin;
import cap.service.AdminService;
import cap.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service(value = "adminService")
@@ -17,4 +19,16 @@
public Admin login(Admin admin) {
        return adminDAO.login(admin);
        }

@Override
public PageBean findByPage(int pageNo, int pageSize) {
        PageBean pageBean = new PageBean();
        List<Admin> adminList = adminDAO.findByPage(pageNo, pageSize);
        int totalCount = adminDAO.getTotalCount();
        pageBean.setPageNo(pageNo);
        pageBean.setPageSize(pageSize);
        pageBean.setList(adminList);
        pageBean.setTotalRecords(totalCount);
        return pageBean;
        }
        }