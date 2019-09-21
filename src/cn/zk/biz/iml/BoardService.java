package cn.zk.biz.iml;

import cn.zk.biz.IBoardService;
import cn.zk.dao.IBoardDao;
import cn.zk.dao.iml.BoardDao;
import cn.zk.entity.Board;
import cn.zk.entity.Summary;

import java.util.List;
import java.util.Scanner;

public class BoardService implements cn.zk.biz.IBoardService {

    IBoardDao boardDao = new BoardDao();
    Scanner scanner = new Scanner(System.in);

    /**
     * 显示模块
     */
    @Override
    public List<Board> getAllBoard() {
        List<Board> ls = boardDao.getAllBoard();

        return ls;
    }

    /**
     * 更改板块
     */
    @Override
    public boolean checkBoard(int id, String bName) {
        Board board = new Board(id, bName);
        boolean result = boardDao.checkBoard(board);
        return result;
    }


    /**
     * 创建板块
     */
    @Override
    public boolean setBoard(String bName) {
        boolean result = boardDao.setBoard(bName);
        return result;
    }



    /**
     * 删除板块
     */
    @Override
    public boolean delBoard(int bId) {
        return boardDao.delBoard(bId);
    }


    /**
     * 查询用户总条数
     *
     * @return
     */
    @Override
    public int getAllUserCount() {
        return boardDao.getAllUserCount();
    }



    /**
     * 分页查询
     *
     * @param PageIndex 当前页
     * @param PageSize  每页的条数
     * @return
     */
    @Override
    public List<Board> getUserByPage(int PageIndex, int PageSize){
        return boardDao.getUserByPage(PageIndex,PageSize);
    }

    @Override
    public List<Board> getUserByPageAndLike(int PageIndex, int PageSize, String context) {
        return boardDao.getUserByPageAndLike(PageIndex,PageSize,context);
    }

}
