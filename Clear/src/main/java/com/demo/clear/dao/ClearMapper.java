package com.demo.clear.dao;

import com.demo.domain.ClearLogDTO;
import org.apache.ibatis.annotations.*;
import java.util.List;

public interface ClearMapper {
    @Select("SELECT * FROM tclearlog ORDER BY timestamp DESC LIMIT 1")
    ClearLogDTO selectLatestLog();

    //清算
    @Insert("INSERT INTO tclearlog (log_type, log_content, timestamp) VALUES (#{logType}, #{logContent},  NOW())")
    void insertLog(ClearLogDTO log);

    //8位时间查询
    @Select("SELECT log_type AS logtype, log_content AS logcontent, timestamp AS timestamp " +
            "FROM tclearlog " +
            "WHERE CAST(timestamp AS CHAR) LIKE #{timestamp}")
    List<ClearLogDTO> selectLogsByPattern(@Param("timestamp") String pattern);

}
