/**
 * 
 */
package com.swing.test12;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * @author PE
 * @date 2019年7月1日 下午4:27:41
 * @explain 
 */
public class HeroDAO {
	public HeroDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
   
    public Connection getConnection() throws SQLException {
        return (Connection) DriverManager.getConnection
        		("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8", "root",
                "123456");
    }
	/**
	 * 查询所有
	 * @return
	 */
	public List<Hero> list() {
		   return list(0, Short.MAX_VALUE);
	}

	/**
	 * 分页查询数据
	 * @param i 第几页
	 * @param j 每页多少条数据
	 * @return
	 */
	public List<Hero> list(int start, int count) {
		List<Hero> heros = new ArrayList<Hero>();
        String sql = "select * from hero order by id desc limit ?,? ";
        try (Connection c = getConnection();
        		PreparedStatement ps = (PreparedStatement) c.prepareStatement(sql);) {
   
            ps.setInt(1, start);
            ps.setInt(2, count);
   
            ResultSet rs = ps.executeQuery();
   
            while (rs.next()) {
                Hero hero = new Hero();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                hero.id = id;
                hero.name = name;
                hero.hp = hp;
                hero.damage = damage;
                heros.add(hero);
            }
        } catch (SQLException e) {
   
            e.printStackTrace();
        }
        return heros;
    }

	/**
	 * 添加数据
	 * @param hero
	 */
	public void add(Hero hero) {
		  String sql = "insert into hero values(null,?,?,?)";
          try (Connection c = getConnection(); 
        		  PreparedStatement ps = (PreparedStatement) c.prepareStatement(sql);) {
              ps.setString(1, hero.name);
              ps.setFloat(2, hero.hp);
              ps.setInt(3, hero.damage);
              ps.execute();
     
              ResultSet rs = ps.getGeneratedKeys();
              if (rs.next()) {
                  int id = rs.getInt(1);
                  hero.id = id;
              }
          } catch (SQLException e) {
     
              e.printStackTrace();
          }
	}

	/**
	 * 修改数据
	 * @param h
	 */
	public void update(Hero hero) {
		String sql = "update hero set name= ?, hp = ? , damage = ? where id = ?";
        try (Connection c = getConnection(); 
        		PreparedStatement ps = (PreparedStatement) c.prepareStatement(sql);) {
   
            ps.setString(1, hero.name);
            ps.setFloat(2, hero.hp);
            ps.setInt(3, hero.damage);
            ps.setInt(4, hero.id);
   
            ps.execute();
   
        } catch (SQLException e) {
   
            e.printStackTrace();
        }
		
	}

	/**
	 * 删除数据
	 * @param id
	 */
	public void delete(int id) {

        try (Connection c = getConnection(); Statement s = c.createStatement();) {
   
            String sql = "delete from hero where id = " + id;
   
            s.execute(sql);
   
        } catch (SQLException e) {
   
            e.printStackTrace();
        }
		
	}
	/**
	 * 获取总数
	 * @return
	 */
	   public int getTotal() {
           int total = 0;
           try (Connection c = getConnection(); Statement s = c.createStatement();) {
      
               String sql = "select count(*) from hero";
      
               ResultSet rs = s.executeQuery(sql);
               while (rs.next()) {
                   total = rs.getInt(1);
               }
      
               System.out.println("total:" + total);
      
           } catch (SQLException e) {
      
               e.printStackTrace();
           }
           return total;
       }
      

}
