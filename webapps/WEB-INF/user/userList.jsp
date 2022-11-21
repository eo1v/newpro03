<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*, java.lang.*" %>
<%@ page import="java.text.*, java.net.InetAddress" %>
<c:set var="path1" value="<%=request.getContextPath() %>" />
<%-- <c:set var="path1" value="${pageContext.request.contextPath }" />   --%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>회원 목록</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
  </head>
  <body>
  <jsp:include page="/header.jsp" />
  <section class="section">
    <div class="container">
      <h1 class="title">회원목록</h1>
		<table class="table">
		  <thead>
		    <tr>
		      <th><abbr title="uId">아이디</abbr></th>
		      <th><abbr title="uname">이름 </abbr></th>
		      <th><abbr title="Result">Regdate</abbr></th>
		    </tr>
		  </thead>
		   <tbody>
		   <c:forEach items="${list }" var="dto" varStatus="status">
		    <tr>
		      <td>${status.count }</td>
		      <td><a href="${path1 }/GetUserDetailCtrl.do?uid=${dto.id }">${dto.id }</a></td>
		      <td>
		      	<fmt:parseDate value="${dto.regdate }" var="regdate" pattern="yyyy-MM-dd HH:mm:ss" />
		      	<fmt:formatDate value="${regdate }" pattern="yyyy-MM-dd" />
		    </tr>
		    </c:forEach>
<%-- 		    <c:if test="${list==null }">
		    <tr>
		    	<td colspan="3">해당 데이터 목록이 없습니다.</td>
		    </tr>
		    </c:if> --%>
		  </tbody>
		</table>
		<div class="buttons">
		  <a href="${path1 }/AddUserCtrl.do" class="button is-success">회원 등록</a>
		</div>
    </div>
  </section>
  <jsp:include page="/footer.jsp"></jsp:include>
  </body>
</html>