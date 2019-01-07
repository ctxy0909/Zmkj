package com.ruoyi.project.website.location.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 显示位置表 wx_location
 * 
 * @author ruoyi
 * @date 2019-01-02
 */
public class Location extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 模块显示位置id */
	private Integer id;
	/** 模块显示位置 */
	private String location;
	/** 创建时间 */
	private Date createTime;
	/** 修改时间 */
	private Date updateTime;
	 /** 用户是否存在此岗位标识 默认不存在 */
    private boolean flag = false;
	
    
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setLocation(String location) 
	{
		this.location = location;
	}

	public String getLocation() 
	{
		return location;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("location", getLocation())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
