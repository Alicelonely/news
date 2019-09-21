package cn.zk.biz;

import cn.zk.entity.Summary;

import java.util.List;

public interface ISummaryService {

    List<Summary> getAllTopic();

    List<Summary> getNewsByPage(String title,int pageSize,int pageNum);
}
