package controlador;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.AutorDAO;
import modelo.Autor;

@WebServlet("/")
public class AutorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AutorDAO autorDAO;
	public void init() {
		autorDAO = new AutorDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertAutor(request, response);
				break;
			case "/delete":
				deleteAutor(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateAutor(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Autor> listUser = autorDAO.selectAllAutor();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("autor-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("autor-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Autor existingAutor = autorDAO.selectAutor(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("autor-form.jsp");
		request.setAttribute("autor", existingAutor);
		dispatcher.forward(request, response);
	}
	
	private void insertAutor(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
	

//convertir caracteres a UTF-8
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String libro = request.getParameter("libro");
		Autor newAutor = new Autor(name, email, country,libro);
		autorDAO.insertAutor(newAutor);
		response.sendRedirect("list");
		}
	
	private void updateAutor(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		//convertir caracteres a UTF-8
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String libro = request.getParameter("libro");
		Autor book = new Autor(id, name, email, country, libro);
		autorDAO.updateAutor(book);
		response.sendRedirect("list");
	}
	private void deleteAutor(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		autorDAO.deleteAutor(id);
		response.sendRedirect("list");
	}
}