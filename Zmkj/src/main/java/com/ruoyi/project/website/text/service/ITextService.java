package com.ruoyi.project.website.text.service;

import com.ruoyi.project.website.text.domain.Text;
import java.util.List;

/**
 * 文章介绍 服务层
 * 
 * @author ruoyi
 * @date 2019-01-02
 */
public interface ITextService 
{
	/**
     * 查询文章介绍信息
     * 
     * @param id 文章介绍ID
     * @return 文章介绍信息
     */
	public Text selectTextById(Integer id);
	
	/**
     * 查询文章介绍列表
     * 
     * @param text 文章介绍信息
     * @return 文章介绍集合
     */
	public List<Text> selectTextList(Text text);
	
	/**
     * 新增文章介绍
     * 
     * @param text 文章介绍信息
     * @return 结果
     */
	public int insertText(Text text);
	
	/**
     * 修改文章介绍
     * 
     * @param text 文章介绍信息
     * @return 结果
     */
	public int updateText(Text text);
		
	/**
     * 删除文章介绍信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTextByIds(String ids);
	
}
