package com.ruoyi.project.website.images.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 图片表 wx_images
 * 
 * @author ruoyi
 * @date 2019-01-02
 */
public class Images extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 图片id */
	private Integer id;
	/** 图片位置 */
	private String img;
	/** 图片跳转链接 */
	private String imgurl;
	/** 是否显示(0 显示/1 不显示) */
	private int isShow;
	/** 删除表示 Y/N */
	private String delFlag;
	/** 图片显示位置 */
	private Integer locationid;
	/** 位置名称*/
	private String locationName;
	/** 创建时间 */
	private Date createTime;
	/** 修改时间 */
	private Date updateTime;
	/** 状态*/
	private String status;
	
	
	
	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setImg(String img) 
	{
		this.img = img;
	}

	public String getImg() 
	{
		return img;
	}
	public void setImgurl(String imgurl) 
	{
		this.imgurl = imgurl;
	}

	public String getImgurl() 
	{
		return imgurl;
	}
	public void setIsShow(int isShow) 
	{
		this.isShow = isShow;
	}

	public int getIsShow() 
	{
		return isShow;
	}
	public void setDelFlag(String delFlag) 
	{
		this.delFlag = delFlag;
	}

	public String getDelFlag() 
	{
		return delFlag;
	}
	public void setLocationid(Integer locationid) 
	{
		this.locationid = locationid;
	}

	public Integer getLocationid() 
	{
		return locationid;
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
            .append("img", getImg())
            .append("imgurl", getImgurl())
            .append("isShow", getIsShow())
            .append("delFlag", getDelFlag())
            .append("locationid", getLocationid())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
