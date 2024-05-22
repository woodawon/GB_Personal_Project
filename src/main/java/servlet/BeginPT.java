package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GBDAO;
import model.itVO;
import model.psVO;


@WebServlet("/BeginPT.do")
public class BeginPT extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "jsp/psQuestion.jsp";
		try {
			GBDAO dao = GBDAO.getInstance();
			ArrayList<psVO> db = dao.get_psDB();
			HttpSession session = request.getSession();
			session.setAttribute("psDB", db);
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
