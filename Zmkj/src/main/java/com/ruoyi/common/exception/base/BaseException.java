package com.ruoyi.common.exception.base;

import org.springframework.util.StringUtils;
import com.ruoyi.common.utils.MessageUtils;

/**
 * 基础异常
 * 
 * @author ruoyi
 */
public class BaseException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    /**
     * 所属模块
     */
    private String agent;

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误码对应的参数
     */
    private Object[] args;

    /**
     * 错误消息
     */
    private String defaultMessage;

    public BaseException(String agent, String code, Object[] args, String defaultMessage)
    {
        this.agent = agent;
        this.code = code;
        this.args = args;
        this.defaultMessage = defaultMessage;
    }

    public BaseException(String agent, String code, Object[] args)
    {
        this(agent, code, args, null);
    }

    public BaseException(String agent, String defaultMessage)
    {
        this(agent, null, null, defaultMessage);
    }

    public BaseException(String code, Object[] args)
    {
        this(null, code, args, null);
    }

    public BaseException(String defaultMessage)
    {
        this(null, null, null, defaultMessage);
    }

    @Override
    public String getMessage()
    {
        String message = null;
        if (!StringUtils.isEmpty(code))
        {
            message = MessageUtils.message(code, args);
        }
        if (message == null)
        {
            message = defaultMessage;
        }
        return message;
    }

    public String getagent()
    {
        return agent;
    }

    public String getCode()
    {
        return code;
    }

    public Object[] getArgs()
    {
        return args;
    }

    public String getDefaultMessage()
    {
        return defaultMessage;
    }

    @Override
    public String toString()
    {
        return this.getClass() + "{" + "agent='" + agent + '\'' + ", message='" + getMessage() + '\'' + '}';
    }
}
