package cn.zk.util;

/**
 * 分页工具类
 */
public class PageUtil {

    public static final int PAGE_SIZE = 5;     //每页显示的条数


    /**
     * 计算出总页数
     *
     * @param count
     * @param pageSize
     * @return
     */
    public static int getTotalPages(int count, int pageSize) {
        return count % pageSize == 0 ? count / pageSize : ((count / pageSize) + 1);
    }

}