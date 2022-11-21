package kr.go.suwon.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.suwon.dto.TourDTO;
import kr.go.suwon.model.TourDAO;


@WebServlet("/GetTourCateListCtrl")
public class GetTourCateListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String cate = request.getParameter("cate");
		TourDAO dao = new TourDAO();
		ArrayList<TourDTO>tourList = dao.getTourCateList(cate);
		
		request.setAttribute("list",tourList);
		request.setAttribute("placeCate", cate);
		
		RequestDispatcher view = request.getRequestDispatcher("./tour/tourCateList.jsp");
		view.forward(request, response);
	}

}
