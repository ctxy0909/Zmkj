package com.ruoyi.project.website.message.controller;

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
import com.ruoyi.project.website.message.domain.Message;
import com.ruoyi.project.website.message.service.IMessageService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;

/**
 * 用户留言 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-01-02
 */
@Controller
@RequestMapping("/website/message")
public class MessageController extends BaseController
{
    private String prefix = "website/message";
	
	@Autowired
	private IMessageService messageService;
	
	@RequiresPermissions("website:message:view")
	@GetMapping()
	public String message()
	{
	    return prefix + "/message";
	}
	
	/**
	 * 查询用户留言列表
	 */
	@RequiresPermissions("website:message:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Message message)
	{
		startPage();
        List<Message> list = messageService.selectMessageList(message);
		return getDataTable(list);
	}
	
	/**
	 * 新增用户留言
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存用户留言
	 */
	@RequiresPermissions("website:message:add")
	@Log(title = "用户留言", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Message message)
	{		
		return toAjax(messageService.insertMessage(message));
	}

	/**
	 * 修改用户留言
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Message message = messageService.selectMessageById(id);
		mmap.put("message", message);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存用户留言
	 */
	@RequiresPermissions("website:message:edit")
	@Log(title = "用户留言", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Message message)
	{		
		return toAjax(messageService.updateMessage(message));
	}
	
	/**
	 * 删除用户留言
	 */
	@RequiresPermissions("website:message:remove")
	@Log(title = "用户留言", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(messageService.deleteMessageByIds(ids));
	}
	
}
