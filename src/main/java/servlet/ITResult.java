package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GBDAO;

@WebServlet("/ITResult")
public class ITResult extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String SERVER_ADDRESS = "127.0.0.1"; 
    private static final int SERVER_PORT = 8085; 

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String messageToSend = request.getParameter("message"); // 클라이언트에서 보낸 메시지
        String receivedValue = "";
        
        try {
        	GBDAO dao = GBDAO.getInstance();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             PrintWriter outputWriter = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
    
            // 서버에 메시지 전송
            outputWriter.println(messageToSend);

            // 서버로부터의 응답 받기
            receivedValue = inputReader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>서버로 보낸 메시지: " + messageToSend + "</h3>");
        out.println("<h3>서버로부터 받은 응답: " + receivedValue + "</h3>");
        out.println("</body></html>");
    }
}