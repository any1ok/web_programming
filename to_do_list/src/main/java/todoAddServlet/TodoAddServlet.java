package todoAddServlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.project2.dao.TodoDao;
import kr.or.connect.project2.dto.Todo;

/**
 * Servlet implementation class TodoAddServlet
 */
@WebServlet("/TodoAdd")
public class TodoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Todo item = new Todo();
		
		String todo = request.getParameter("todo");
		String name = request.getParameter("whodo");
		
		String str = request.getParameter("priority");
		
		int priority = Integer.parseInt(str);
		
		Calendar cal= Calendar.getInstance();
		int year = cal.get ( cal.YEAR );
		int month = cal.get ( cal.MONTH ) + 1 ;
		int date = cal.get ( cal.DATE ) ;
		ServletContext application = getServletContext();
		int idid = (Integer)application.getAttribute("idid");
		idid++;
		
		String date1 = year+"-"+month+"-"+date;
		
		
		
		
		item.setTodo(todo);
		item.setPriority(priority);
		item.setName(name);
		item.setDate(date1);
		item.setTodo_id(idid);
		item.setState(0);
		
		
		TodoDao dao = new TodoDao();
		dao.insertTodos(item);
		response.sendRedirect("Main");
		
		
		
		
	
	}

}
