package com.ruoyi.project.website.images.controller;

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
import com.ruoyi.project.website.images.domain.Images;
import com.ruoyi.project.website.images.service.IImagesService;
import com.ruoyi.project.website.location.service.ILocationService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;

/**
 * 图片 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-01-02
 */
@Controller
@RequestMapping("/website/images")
public class ImagesController extends BaseController
{
    private String prefix = "website/images";
	
	@Autowired
	private IImagesService imagesService;
	@Autowired
	private ILocationService locationService;
	
	@RequiresPermissions("website:images:view")
	@GetMapping()
	public String images()
	{
	    return prefix + "/images";
	}
	
	/**
	 * 查询图片列表
	 */
	@RequiresPermissions("website:images:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Images images)
	{
		startPage();
        List<Images> list = imagesService.selectImagesList(images);
		return getDataTable(list);
	}
	
	/**
	 * 新增图片
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{	
		mmap.put("locations", locationService.selectLocationAll());
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存图片
	 */
	@RequiresPermissions("website:images:add")
	@Log(title = "图片", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Images images)
	{		
		return toAjax(imagesService.insertImages(images));
	}

	/**
	 * 修改图片
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Images images = imagesService.selectImagesById(id);
		mmap.put("images", images);
		mmap.put("locations", locationService.selectLocationByImagesId(id));
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存图片
	 */
	@RequiresPermissions("website:images:edit")
	@Log(title = "图片", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Images images)
	{		
		return toAjax(imagesService.updateImages(images));
	}
	
	/**
	 * 删除图片
	 */
	@RequiresPermissions("website:images:remove")
	@Log(title = "图片", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(imagesService.deleteImagesByIds(ids));
	}
	
}
