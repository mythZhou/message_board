package com.board.web.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.service.impl.UserService;
import com.board.service.impl.UserServiceImpl;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String code=(String)request.getSession().getAttribute("checkcode");
		String checkcode=request.getParameter("checkcode");
		if(checkcode==null||!checkcode.equalsIgnoreCase(code)) {
			request.setAttribute("info", "��֤�����벻��ȷ��");
			request.getRequestDispatcher("/reg.jsp").forward(request, response);;
			return;
		}
		UserService userService=new UserServiceImpl();
		boolean flag=userService.findUser(username);
		if(flag) {
			//���ظ��û���
			request.setAttribute("info", "�û������ظ�");
			request.getRequestDispatcher("/reg.jsp").forward(request, response);;

		}else {
			//ע��ɹ�
			userService.insertUser(username,password);
			response.sendRedirect("/message_board/login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
