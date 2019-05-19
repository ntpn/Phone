package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.solr.client.solrj.SolrServerException;

import connection.SolrConn;
import javabean.SetOfPhones;

/**
 * Servlet implementation class PhonesServlet
 */
@WebServlet("/PhonesServlet")
public class PhonesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pages = 0;
		String input = "";
		String mode = "newsfeed";
		if (request.getParameter("input")!= null) {
			input = request.getParameter("input");
			mode = "search";
		}
		SolrConn solrConn = new SolrConn();
		String error = "";
		SetOfPhones setOfPhones = new SetOfPhones();
		if (request.getParameter("pages")!=null) {
			pages = (int) Integer.parseInt(request.getParameter("pages"));
		}
		try {
			if (input!="") {
				setOfPhones = solrConn.searchNews(input, pages);
				}
			else {
				setOfPhones = solrConn.getNewfeed(pages);
			}
		} catch (SolrServerException e) {
			error = e.toString();
		}
		request.setAttribute("input", input);
		request.setAttribute("mode", mode);
		request.setAttribute("error", error);
		request.setAttribute("setOfPhones", setOfPhones);
		request.setAttribute("pages", pages);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/web/phones.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
