package rzk;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import rzk.beans.CardsBean;
import rzk.beans.CardsBeanRemote;

/**
 * Servlet implementation class CestitkeServlet
 */
@WebServlet("/CestitkeServlet")
public class CestitkeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CardsBeanRemote cardsBean;
	
	private Context initialContext;

	private final String PKG_INTERFACES = "org.jboss.ejb.client.naming";

	public Context getInitialContext() throws NamingException {
		if (initialContext == null) {
			Properties properties = new Properties();
			properties.put(Context.URL_PKG_PREFIXES, PKG_INTERFACES);
			initialContext = new InitialContext(properties);
		}
		return initialContext;
	}

	private String getLookupName() {
		
		// The app name is the application name of the deployed EJBs. This is typically the ear name without the .ear suffix. 
        final String appName = "CestitkeEAR";
        // This is the module name of the deployed EJBs on the server. This is typically the jar name of the EJB deployment, without the .jar suffix.
        final String moduleName = "CestitkeEJB";
        // JBossAS allows each deployment to have an (optional) distinct name. We haven't specified a distinct name for
        // our EJB deployment, so this is an empty string
        final String distinctName = "";
        // The EJB name which by default is the simple class name of the bean implementation class
        final String beanName = CardsBean.class.getSimpleName();
        // the remote interface fully qualified class name
        final String interfaceName = CardsBeanRemote.class.getName();
        // let's do the lookup
		String name = "ejb:" + appName + "/" + moduleName + "/" +
				distinctName    + "/" + beanName + "!" + interfaceName;
		return name;
	}

	private CardsBeanRemote doLookup() {
		Context context = null;
		CardsBeanRemote bean = null;
		try {
			context = getInitialContext();
			String lookupName = getLookupName();
			System.out.println("JNDI ime:   "+lookupName);
			bean = (CardsBeanRemote) context.lookup(lookupName);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return bean;
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CestitkeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		String to = request.getParameter("to");
		String email = request.getParameter("email");
		String from = request.getParameter("from");
		
		if(cardsBean == null) {
			cardsBean = doLookup();
		}
		
		boolean sent = cardsBean.sendMessage(type, from, to, email);
		
		String msg = "";
		if(sent) {
			msg = "Vasa cestitka je uspesno sacuvana.";
		} else {
			msg = "Doslo je do greske prilikom slanja vase cestitke. Molimo, pokusajte ponovo...";
		}
		
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
