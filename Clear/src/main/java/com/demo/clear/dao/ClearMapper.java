package com.demo.clear.dao;

import com.demo.domain.ClearLogDTO;
import org.apache.ibatis.annotations.*;
import java.util.List;

public interface ClearMapper {
    @Select("SELECT * FROM tclearlog ORDER BY timestamp DESC LIMIT 1")
    ClearLogDTO selectLatestLog();
}
