package com.ruoyi.project.website.location.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.website.location.mapper.LocationMapper;
import com.ruoyi.project.website.images.domain.Images;
import com.ruoyi.project.website.images.mapper.ImagesMapper;
import com.ruoyi.project.website.location.domain.Location;
import com.ruoyi.project.website.location.service.ILocationService;
import com.ruoyi.project.website.text.domain.Text;
import com.ruoyi.project.website.text.mapper.TextMapper;
import com.ruoyi.common.support.Convert;

/**
 * 显示位置 服务层实现
 * 
 * @author ruoyi
 * @date 2019-01-02
 */
@Service
public class LocationServiceImpl implements ILocationService 
{
	@Autowired
	private LocationMapper locationMapper;
	@Autowired
	private ImagesMapper imagesMapper;
	@Autowired
	private TextMapper textMapper;

	/**
     * 查询显示位置信息
     * 
     * @param id 显示位置ID
     * @return 显示位置信息
     */
    @Override
	public Location selectLocationById(Integer id)
	{
	    return locationMapper.selectLocationById(id);
	}
	
	/**
     * 查询显示位置列表
     * 
     * @param location 显示位置信息
     * @return 显示位置集合
     */
	@Override
	public List<Location> selectLocationList(Location location)
	{
	    return locationMapper.selectLocationList(location);
	}
	
    /**
     * 新增显示位置
     * 
     * @param location 显示位置信息
     * @return 结果
     */
	@Override
	public int insertLocation(Location location)
	{
	    return locationMapper.insertLocation(location);
	}
	
	/**
     * 修改显示位置
     * 
     * @param location 显示位置信息
     * @return 结果
     */
	@Override
	public int updateLocation(Location location)
	{
	    return locationMapper.updateLocation(location);
	}

	/**
     * 删除显示位置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteLocationByIds(String ids)
	{
		return locationMapper.deleteLocationByIds(Convert.toStrArray(ids));
	}
	
	/**
	 * 查询所有位置信息
	 */
	@Override
	public List<Location> selectLocationAll() 
	{	
		return locationMapper.selectLocationAll();
	}

	@Override
	public List<Location> selectLocationByImagesId(Integer id) {
		Images selectImagesById = imagesMapper.selectImagesById(id);
		List<Location> selectLocationAll = this.selectLocationAll();
		if (selectLocationAll != null && selectLocationAll.size()>0 ) {
			for (int i = 0; i < selectLocationAll.size(); i++) {
				if(selectLocationAll.get(i).getId() == selectImagesById.getLocationid()) {
					selectLocationAll.get(i).setFlag(true);
				}
			}
		}
		return selectLocationAll;
	}

	@Override
	public List<Location> selectLocationByTextId(Integer id) {
		Text text = textMapper.selectTextById(id);
		List<Location> location = this.selectLocationAll();
		if(location != null && location.size()>0) {
			for (int i = 0; i < location.size(); i++) {
				if(location.get(i).getId() == text.getLocationid()) {
					location.get(i).setFlag(true);
				}
			}
		}
		return location;
	}
	
}
