package dao;

import generalClass.Series;

import java.util.List;

public interface SeriesDAO {
    public boolean insertSeries( Series series)throws Exception;

    public boolean updateSeries( Series series)throws Exception;

    public List< Series> selectSeriesByName(String name) throws Exception;

    public List< Series> selectSeriesByCategory(String category) throws Exception;

    public List< Series> selectSeriesByAuthor(String author) throws Exception;

    public List<Series> getSeriesLists() throws Exception;
}
