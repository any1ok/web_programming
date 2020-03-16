package testing;

import java.util.List;

import kr.or.connect.project2.dao.TodoDao;
import kr.or.connect.project2.dto.Todo;

public class test {

	public static void main(String[] args) {
		Todo todo = new Todo();
		TodoDao dao = new TodoDao();
		todo.setTodo_id(1);
		todo.setState(0);
		dao.updateRole("1","1");
		
		
	}

}
