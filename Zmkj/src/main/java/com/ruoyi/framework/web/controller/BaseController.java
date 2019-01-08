package com.ruoyi.framework.web.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditorSupport;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.framework.web.page.PageDomain;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.page.TableSupport;
import com.ruoyi.project.system.user.domain.User;
import java.lang.reflect.Method;

/**
 * web层通用数据处理
 * 
 * @author ruoyi
 */
public class BaseController
{
    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport()
        {
            @Override
            public void setAsText(String text)
            {
                setValue(DateUtils.parseDate(text));
            }
        });
    }

    /**
     * 设置请求分页数据
     */
    protected void startPage()
    {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize))
        {
            String orderBy = pageDomain.getOrderBy();
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }
    }

    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected TableDataInfo getDataTable(List<?> list)
    {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(0);
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }

    /**
     * 响应返回结果
     * 
     * @param rows 影响行数
     * @return 操作结果
     */
    protected AjaxResult toAjax(int rows)
    {
        return rows > 0 ? success() : error();
    }

    /**
     * 返回成功
     */
    public AjaxResult success()
    {
        return AjaxResult.success();
    }

    /**
     * 返回失败消息
     */
    public AjaxResult error()
    {
        return AjaxResult.error();
    }

    /**
     * 返回成功消息
     */
    public AjaxResult success(String message)
    {
        return AjaxResult.success(message);
    }

    /**
     * 返回失败消息
     */
    public AjaxResult error(String message)
    {
        return AjaxResult.error(message);
    }

    /**
     * 返回错误码消息
     */
    public AjaxResult error(int code, String message)
    {
        return AjaxResult.error(code, message);
    }

    /**
     * 页面跳转
     */
    public String redirect(String url)
    {
        return StringUtils.format("redirect:{}", url);
    }

    public User getSysUser()
    {
        return ShiroUtils.getSysUser();
    }

    public void setSysUser(User user)
    {
        ShiroUtils.setSysUser(user);
    }

    public Long getUserId()
    {
        return getSysUser().getUserId();
    }

    public String getLoginName()
    {
        return getSysUser().getLoginName();
    }
    
	protected Object foreachParmDataObj(Map<String, ?> parm, Class<?> entityClass) {
		BeanInfo beanInfo;
		Object obj = null;
		try {
			obj = entityClass.newInstance();
			beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				Method setter = property.getWriteMethod();
				if (setter != null) {
					Object value = parm.get(property.getName());
					if (value != null) {
						Object[] array = (Object[]) value;
						Object ob = array[0];
						String dataType = property.getReadMethod().getGenericReturnType().toString();
						if ("class java.lang.Long".equals(dataType) && !ob.equals("")) {
							setter.invoke(obj, new Long(ob.toString()));
							continue;
						}
						if ("class java.lang.Integer".equals(dataType) && !ob.equals("")) {
							setter.invoke(obj, new Integer(ob.toString()));
							continue;
						}
						if ("class java.lang.Float".equals(dataType) && !ob.equals("")) {
							setter.invoke(obj, new Float(ob.toString()));
							continue;
						}
						if ("class java.math.BigDecimal".equals(dataType) && !ob.equals("")) {
							setter.invoke(obj, new BigDecimal(ob.toString()));
							continue;
						}
						if (!ob.equals("") && !"null".equals(ob)) {
							setter.invoke(obj, ob);
						}
					}
				}
			}
		} catch (IntrospectionException e) {
			System.out.println("map转换对象get或者set方法没有找到");
		} catch (IllegalAccessException e) {
			System.out.println("map转换对象访问私有变量没有权限");
		} catch (IllegalArgumentException e) {
			System.out.println("map转换对象访数据异常");
		} catch (InvocationTargetException e) {
			System.out.println("map转换对象反射get或者set方法异常");
		} catch (InstantiationException e) {
			System.out.println("对象实例化失败");
		}
		return obj;
	}
    
}
