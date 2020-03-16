package kr.or.connect.project2.dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import kr.or.connect.project2.dto.Todo;



public class TodoDao {
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb";
	private static String dbUser = "connectuser";
	private static String dbpasswd = "connect123!@#";
	
	public List<Todo> getTodos(){
		List<Todo> li = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "select * from todo order by priority";
		
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			try (ResultSet rs = ps.executeQuery()) {
				int count =0;
				
				while (rs.next()) {
					Todo answer = new Todo();
					int a = rs.getInt("todo_id");
					String b = rs.getString("todo");
					String c = rs.getString("date");
					String d = rs.getString("name");
					int e = rs.getInt("priority");
					int f = rs.getInt("state");
					
					answer.setTodo_id(a);
					answer.setTodo(b);
					answer.setDate(c);
					answer.setName(d);
					answer.setPriority(e);
					answer.setState(f);
					li.add(answer); 
					count++;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return li;
	}
		
	public int insertTodos(Todo item){
		int insertCount = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "insert into todo (todo_id,todo,date,name,priority,state) values (?,?,?,?,?,?)";
		
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			

				ps.setInt(1, item.getTodo_id());
				ps.setString(2,item.getTodo());
				ps.setString(3, item.getDate());
				ps.setString(4, item.getName());
				ps.setInt(5, item.getPriority());
				ps.setInt(6,0);
				insertCount = ps.executeUpdate(); 
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return insertCount;
	}
	
	
	public int updateRole(String a,String b) {
		int updateCount = 0;
		int State = Integer.parseInt(a)+1;
		int todo_id = Integer.parseInt(b);
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
			
			conn = DriverManager.getConnection ( dburl, dbUser, dbpasswd );
			
			String sql = "update todo set state = ? where todo_id = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, State);
			ps.setInt(2, todo_id);
			
			updateCount = ps.executeUpdate();

		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch(Exception ex) {}
			} // if
			
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception ex) {}
			} // if
		} // finally
		
		return updateCount;
	}
	
	
	}
	

















