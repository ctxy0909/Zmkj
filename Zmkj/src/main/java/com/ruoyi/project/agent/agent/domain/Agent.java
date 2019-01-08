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
	private String agentTel;
	/** 联系电话 */
	private String company;
	/** 联系地址 */
	private String address;
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

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setDevellopNextlevel(String devellopNextlevel) 
	{
		this.devellopNextlevel = devellopNextlevel;
	}

	public String getDevellopNextlevel() 
	{
		return devellopNextlevel;
	}
	public void setParentAgentId(Integer parentAgentId) 
	{
		this.parentAgentId = parentAgentId;
	}

	public Integer getParentAgentId() 
	{
		return parentAgentId;
	}
	public void setAgentName(String agentName) 
	{
		this.agentName = agentName;
	}

	public String getAgentName() 
	{
		return agentName;
	}
	
	public String getAgentTel() {
		return agentTel;
	}

	public void setAgentTel(String agentTel) {
		this.agentTel = agentTel;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getAddress() 
	{
		return address;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getEmail() 
	{
		return email;
	}
	public void setLoginName(String loginName) 
	{
		this.loginName = loginName;
	}

	public String getLoginName() 
	{
		return loginName;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getPassword() 
	{
		return password;
	}
	public void setSalt(String salt) 
	{
		this.salt = salt;
	}

	public String getSalt() 
	{
		return salt;
	}
	public void setCreateBy(String createBy) 
	{
		this.createBy = createBy;
	}

	public String getCreateBy() 
	{
		return createBy;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUpdateBy(String updateBy) 
	{
		this.updateBy = updateBy;
	}

	public String getUpdateBy() 
	{
		return updateBy;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}


    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("devellopNextlevel", getDevellopNextlevel())
            .append("parentAgentId", getParentAgentId())
            .append("agentName", getAgentName())
            .append("agentTel", getAgentTel())
            .append("adress", getAddress())
            .append("company", getCompany())
            .append("email", getEmail())
            .append("loginName", getLoginName())
            .append("password", getPassword())
            .append("salt", getSalt())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
	
	
}
