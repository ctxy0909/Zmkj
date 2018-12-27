package com.ruoyi.project.system.test.mapper;

import com.ruoyi.project.system.test.domain.Test;

import java.util.List;

/**
 * 测试 数据层
 * 
 * @author ruoyi
 * @date 2018-12-26
 */
public interface TestMapper 
{
	/**
     * 查询测试信息
     * 
     * @param testId 测试ID
     * @return 测试信息
     */
	public Test selectTestById(Integer testId);
	
	/**
     * 查询测试列表
     * 
     * @param test 测试信息
     * @return 测试集合
     */
	public List<Test> selectTestList(Test test);
	
	/**
     * 新增测试
     * 
     * @param test 测试信息
     * @return 结果
     */
	public int insertTest(Test test);
	
	/**
     * 修改测试
     * 
     * @param test 测试信息
     * @return 结果
     */
	public int updateTest(Test test);
	
	/**
     * 删除测试
     * 
     * @param testId 测试ID
     * @return 结果
     */
	public int deleteTestById(Integer testId);
	
	/**
     * 批量删除测试
     * 
     * @param testIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTestByIds(String[] testIds);
	
}