package com.jeeqb.zblog.mapper;

import com.jeeqb.zblog.vo.LogInfo;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper {
    /**
     * 保存日志信息
     * @param log
     */
    void save(LogInfo log);
}
