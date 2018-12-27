package com.ruoyi.project.system.test.service;

import java.util.List;

import com.ruoyi.project.system.test.domain.Test;
import com.ruoyi.project.system.test.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.support.Convert;

/**
 * 测试 服务层实现
 * 
 * @author ruoyi
 * @date 2018-12-26
 */
@Service
public class TestServiceImpl implements ITestService 
{
	@Autowired
	private TestMapper testMapper;

	/**
     * 查询测试信息
     * 
     * @param testId 测试ID
     * @return 测试信息
     */
    @Override
	public Test selectTestById(Integer testId)
	{
	    return testMapper.selectTestById(testId);
	}
	
	/**
     * 查询测试列表
     * 
     * @param test 测试信息
     * @return 测试集合
     */
	@Override
	public List<Test> selectTestList(Test test)
	{
	    return testMapper.selectTestList(test);
	}
	
    /**
     * 新增测试
     * 
     * @param test 测试信息
     * @return 结果
     */
	@Override
	public int insertTest(Test test)
	{
	    return testMapper.insertTest(test);
	}
	
	/**
     * 修改测试
     * 
     * @param test 测试信息
     * @return 结果
     */
	@Override
	public int updateTest(Test test)
	{
	    return testMapper.updateTest(test);
	}

	/**
     * 删除测试对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTestByIds(String ids)
	{
		return testMapper.deleteTestByIds(Convert.toStrArray(ids));
	}
	
}
