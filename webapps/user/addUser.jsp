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
    <title>회원가입</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
  </head>
  <body>
  <jsp:include page="../header.jsp" />
  <section class="section">
    <div class="container">
      <h1 class="title">회원가입</h1>
      	<form action="${path1 }/AddUserCtrl.do" method="post">
			<table class="table">
			   <tbody>
			    <tbody>
				<tr>
					<th>아이디</th>
					<td>
						<div class="form-row">
							<input type="text" name="cusId" id="cusId" placeholder="아이디 입력" class="form-control" autofocus required />
							<input type="button" class="btn btn-primary" value="아이디 중복 확인" onclick="idCheck()">
							<input type="hidden" name="idck" id="idck" value="no">
						</div>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="cusPw" id="cusPw" placeholder="****" class="form-control" required /></td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td><input type="password" name="cusPw2" id="cusPw2" placeholder="****" class="form-control" required /></td>
				</tr>
				<tr>
					<th>고객이름</th>
					<td><input type="text" name="cusName" id="cusName" placeholder="이름 입력" class="form-control" required /></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="tel" name="tel" id="tel" placeholder="전화번호 입력 000-0000-0000" class="form-control" required></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="address1" id="address1" placeholder="기본 주소 입력" class="form-control" required /><br>
					<input type="text" name="address2" id="address2" placeholder="상세 주소 입력" class="form-control" required /><br>
					<input type="text" name="postcode" id="postcode" style="width:160px;float:left;margin-right:20px;" placeholder="우편번호" class="form-control">
					<button id="post_btn" onclick="findAddr()" class="btn btn-primary">우편번호 검색</button>
					</td>
				</tr>
			  </tbody>
			</table>
			<div class="buttons">
			  <button type="submit" class="button is-success">등록</button>
			  <button type="reset" class="button is-warning">취소</button>
			  <a href="${path1 }/GetNoticeListCtrl.do" class="button is-info">목록</a>
			</div>
		</form>
    </div>
  </section>
  <jsp:include page="../footer.jsp"></jsp:include>
  </body>
</html>