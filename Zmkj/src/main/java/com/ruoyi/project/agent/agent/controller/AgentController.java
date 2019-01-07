package com.ruoyi.project.agent.agent.controller;

import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.agent.agent.domain.Agent;
import com.ruoyi.project.agent.agent.service.IAgentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 代理商 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-01-07
 */
@Controller
@RequestMapping("/module/agent")
public class AgentController extends BaseController
{
    private String prefix = "module/agent";
	
	@Autowired
	private IAgentService agentService;
	
	@RequiresPermissions("module:agent:view")
	@GetMapping()
	public String agent()
	{
	    return prefix + "/agent";
	}
	
	/**
	 * 查询代理商列表
	 */
	@RequiresPermissions("module:agent:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Agent agent)
	{
		startPage();
        List<Agent> list = agentService.selectAgentList(agent);
		return getDataTable(list);
	}
	
	/**
	 * 新增代理商
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存代理商
	 */
	@RequiresPermissions("module:agent:add")
	@Log(title = "代理商", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Agent agent)
	{		
		return toAjax(agentService.insertAgent(agent));
	}

	/**
	 * 修改代理商
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Agent agent = agentService.selectAgentById(id);
		mmap.put("agent", agent);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存代理商
	 */
	@RequiresPermissions("module:agent:edit")
	@Log(title = "代理商", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Agent agent)
	{		
		return toAjax(agentService.updateAgent(agent));
	}
	
	/**
	 * 删除代理商
	 */
	@RequiresPermissions("module:agent:remove")
	@Log(title = "代理商", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(agentService.deleteAgentByIds(ids));
	}
	
}
