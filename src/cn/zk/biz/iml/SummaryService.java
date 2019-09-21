package cn.zk.biz.iml;

import cn.zk.biz.ISummaryService;
import cn.zk.dao.ISummaryDao;
import cn.zk.dao.iml.SummaryDao;
import cn.zk.entity.Summary;

import java.util.List;
import java.util.Scanner;

public class SummaryService implements ISummaryService {

    ISummaryDao ISummaryDao = new SummaryDao();

    /**
     * 获取所有的汇总信息
     * @return
     */
    @Override
    public List<Summary> getAllTopic() {
        List<Summary> ls = ISummaryDao.getAllTopic();
       return ls;
    }

    @Override
    public List<Summary> getNewsByPage(String title, int pageSize, int pageNum) {
        return ISummaryDao.getNewsByPage(title,pageSize,pageNum);
    }


}
