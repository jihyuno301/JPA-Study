<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
        rel="stylesheet" media="screen">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="${R}res/common.js"></script>
  <link rel="stylesheet" href="${R}res/common.css">
</head>
<body>
<div class="container">
  <h1>책목록</h1>
  <div class="pull-right mb5">
  	<a href="create" class="btn btn-info">
    <span class="glyphicon glyphicon-user"></span>책 등록</a>
  </div>
  <br>
  <br>
  <div class="pull-right mb5">
  	<form action="countByTitleContaining">
  		<input type="text" name="name" value="${name}">
  		<button type="submit">title containing 검색</button>
  	</form> 
  	
  </div>
  <br><br>
  <div class="pull-right mb5">
  	${num}개
  </div> 
  <table class="table table-bordered mt5">
    <thead>
      <tr>
        <th>id</th>
        <th>title</th>
        <th>author</th>
        <th>categoryId</th>
        <th>price</th>
        <th>publisherId</th>
        <th>available</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="book" items="${ books }">
        <tr data-url="edit?id=${ book.id }" >
          <td>${ book.id }</td>
          <td>${ book.title }</td>
          <td>${ book.author }</td>
          <td>${ book.category.id }</td>
          <td>${ book.price }</td>
          <td>${ book.publisher.id }</td>
          <td>${ book.available }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
>