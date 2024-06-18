package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.GBDAO;
import org.json.JSONObject; // json jar파일 추가해서 import함

@WebServlet("/ITQuestionServlet")
public class ITQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String[] questions = { "컴퓨터의 주요 하드웨어 구성 요소는 무엇입니까?", "이진수의 표현방법을 예를 들어 설명해주세요",
			"IT 분야에서 가장 흥미로운 직업은 무엇이라고 생각하나요?", "인공지능의 주요 응용 분야는 어떤 것들이 있나요?", "C/C++의 차이를 설명해주세요",
			"깃허브의 장점에는 무엇이 있나요?", "List의 장점을 Array와 비교하여 설명해 주세요", "빅 데이터 분석 기술은 어떤 분야에서 활용될 수 있다고 생각하나요?",
			"서버의 역할에는 무엇이 있나요?", "인터넷을 사용할때 쿠키는 무엇인가요?", "RAM과 하드드라이브의 차이점은 무엇인가요?", "CPU란 무엇이며, 컴퓨터에서 어떤 역할을 하나요?",
			"가장 편한 프로그래밍 언어는 무엇이며, 그 이유는 무엇인가요?", "변수와 상수의 차이를 설명해주세요.", "컴퓨터의 입출력 장치에 대해 설명하세요.",
			"좋은 개발자의 요소에는 무엇이 있나고 생각하나요?", "운영체제의 역할과 기능에는 무엇이 있나요?", "과적합(Overfitting)이 무엇이며, 방지하기 위한 방법은 무엇인가요?",
			"네트워크 보안을 위한 기술 혹은 방법엔 어떤 것이 있나요?", "소프트웨어 개발 과정 중에서 특히 중요하다고 생각하는 단계와 그 이유를 설명해보세요." };

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String answer = request.getParameter("answer");
		int index = Integer.parseInt(request.getParameter("index"));
		try {
			GBDAO dao = GBDAO.getInstance();
			int result = dao.set_itDB(answer);
			HttpSession session = request.getSession();
			session.setAttribute("check", result); // 테스트 코드
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		if (index < questions.length) {
			json.put("question", questions[index]);
			json.put("index", index + 1);
			json.put("answer", answer);
		} else {
			json.put("question", "모든 질문을 완료했습니다.");
			json.put("index", index);
			json.put("answer", "");
		}

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json.toString());
	}
}
