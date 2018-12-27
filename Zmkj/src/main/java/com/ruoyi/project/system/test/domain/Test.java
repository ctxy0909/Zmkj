package com.ruoyi.project.system.test.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 测试表 sys_test
 * 
 * @author ruoyi
 * @date 2018-12-26
 */
public class Test extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 测试id */
	private Integer testId;
	/** 测试名称 */
	private String testName;

	public void setTestId(Integer testId) 
	{
		this.testId = testId;
	}

	public Integer getTestId() 
	{
		return testId;
	}
	public void setTestName(String testName) 
	{
		this.testName = testName;
	}

	public String getTestName() 
	{
		return testName;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("testId", getTestId())
            .append("testName", getTestName())
            .toString();
    }
}
