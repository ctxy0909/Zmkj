package com.ruoyi.project.website.banner.mapper;

import com.ruoyi.project.website.banner.domain.Banner;
import java.util.List;	

/**
 * 轮播图 数据层
 * 
 * @author ruoyi
 * @date 2019-01-02
 */
public interface BannerMapper 
{
	/**
     * 查询轮播图信息
     * 
     * @param id 轮播图ID
     * @return 轮播图信息
     */
	public Banner selectBannerById(Integer id);
	
	/**
     * 查询轮播图列表
     * 
     * @param banner 轮播图信息
     * @return 轮播图集合
     */
	public List<Banner> selectBannerList(Banner banner);
	
	/**
     * 新增轮播图
     * 
     * @param banner 轮播图信息
     * @return 结果
     */
	public int insertBanner(Banner banner);
	
	/**
     * 修改轮播图
     * 
     * @param banner 轮播图信息
     * @return 结果
     */
	public int updateBanner(Banner banner);
	
	/**
     * 删除轮播图
     * 
     * @param id 轮播图ID
     * @return 结果
     */
	public int deleteBannerById(Integer id);
	
	/**
     * 批量删除轮播图
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBannerByIds(String[] ids);
	
}