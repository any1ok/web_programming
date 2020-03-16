package MainServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.project2.dao.TodoDao;
import kr.or.connect.project2.dto.Todo;


/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/Main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		TodoDao dao = new TodoDao();
		List<Todo> list = dao.getTodos();
		 ServletContext application = getServletContext();
		int idid=list.size();
		
		List<Todo> todoList = new ArrayList<>();
		List<Todo> doneList = new ArrayList<>();
		List<Todo> doingList = new ArrayList<>();
		
		for(Todo todo:list) {
			if(todo.getState()==0) {
				todoList.add(todo);
			}
			else if(todo.getState()==1) {
				doingList.add(todo);
			}
			else {
				doneList.add(todo);
			}
			
		}
		
		application.setAttribute("idid", idid);
		
	

		request.setAttribute("list", list);
		request.setAttribute("todoList", todoList);
		request.setAttribute("doneList", doneList);
		request.setAttribute("doingList", doingList);
		
		RequestDispatcher RD = request.getRequestDispatcher("/main.jsp");
		RD.forward(request, response);
		
		
	}

}
