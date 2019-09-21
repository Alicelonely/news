package cn.zk.dao;

import cn.zk.entity.Board;
import cn.zk.entity.Summary;

import java.util.List;

public interface IBoardDao {
    List<Board> getAllBoard();

    boolean setBoard(String bName);

    boolean checkBoard(Board board);

    List<Summary> totalBoard();

    boolean delBoard(int bId);

    int getAllUserCount();

    List<Board> getUserByPage(int PageIndex, int PageSize);

    List<Board> getUserByPageAndLike(int PageIndex, int PageSize,String context);
}
