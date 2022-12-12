package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 * Servlet implementation class CountryInfoServlet
 */
@WebServlet("/CountryInfoServlet")
public class CountryInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@WebServiceRef(rzk.InformationBeanService.class)
	private rzk.InformationBeanRemote infoBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CountryInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String isoCode = request.getParameter("isoCode");

		String msg = infoBean.getCountryInfo(isoCode);

		request.setAttribute("msg", msg);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}