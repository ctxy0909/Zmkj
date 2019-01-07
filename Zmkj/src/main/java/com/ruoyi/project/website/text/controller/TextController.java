package com.ruoyi.project.website.text.controller;

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
import com.ruoyi.project.website.location.service.ILocationService;
import com.ruoyi.project.website.text.domain.Text;
import com.ruoyi.project.website.text.service.ITextService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;

/**
 * 文章介绍 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-01-02
 */
@Controller
@RequestMapping("/website/text")
public class TextController extends BaseController
{
    private String prefix = "website/text";
	
	@Autowired
	private ITextService textService;
	@Autowired
	private ILocationService locationService;
	
	@RequiresPermissions("website:text:view")
	@GetMapping()
	public String text()
	{
	    return prefix + "/text";
	}
	
	/**
	 * 查询文章介绍列表
	 */
	@RequiresPermissions("website:text:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Text text)
	{
		startPage();
        List<Text> list = textService.selectTextList(text);
		return getDataTable(list);
	}
	
	/**
	 * 新增文章介绍
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		mmap.put("locations", locationService.selectLocationAll());
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存文章介绍
	 */
	@RequiresPermissions("website:text:add")
	@Log(title = "文章介绍", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Text text)
	{		
		return toAjax(textService.insertText(text));
	}

	/**
	 * 修改文章介绍
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Text text = textService.selectTextById(id);
		mmap.put("text", text);
		mmap.put("locations", locationService.selectLocationByTextId(id));
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存文章介绍
	 */
	@RequiresPermissions("website:text:edit")
	@Log(title = "文章介绍", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Text text)
	{		
		return toAjax(textService.updateText(text));
	}
	
	/**
	 * 删除文章介绍
	 */
	@RequiresPermissions("website:text:remove")
	@Log(title = "文章介绍", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(textService.deleteTextByIds(ids));
	}
	
}
