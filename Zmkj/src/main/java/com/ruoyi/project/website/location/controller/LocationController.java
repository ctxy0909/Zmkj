package com.ruoyi.project.website.location.controller;

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
import com.ruoyi.project.website.location.domain.Location;
import com.ruoyi.project.website.location.service.ILocationService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;

/**
 * 显示位置 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-01-02
 */
@Controller
@RequestMapping("/website/location")
public class LocationController extends BaseController
{
    private String prefix = "website/location";
	
	@Autowired
	private ILocationService locationService;
	
	@RequiresPermissions("website:location:view")
	@GetMapping()
	public String location()
	{
	    return prefix + "/location";
	}
	
	/**
	 * 查询显示位置列表
	 */
	@RequiresPermissions("website:location:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Location location)
	{
		startPage();
        List<Location> list = locationService.selectLocationList(location);
		return getDataTable(list);
	}
	
	/**
	 * 新增显示位置
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存显示位置
	 */
	@RequiresPermissions("website:location:add")
	@Log(title = "显示位置", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Location location)
	{		
		return toAjax(locationService.insertLocation(location));
	}

	/**
	 * 修改显示位置
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Location location = locationService.selectLocationById(id);
		mmap.put("locations", location);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存显示位置
	 */
	@RequiresPermissions("website:location:edit")
	@Log(title = "显示位置", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Location location)
	{		
		return toAjax(locationService.updateLocation(location));
	}
	
	/**
	 * 删除显示位置
	 */
	@RequiresPermissions("website:location:remove")
	@Log(title = "显示位置", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(locationService.deleteLocationByIds(ids));
	}
	
}
