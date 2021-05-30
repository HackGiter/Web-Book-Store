package dao;

import java.util.List;

import generalClass.Products;
import impl.ProductsDAOImpl;

public interface productsDAO {
	public boolean insertProducts(Products products);

	public boolean updateProducts(Products products);

	public List<Products> selectProductsByName(String name);
	
	public List<Products> selectProductsByCategory(String category) ;

	public Products selectProductsByBID(String bid);

	public List<Products> selectProductsList();

	Products selectProductsByPID(String pid) ;

	boolean updateProductsNumber(String pid, int number);

	boolean updateProductsSale(String pid, int number);

	List<Products> searchProduct(Products products);
}
