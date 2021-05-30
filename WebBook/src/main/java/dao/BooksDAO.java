package dao;

import generalClass. Books;

import java.util.List;

public interface BooksDAO {
    String insertBooks(Books books)throws Exception;

    boolean updateBooks(Books books)throws Exception;

    List<Books> selectBooksByName(String name) throws Exception;

    List<Books> selectBooksByCategory(int category) throws Exception;

    List<Books> selectBooksByAuthor(String author) throws Exception;

    List<Books> getBooksList() throws Exception;

    Books selectBooksByBID(String bid) throws Exception;

    boolean deleteBooks(String bid) throws Exception;

    List<Books> searchBookLike(Books books) throws Exception;

    boolean resetBooks(String bid) throws Exception;

    List<Books> getBooksByBID(List<String> bid);

}
