package com.ruoyi.project.website.text.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.website.text.mapper.TextMapper;
import com.ruoyi.project.website.location.domain.Location;
import com.ruoyi.project.website.location.mapper.LocationMapper;
import com.ruoyi.project.website.text.domain.Text;
import com.ruoyi.project.website.text.service.ITextService;
import com.ruoyi.common.support.Convert;

/**
 * 文章介绍 服务层实现
 * 
 * @author ruoyi
 * @date 2019-01-02
 */
@Service
public class TextServiceImpl implements ITextService 
{
	@Autowired
	private TextMapper textMapper;
	@Autowired
	private LocationMapper locationMapper;

	/**
     * 查询文章介绍信息
     * 
     * @param id 文章介绍ID
     * @return 文章介绍信息
     */
    @Override
	public Text selectTextById(Integer id)
	{
	    return textMapper.selectTextById(id);
	}
	
	/**
     * 查询文章介绍列表
     * 
     * @param text 文章介绍信息
     * @return 文章介绍集合
     */
	@Override
	public List<Text> selectTextList(Text text)
	{
		List<Text> textList = textMapper.selectTextList(text);
		List<Location> location = locationMapper.selectLocationAll();
		if (textList != null && textList.size()>0) {
			for (int i = 0; i < textList.size(); i++) {
				for (int j = 0; j < location.size(); j++) {
					if(textList.get(i).getLocationid() == location.get(j).getId()) {
						textList.get(i).setLocationName(location.get(j).getLocation());
					}
				}
			}
		}
	    return textList;
	}
	
    /**
     * 新增文章介绍
     * 
     * @param text 文章介绍信息
     * @return 结果
     */
	@Override
	public int insertText(Text text)
	{
	    return textMapper.insertText(text);
	}
	
	/**
     * 修改文章介绍
     * 
     * @param text 文章介绍信息
     * @return 结果
     */
	@Override
	public int updateText(Text text)
	{
	    return textMapper.updateText(text);
	}

	/**
     * 删除文章介绍对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTextByIds(String ids)
	{
		return textMapper.deleteTextByIds(Convert.toStrArray(ids));
	}
	
}
