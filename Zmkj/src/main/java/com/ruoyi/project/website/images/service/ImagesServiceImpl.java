package com.ruoyi.project.website.images.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.website.images.mapper.ImagesMapper;
import com.ruoyi.project.website.images.domain.Images;
import com.ruoyi.project.website.images.service.IImagesService;
import com.ruoyi.project.website.location.domain.Location;
import com.ruoyi.project.website.location.mapper.LocationMapper;
import com.ruoyi.common.support.Convert;

/**
 * 图片 服务层实现
 * 
 * @author ruoyi
 * @date 2019-01-02
 */
@Service
public class ImagesServiceImpl implements IImagesService 
{
	@Autowired
	private ImagesMapper imagesMapper;
	@Autowired
	private LocationMapper locationMapper;

	/**
     * 查询图片信息
     * 
     * @param id 图片ID
     * @return 图片信息
     */
    @Override
	public Images selectImagesById(Integer id)
	{
	    return imagesMapper.selectImagesById(id);
	}
	
	/**
     * 查询图片列表
     * 
     * @param images 图片信息
     * @return 图片集合
     */
	@Override
	public List<Images> selectImagesList(Images images)
	{	
		
		List<Images> imagesList = imagesMapper.selectImagesList(images);
		List<Location> loaction = locationMapper.selectLocationAll();
		for(int i=0;i<imagesList.size();i++) {
			imagesList.get(i).setStatus(imagesList.get(i).getIsShow()==0?"显示":"隐藏");
			for (int j = 0; j < loaction.size(); j++) {
				if(imagesList.get(i).getLocationid() == loaction.get(j).getId()) {
					imagesList.get(i).setLocationName(loaction.get(j).getLocation());
				}
			}
		}
	    return imagesList;
	}
	
    /**
     * 新增图片
     * 
     * @param images 图片信息
     * @return 结果
     */
	@Override
	public int insertImages(Images images)
	{
	    return imagesMapper.insertImages(images);
	}
	
	/**
     * 修改图片
     * 
     * @param images 图片信息
     * @return 结果
     */
	@Override
	public int updateImages(Images images)
	{
	    return imagesMapper.updateImages(images);
	}

	/**
     * 删除图片对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteImagesByIds(String ids)
	{
		return imagesMapper.deleteImagesByIds(Convert.toStrArray(ids));
	}
	
}
