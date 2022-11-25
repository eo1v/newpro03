package kr.go.suwon.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.suwon.dto.ImpressDTO;
import kr.go.suwon.model.ImpressDAO;


@WebServlet("/GetImpressListCtrl.do")
public class GetImpressListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ImpressDAO dao = new ImpressDAO();
		ArrayList<ImpressDTO> impList = dao.getImpressList();
		
		request.setAttribute("list", impList);
		
		RequestDispatcher view = request.getRequestDispatcher("./impress/impressList.jsp");
		view.forward(request, response);
	}

}
