package generalClass;

import org.springframework.web.multipart.MultipartFile;

public class AllBPB {
    private Books books;
    private Products products;
    private BooksDetail booksDetail;
    private MultipartFile imgFile;

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public BooksDetail getBooksDetail() {
        return booksDetail;
    }

    public void setBooksDetail(BooksDetail booksDetail) {
        this.booksDetail = booksDetail;
    }

    public MultipartFile getImgFile() {
        return imgFile;
    }

    public void setImgFile(MultipartFile imgFile) {
        this.imgFile = imgFile;
    }

    @Override
    public String toString() {
        return "AllBPB{" +
                "books=" + books +
                ", products=" + products +
                ", booksDetail=" + booksDetail +
                ", imgFile=" + imgFile +
                '}';
    }
}
