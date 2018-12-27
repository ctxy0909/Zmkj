package com.ruoyi.project.system.test.controller;

import java.util.List;

import com.ruoyi.project.system.test.domain.Test;
import com.ruoyi.project.system.test.service.ITestService;
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
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;

/**
 * 测试 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-12-26
 */
@Controller
@RequestMapping("/system/test")
public class TestController extends BaseController
{
    private String prefix = "system/test";
	
	@Autowired
	private ITestService testService;
	
	@RequiresPermissions("system:test:view")
	@GetMapping()
	public String test()
	{
	    return prefix + "/test";
	}
	
	/**
	 * 查询测试列表
	 */
	@RequiresPermissions("system:test:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Test test)
	{
		startPage();
        List<Test> list = testService.selectTestList(test);
		return getDataTable(list);
	}
	
	/**
	 * 新增测试
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存测试
	 */
	@RequiresPermissions("system:test:add")
	@Log(title = "测试", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Test test)
	{		
		return toAjax(testService.insertTest(test));
	}

	/**
	 * 修改测试
	 */
	@GetMapping("/edit/{testId}")
	public String edit(@PathVariable("testId") Integer testId, ModelMap mmap)
	{
		Test test = testService.selectTestById(testId);
		mmap.put("test", test);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存测试
	 */
	@RequiresPermissions("system:test:edit")
	@Log(title = "测试", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Test test)
	{		
		return toAjax(testService.updateTest(test));
	}
	
	/**
	 * 删除测试
	 */
	@RequiresPermissions("system:test:remove")
	@Log(title = "测试", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(testService.deleteTestByIds(ids));
	}
	
}
