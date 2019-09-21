package cn.zk.biz;

import cn.zk.entity.Board;

import java.util.List;

public interface IBoardService {
    List<Board> getAllBoard();

    boolean checkBoard(int id, String bName);

    boolean setBoard(String bName);



    boolean delBoard(int bId);

    int getAllUserCount();

    List<Board> getUserByPage(int PageIndex, int PageSize);

    List<Board> getUserByPageAndLike(int PageIndex, int PageSize,String context);
}
