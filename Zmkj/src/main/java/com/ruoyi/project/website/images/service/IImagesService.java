package com.ruoyi.project.website.images.service;

import com.ruoyi.project.website.images.domain.Images;
import java.util.List;

/**
 * 图片 服务层
 * 
 * @author ruoyi
 * @date 2019-01-02
 */
public interface IImagesService 
{
	/**
     * 查询图片信息
     * 
     * @param id 图片ID
     * @return 图片信息
     */
	public Images selectImagesById(Integer id);
	
	/**
     * 查询图片列表
     * 
     * @param images 图片信息
     * @return 图片集合
     */
	public List<Images> selectImagesList(Images images);
	
	/**
     * 新增图片
     * 
     * @param images 图片信息
     * @return 结果
     */
	public int insertImages(Images images);
	
	/**
     * 修改图片
     * 
     * @param images 图片信息
     * @return 结果
     */
	public int updateImages(Images images);
		
	/**
     * 删除图片信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteImagesByIds(String ids);
	
}
