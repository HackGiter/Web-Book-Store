package impl;

import java.util.List;

import generalClass.Books;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import dao.productsDAO;
import generalClass.Managers;
import generalClass.Products;

public class ProductsDAOImpl implements productsDAO {

	private JdbcTemplate jdbcTemplate = null;

	public ProductsDAOImpl(JdbcTemplate jdbcTemplate) {// 设置数据库连接
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public boolean insertProducts(Products products){
		// TODO Auto-generated method stub
		String sql = "INSERT INTO product(BID, PName, Type, Price, Number, SAID, Address, Sale) VALUES(?,?,?,?,?,?,?,?)";
		Object[] params = new Object[]{
				products.getBid(),
				products.getPName(),
				String.valueOf(products.getType()),
				products.getPrice(),
				products.getNumber(),
				products.getSaid(),
				products.getAddress(),
				products.getSale()
		};
		return this.jdbcTemplate.update(sql, params) >= 1;
	}

	@Override
	public boolean updateProducts(Products products){
		// TODO Auto-generated method stub
		String sql = "UPDATE product SET BID=?, PName=?, Type=?, Price=?, Number=?, Address=?, Sale=? WHERE PID=?";
		Object[] params = new Object[]{
				products.getBid(),
				products.getPName(),
				String.valueOf(products.getType()),
				products.getPrice(),
				products.getNumber(),
				products.getAddress(),
				products.getSale(),
				products.getPid()
		};
		return this.jdbcTemplate.update(sql, params) >= 1;
	}

	@Override
	public List<Products> selectProductsByName(String name){
		String sql = "SELECT * FROM product WHERE name=?";
		Object[] params = new Object[] {name};
		List<Products> productsList = this.jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Products.class));
		return productsList;
	}

	@Override
	public List<Products> selectProductsByCategory(String category){
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM product WHERE Type=?";
		Object[] params = new Object[] {category};
		List<Products> productsList = this.jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Products.class));
		return productsList;
	}

	@Override
	public Products selectProductsByBID(String bid){
		String sql = "SELECT * FROM product WHERE BID=?";
		Object[] params = new Object[] {bid};
		return this.jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(Products.class));
	}

	@Override
	public List<Products> selectProductsList(){
		String sql = "SELECT * FROM product";
		List<Products> productsList = this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Products.class));
		return productsList;
	}

	@Override
	public Products selectProductsByPID(String pid){
		String sql = "SELECT * FROM product WHERE PID=?";
		return this.jdbcTemplate.queryForObject(sql, new Object[] {pid}, new BeanPropertyRowMapper<>(Products.class));
	}

	@Override
	public boolean updateProductsNumber(String pid, int number){
		String sql = "UPDATE product SET Number=? WHERE PID=?";
		Object[] params = new Object[] {number, pid};
		return this.jdbcTemplate.update(sql, params) >=1;
	}

	@Override
	public boolean updateProductsSale(String pid, int number) {
		String sql = "UPDATE product SET Sale=? WHERE PID=?";
		Object[] params = new Object[] {number, pid};
		return this.jdbcTemplate.update(sql, params) >=1;
	}

	@Override
	public List<Products> searchProduct(Products products){
		String sql = "SELECT * FROM product WHERE Type=? AND Price >=? AND Number >= ? And Address LIKE CONCAT('%',?,'%') AND Sale >= ? ";
		Object[] params = new Object[] {
				String.valueOf(products.getType()),
				products.getPrice(),
				products.getNumber(),
				products.getAddress(),
				products.getSale()
		};
		return this.jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Products.class));
	}


}
