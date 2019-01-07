package com.ruoyi.project.website.banner.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.website.banner.mapper.BannerMapper;
import com.ruoyi.project.website.banner.domain.Banner;
import com.ruoyi.project.website.banner.service.IBannerService;
import com.ruoyi.common.support.Convert;

/**
 * 轮播图 服务层实现
 * 
 * @author ruoyi
 * @date 2019-01-02
 */
@Service
public class BannerServiceImpl implements IBannerService 
{
	@Autowired
	private BannerMapper bannerMapper;

	/**
     * 查询轮播图信息
     * 
     * @param id 轮播图ID
     * @return 轮播图信息
     */
    @Override
	public Banner selectBannerById(Integer id)
	{
	    return bannerMapper.selectBannerById(id);
	}
	
	/**
     * 查询轮播图列表
     * 
     * @param banner 轮播图信息
     * @return 轮播图集合
     */
	@Override
	public List<Banner> selectBannerList(Banner banner)
	{
	    return bannerMapper.selectBannerList(banner);
	}
	
    /**
     * 新增轮播图
     * 
     * @param banner 轮播图信息
     * @return 结果
     */
	@Override
	public int insertBanner(Banner banner)
	{
	    return bannerMapper.insertBanner(banner);
	}
	
	/**
     * 修改轮播图
     * 
     * @param banner 轮播图信息
     * @return 结果
     */
	@Override
	public int updateBanner(Banner banner)
	{
	    return bannerMapper.updateBanner(banner);
	}

	/**
     * 删除轮播图对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteBannerByIds(String ids)
	{
		return bannerMapper.deleteBannerByIds(Convert.toStrArray(ids));
	}
	
}
