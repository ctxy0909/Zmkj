package com.ruoyi.project.website.message.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.website.message.mapper.MessageMapper;
import com.ruoyi.project.website.message.domain.Message;
import com.ruoyi.project.website.message.service.IMessageService;
import com.ruoyi.common.support.Convert;

/**
 * 用户留言 服务层实现
 * 
 * @author ruoyi
 * @date 2019-01-02
 */
@Service
public class MessageServiceImpl implements IMessageService 
{
	@Autowired
	private MessageMapper messageMapper;

	/**
     * 查询用户留言信息
     * 
     * @param id 用户留言ID
     * @return 用户留言信息
     */
    @Override
	public Message selectMessageById(Integer id)
	{
	    return messageMapper.selectMessageById(id);
	}
	
	/**
     * 查询用户留言列表
     * 
     * @param message 用户留言信息
     * @return 用户留言集合
     */
	@Override
	public List<Message> selectMessageList(Message message)
	{
	    return messageMapper.selectMessageList(message);
	}
	
    /**
     * 新增用户留言
     * 
     * @param message 用户留言信息
     * @return 结果
     */
	@Override
	public int insertMessage(Message message)
	{
	    return messageMapper.insertMessage(message);
	}
	
	/**
     * 修改用户留言
     * 
     * @param message 用户留言信息
     * @return 结果
     */
	@Override
	public int updateMessage(Message message)
	{
	    return messageMapper.updateMessage(message);
	}

	/**
     * 删除用户留言对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMessageByIds(String ids)
	{
		return messageMapper.deleteMessageByIds(Convert.toStrArray(ids));
	}
	
}
