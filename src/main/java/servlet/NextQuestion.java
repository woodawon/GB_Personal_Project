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

@WebServlet("/NextQuestion.do")
public class NextQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
        Integer currentIndex = (Integer) session.getAttribute("currentIndex");
        session.setAttribute("currentIndex", currentIndex + 1);
        response.sendRedirect("BeginIT.do");
	}
}
