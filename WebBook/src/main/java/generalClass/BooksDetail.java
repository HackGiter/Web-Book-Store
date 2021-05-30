package generalClass;

import java.sql.Date;

public class BooksDetail {
    private String bdid;
    private String otitle;
    private String producer;
    private String publisher;
    private String translator;
    private Date date;
    private int pages;
    private String binding;
    private String isbn;

    public String getOtitle() {
        return otitle;
    }

    public void setOtitle(String otitle) {
        this.otitle = otitle;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }


    public String getBdid() {
        return bdid;
    }

    public void setBdid(String bdid) {
        this.bdid = bdid;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "BooksDetail{" +
                "bdid='" + bdid + '\'' +
                ", otitle='" + otitle + '\'' +
                ", producer='" + producer + '\'' +
                ", publisher='" + publisher + '\'' +
                ", translator='" + translator + '\'' +
                ", date=" + date +
                ", pages=" + pages +
                ", binding='" + binding + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
