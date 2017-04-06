package com.isha.demo.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
 
import javax.sql.DataSource;
 
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.isha.demo.model.Menu;


	public class MenuDAOImpl implements MenuDAO {
		 
		private JdbcTemplate jdbcTemplate;
		
		public MenuDAOImpl(DataSource dataSource) {
			jdbcTemplate = new JdbcTemplate(dataSource);
		}

		/*@Override
		public void saveOrUpdate(Menu menu) {
			if (menu.getId() > 0) {
				// update
				String sql = "UPDATE product SET Product_Name=?, IsAvailable=?, Product_Image=? WHERE Product_id=?";
				jdbcTemplate.update(sql, product.getName(), product.IsAvailable(), product.getImage(),product.getId());
						
			} else {
				// insert
				String sql = "INSERT INTO product (Product_Name, IsAvailable, Product_Image)"
							+ " VALUES (?, ?, ?)";
				jdbcTemplate.update(sql, product.getName(), product.IsAvailable(), product.getImage());
			}
			
		}*/

		/*@Override
		public void delete(int MenuId) {
			String sql = "DELETE FROM product WHERE Product_id=?";
			jdbcTemplate.update(sql, MenuId);
		}*/

		@Override
		public List<Menu> list() {
			String sql = "SELECT menu.Menu_Id, menu.Menu_Name, price.Price, size.Size_Type FROM demo.menu inner join price on menu.Price_Id = price.Price_Id inner join size on menu.Size_Id=size.Size_Id where Menu_Date ='2017-05-01'"  ;
			List<Menu> listMenu = jdbcTemplate.query(sql, new RowMapper<Menu>() {

				@Override
				public Menu mapRow(ResultSet rs, int rowNum) throws SQLException {
					Menu aMenu = new Menu();
		
					aMenu.setId(rs.getInt("Menu_Id"));
					aMenu.setName(rs.getString("Menu_Name"));
					
					aMenu.setSize(rs.getString("Size_Type"));
					aMenu.setPrice(rs.getDouble("price"));
					return aMenu;
				}
				
			});
			
			return listMenu;
		}

		@Override
		public Menu get(int menuId) {
			String sql = "SELECT * FROM menu WHERE Menu_Id=" + menuId;
			return jdbcTemplate.query(sql, new ResultSetExtractor<Menu>() {

				@Override
				public Menu extractData(ResultSet rs) throws SQLException,
						DataAccessException {
					if (rs.next()) {
						Menu menu = new Menu();
						menu.setId(rs.getInt("Menu_Id"));
						menu.setName(rs.getString("Menu_Name"));
						
						menu.setSize(rs.getString("Size_Type"));
						menu.setPrice(rs.getDouble("price"));
						return menu;
					}
					
					return null;
				}
				
			});
		}

	}


