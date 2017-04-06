package com.isha.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
 
import javax.sql.DataSource;
 
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.isha.demo.model.Product;


	public class ProductDAOImpl implements ProductDAO {
		 
		private JdbcTemplate jdbcTemplate;
		
		public ProductDAOImpl(DataSource dataSource) {
			jdbcTemplate = new JdbcTemplate(dataSource);
		}

		@Override
		public void saveOrUpdate(Product product) {
			if (product.getId() > 0) {
				// update
				String sql = "UPDATE product SET Product_Name=?, IsAvailable=?, Product_Image=? WHERE Product_id=?";
				jdbcTemplate.update(sql, product.getName(), product.IsAvailable(), product.getImage(),product.getId());
						
			} else {
				// insert
				String sql = "INSERT INTO product (Product_Name, IsAvailable, Product_Image)"
							+ " VALUES (?, ?, ?)";
				jdbcTemplate.update(sql, product.getName(), product.IsAvailable(), product.getImage());
			}
			
		}

		@Override
		public void delete(int productId) {
			String sql = "DELETE FROM product WHERE Product_id=?";
			jdbcTemplate.update(sql, productId);
		}

		@Override
		public List<Product> list() {
			String sql = "SELECT * FROM product";
			List<Product> listProduct = jdbcTemplate.query(sql, new RowMapper<Product>() {

				@Override
				public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
					Product aProduct = new Product();
		
					aProduct.setId(rs.getInt("Product_id"));
					aProduct.setName(rs.getString("Product_Name"));
					aProduct.setAvailable(rs.getBoolean("IsAvailable"));
					aProduct.setImage(rs.getBlob("Product_Image"));
					
					
					return aProduct;
				}
				
			});
			
			return listProduct;
		}

		@Override
		public Product get(int productId) {
			String sql = "SELECT * FROM product WHERE Product_id=" + productId;
			return jdbcTemplate.query(sql, new ResultSetExtractor<Product>() {

				@Override
				public Product extractData(ResultSet rs) throws SQLException,
						DataAccessException {
					if (rs.next()) {
						Product product = new Product();
						product.setId(rs.getInt("Product_id"));
						product.setName(rs.getString("Product_Name"));
						product.setAvailable(rs.getBoolean("IsAvailable"));
						product.setImage(rs.getBlob("Product_Image"));
						
						return product;
					}
					
					return null;
				}
				
			});
		}

	}

