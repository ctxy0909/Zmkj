package com.ruoyi.project.website.banner.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.website.banner.domain.Banner;
import com.ruoyi.project.website.banner.service.IBannerService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;

/**
 * 轮播图 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-01-02
 */
@Controller
@RequestMapping("/website/banner")
public class BannerController extends BaseController
{
    private String prefix = "website/banner";
	
	@Autowired
	private IBannerService bannerService;
	
	@RequiresPermissions("website:banner:view")
	@GetMapping()
	public String banner()
	{
	    return prefix + "/banner";
	}
	
	/**
	 * 查询轮播图列表
	 */
	@RequiresPermissions("website:banner:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Banner banner)
	{
		startPage();
        List<Banner> list = bannerService.selectBannerList(banner);
		return getDataTable(list);
	}
	
	/**
	 * 新增轮播图
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存轮播图
	 */
	@RequiresPermissions("website:banner:add")
	@Log(title = "轮播图", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Banner banner)
	{		
		return toAjax(bannerService.insertBanner(banner));
	}

	/**
	 * 修改轮播图
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Banner banner = bannerService.selectBannerById(id);
		mmap.put("banner", banner);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存轮播图
	 */
	@RequiresPermissions("website:banner:edit")
	@Log(title = "轮播图", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Banner banner)
	{		
		return toAjax(bannerService.updateBanner(banner));
	}
	
	/**
	 * 删除轮播图
	 */
	@RequiresPermissions("website:banner:remove")
	@Log(title = "轮播图", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(bannerService.deleteBannerByIds(ids));
	}
	
}
