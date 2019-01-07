package com.ruoyi.project.website.banner.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 轮播图表 wx_banner
 * 
 * @author ruoyi
 * @date 2019-01-02
 */
public class Banner extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 轮播图id */
	private Integer id;
	/** 轮播图 */
	private String bannerimg;
	/** 轮播图位置 */
	private Integer locationid;
	/** 轮播图跳转链接 */
	private String bannerurl;
	/** 创建时间 */
	private Date createTime;
	/** 修改时间 */
	private Date updateTime;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setBannerimg(String bannerimg) 
	{
		this.bannerimg = bannerimg;
	}

	public String getBannerimg() 
	{
		return bannerimg;
	}
	public void setLocationid(Integer locationid) 
	{
		this.locationid = locationid;
	}

	public Integer getLocationid() 
	{
		return locationid;
	}
	public void setBannerurl(String bannerurl) 
	{
		this.bannerurl = bannerurl;
	}

	public String getBannerurl() 
	{
		return bannerurl;
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
            .append("bannerimg", getBannerimg())
            .append("locationid", getLocationid())
            .append("bannerurl", getBannerurl())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
