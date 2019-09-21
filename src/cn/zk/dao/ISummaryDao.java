package cn.zk.dao;

import cn.zk.entity.Summary;

import java.util.List;

public interface ISummaryDao {
    List<Summary> getAllTopic();

    List<Summary> getNewsByPage(String title,int pageSize,int pageNum);
}
