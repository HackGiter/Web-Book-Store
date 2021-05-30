package dao;

import generalClass.BooksDetail;

import java.util.List;

public interface BookDetailsDAO {
    String insertBooksDetail(BooksDetail booksDetail) throws Exception;
    BooksDetail selectBooksDetailByBDID(String bdid) throws Exception;
    List<BooksDetail> getBooksDetail() throws Exception;
    boolean updateBooksDetail(BooksDetail booksDetail) throws Exception;
}
