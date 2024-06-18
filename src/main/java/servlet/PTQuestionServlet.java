package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject; // json jar파일 추가해서 import함

@WebServlet("/PTQuestionServlet")
public class PTQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String[] questions = { "누구나 크고 작은 실수를 할 수 있다고 생각하시나요?", "친한 친구와 함께 활동하는 것에 흥미를 느끼시나요?",
			"동료가 맘에 들지 않는 행동을 했을 때 어떻게 대처하시나요?", "어떻게 자신의 감정을 표현하고 다른 사람들과 공유하나요?",
			"새로운 기술이나 개념을 배우는 것에 어떤 자세를 가지고 있나요?", "어떤 유형의 사람들과 가장 잘 어울리는 것 같아요?", "타인과의 갈등을 어떻게 해결하는 편이신가요?",
			"어떤 방식으로 스트레스를 해소하거나 긍정적인 에너지를 얻나요?", "주변의 지인들이 당신을 어떤 사람으로 기억하는 편인가요?",
			"자신의 꿈과 목표를 달성하기 위해 어떤 방식으로 행동할 것 같나요?", "어떤 가치가 당신의 선택과 행동을 주도하는 데 중요한 역할을 하나요?",
			"우선순위를 결정할 때 어떤 기준을 사용하시나요?", "어떤 종류의 영화가 당신의 기분을 좋게 만드나요?", "가족이나 지인들과 어떻게 시간을 보내는 것을 좋아하시나요?",
			"어떤 상황에서 가장 편안하게 느끼시나요?", };

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int index = Integer.parseInt(request.getParameter("index"));
		JSONObject json = new JSONObject();
		if (index < questions.length) {
			json.put("question", questions[index]);
			json.put("index", index + 1);
		} else {
			json.put("question", "모든 질문을 완료했습니다.");
			json.put("index", index);
		}

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json.toString());
	}
}
