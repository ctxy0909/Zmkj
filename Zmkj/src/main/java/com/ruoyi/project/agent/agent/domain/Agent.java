package com.ruoyi.project.agent.agent.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 代理商表 zmkj_agent
 * 
 * @author ruoyi
 * @date 2019-01-07
 */
public class Agent extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 代理商id */
	private Integer id;
	/** 是否可以发展下级（Y.可以发展下级  N.不可发展下级） */
	private String devellopNextlevel;
	/** 父级代理商ID */
	private Integer parentAgentId;
	/** 代理商名称 */
	private String agentName;
	/** 联系电话 */
	private String phone;
	/** 联系地址 */
	private String adress;
	/** 邮箱 */
	private String email;
	/** 登录账号 */
	private String loginName;
	/** 密码 */
	private String password;
	/** 盐加密 */
	private String salt;
	/** 创建者 */
	private String createBy;
	/** 创建时间 */
	private Date createTime;
	/** 更新者 */
	private String updateBy;
	/** 更新时间 */
	private Date updateTime;
	/**  */
	private String remark;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDevellopNextlevel() {
		return devellopNextlevel;
	}

	public void setDevellopNextlevel(String devellopNextlevel) {
		this.devellopNextlevel = devellopNextlevel;
	}

	public Integer getParentAgentId() {
		return parentAgentId;
	}

	public void setParentAgentId(Integer parentAgentId) {
		this.parentAgentId = parentAgentId;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String getCreateBy() {
		return createBy;
	}

	@Override
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Override
	public Date getCreateTime() {
		return createTime;
	}

	@Override
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String getUpdateBy() {
		return updateBy;
	}

	@Override
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Override
	public Date getUpdateTime() {
		return updateTime;
	}

	@Override
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String getRemark() {
		return remark;
	}

	@Override
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
