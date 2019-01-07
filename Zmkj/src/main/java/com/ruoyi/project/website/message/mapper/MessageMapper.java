package com.ruoyi.project.website.message.mapper;

import com.ruoyi.project.website.message.domain.Message;
import java.util.List;	

/**
 * 用户留言 数据层
 * 
 * @author ruoyi
 * @date 2019-01-02
 */
public interface MessageMapper 
{
	/**
     * 查询用户留言信息
     * 
     * @param id 用户留言ID
     * @return 用户留言信息
     */
	public Message selectMessageById(Integer id);
	
	/**
     * 查询用户留言列表
     * 
     * @param message 用户留言信息
     * @return 用户留言集合
     */
	public List<Message> selectMessageList(Message message);
	
	/**
     * 新增用户留言
     * 
     * @param message 用户留言信息
     * @return 结果
     */
	public int insertMessage(Message message);
	
	/**
     * 修改用户留言
     * 
     * @param message 用户留言信息
     * @return 结果
     */
	public int updateMessage(Message message);
	
	/**
     * 删除用户留言
     * 
     * @param id 用户留言ID
     * @return 结果
     */
	public int deleteMessageById(Integer id);
	
	/**
     * 批量删除用户留言
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMessageByIds(String[] ids);
	
}