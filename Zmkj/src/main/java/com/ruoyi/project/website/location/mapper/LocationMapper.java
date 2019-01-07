package com.ruoyi.project.website.location.mapper;

import com.ruoyi.project.website.location.domain.Location;
import java.util.List;	

/**
 * 显示位置 数据层
 * 
 * @author ruoyi
 * @date 2019-01-02
 */
public interface LocationMapper 
{
	/**
     * 查询显示位置信息
     * 
     * @param id 显示位置ID
     * @return 显示位置信息
     */
	public Location selectLocationById(Integer id);
	
	/**
     * 查询显示位置列表
     * 
     * @param location 显示位置信息
     * @return 显示位置集合
     */
	public List<Location> selectLocationList(Location location);
	
	/**
     * 新增显示位置
     * 
     * @param location 显示位置信息
     * @return 结果
     */
	public int insertLocation(Location location);
	
	/**
     * 修改显示位置
     * 
     * @param location 显示位置信息
     * @return 结果
     */
	public int updateLocation(Location location);
	
	/**
     * 删除显示位置
     * 
     * @param id 显示位置ID
     * @return 结果
     */
	public int deleteLocationById(Integer id);
	
	/**
     * 批量删除显示位置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteLocationByIds(String[] ids);
	
	/**
	 * 查询所有位置信息
	 * 
	 * @return 结果
	 */
	public List<Location> selectLocationAll();
	
}