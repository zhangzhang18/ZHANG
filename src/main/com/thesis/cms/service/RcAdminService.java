package com.thesis.cms.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;

import com.thesis.cms.common.page.Pagination;
import com.thesis.cms.model.RcAdmin;
import com.thesis.cms.model.Students;

/**
 * 标题、简要说明. <br>
 * 类详细说明. 后台管理员接口服务类
 */
public interface RcAdminService {

	public List<RcAdmin> getUserList(Map<String, Object> map);

	public void addUser(RcAdmin admin);

	public void deleteUserById(String[] userId);

	public RcAdmin getUserById(String adminId);

	public void updateUser(RcAdmin admin);


	/**
	 * @DESC 根据ID主键查询用户
	 * @return
	 * @throws Exception
	 */
	public RcAdmin findByID(int rcAdminID);


	public Pagination getPage(int pageNo, int pageSize);

	public Pagination getPageForContacts(int pageNo, int pageSize, List<Integer> contactIds);

	/**
	 * @DESC 根据用户名查询用户密码
	 * @param userName
	 * @return
	 */
	public RcAdmin getPasswdByUsername(String userName);

	/**
	 * 根据证件号码获得用户实体
	 *
	 * @return
	 */
	public RcAdmin getPasswdByPapers(String papers);

	/**
	 * @DESC 保存用户
	 * @throws Exception
	 */

	public Map<String, List<RcAdmin>> getUserListByLevel();

	public List<RcAdmin> getListByDepts(String[] deptIds);

	public List<RcAdmin> getListByIds(String[] userIds);

	public List<RcAdmin> getListByNames(String[] userNames);

	public List<RcAdmin> getListByDeptId(Integer deptId);

	public Map<String, List<RcAdmin>> getUserMapByIds(String[] ids);

	public int checkPapers(String papers);

	public int checkPapersByEditId(String userid, String papers);

	public List<RcAdmin> getUserListByDeptId(String deptId);

	public List<Integer> getDeptIdByUserId(String[] users);

	List<RcAdmin> getList();

	public List<RcAdmin> getAdminList();

	public int addAdmin(RcAdmin rcAdmin);

	public RcAdmin getAdminById(Integer id);

	public int updateRcAdmin(RcAdmin rcAdmin);

	public void delRcAdminById(String id);

	public List<RcAdmin> getAdminListByDeptId(String deptId);

	public RcAdmin getAdminName(String checkIdList);

	public List<RcAdmin> getAdminByIds(String ids);


	public Integer getRolebyName(String name);

	public String getpwdByPapers(String papers);


	public void updatebystuname(RcAdmin rcAdmin);

	public RcAdmin getAdminByName(String stuname);


	public List<RcAdmin> selectadmin();

	public Pagination getPage(int cpn, int pageSize, String papers);

	public void fromXls2(List<RcAdmin> rcAdmins);


}
