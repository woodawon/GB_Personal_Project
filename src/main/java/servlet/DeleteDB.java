package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GBDAO;
import model.psVO;


@WebServlet("/DeleteDB.do")
public class DeleteDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "jsp/index.jsp";
		try {
			GBDAO dao = GBDAO.getInstance();
			int result = dao.reset_DB();
			HttpSession session = request.getSession();
			if(result == 1) {
				session.setAttribute("result", "초기화 완료");
			} else {
				session.setAttribute("result", "초기화 실패");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
