package impl;

import dao.SeriesDAO;
import generalClass.Series;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SeriesDAOImpl implements SeriesDAO {

    private JdbcTemplate jdbcTemplate = null;

    public SeriesDAOImpl(JdbcTemplate jdbcTemplate) {// 设置数据库连接
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean insertSeries(Series series) throws Exception {
        // TODO Auto-generated method stub
        String sql = "INSERT INTO series VALUES(replace(uuid(), '-', ''),?,?,?)";
        Object[] params = new Object[]{
                series.getAuthor(),
                series.getName(),
                String.valueOf(series.getCategory()),
                series.getNumber()
        };

        return this.jdbcTemplate.update(sql, params) >= 1;
    }

    @Override
    public boolean updateSeries(Series series) throws Exception {
        // TODO Auto-generated method stub
        String sql = "UPDATE book SET Author=?, Name=?, Category=?, Age=? WHERE SID=?";
        Object[] params = new Object[]{
                series.getAuthor(),
                series.getName(),
                String.valueOf(series.getCategory()),
                series.getNumber(),
                series.getSid()
        };

        return this.jdbcTemplate.update(sql, params) >= 1;
    }

    @Override
    public List<Series> selectSeriesByName(String name) throws Exception {
        String sql = "SELECT * FROM series WHERE name=?";
        Object[] params = new Object[] {name};
        List<Series> seriesList = this.jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Series.class));
        return seriesList;
    }

    @Override
    public List<Series> selectSeriesByCategory(String category) throws Exception {
        String sql = "SELECT * FROM series WHERE category=?";
        Object[] params = new Object[] {category};
        List<Series> seriesList = this.jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Series.class));
        return seriesList;
    }

    @Override
    public List<Series> selectSeriesByAuthor(String author) throws Exception {
        String sql = "SELECT * FROM series WHERE author=?";
        Object[] params = new Object[] {author};
        return this.jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Series.class));
    }

    @Override
    public List<Series> getSeriesLists() throws Exception {
        String sql = "SELECT * FROM series";
        return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Series.class));
    }

}
