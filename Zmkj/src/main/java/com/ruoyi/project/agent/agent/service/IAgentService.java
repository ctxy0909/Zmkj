package com.ruoyi.project.agent.agent.service;

import com.ruoyi.project.agent.agent.domain.Agent;

import java.util.List;

/**
 * 代理商 服务层
 * 
 * @author ruoyi
 * @date 2019-01-07
 */
public interface IAgentService 
{
	/**
     * 查询代理商信息
     * 
     * @param id 代理商ID
     * @return 代理商信息
     */
	public Agent selectAgentById(Integer id);
	
	/**
     * 查询代理商列表
     * 
     * @param agent 代理商信息
     * @return 代理商集合
     */
	public List<Agent> selectAgentList(Agent agent);
	
	/**
     * 新增代理商
     * 
     * @param agent 代理商信息
     * @return 结果
     */
	public int insertAgent(Agent agent);
	
	/**
     * 修改代理商
     * 
     * @param agent 代理商信息
     * @return 结果
     */
	public int updateAgent(Agent agent);
		
	/**
     * 删除代理商信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteAgentByIds(String ids);
	
}
