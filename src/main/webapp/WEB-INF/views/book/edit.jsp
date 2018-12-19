<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
  <h1>책 수정</h1>
  <hr />
  <form:form method="put" modelAttribute="book">  
    <div class="form-group">
      <label>id:</label>
      <form:input path="id" class="form-control w200" />
    </div>
    <div class="form-group">
      <label>title:</label>
      <form:input path="title" class="form-control w200" />
    </div>
    <div class="form-group">
      <label>author:</label>
      <form:input path="author" class="form-control w200" />
    </div>
    <div class="form-group">
      <label>categoryId:</label>
      <form:input path="category.id" class="form-control w200" />
    </div>
    <div class="form-group">
      <label>price:</label>
      <form:input path="price" class="form-control w200" />
    </div>
     <div class="form-group">
      <label>publisherId:</label>
      <form:input path="publisher.id" class="form-control w200" />
    </div>
     <div class="form-group">
      <label>available:</label>
      <form:input path="available" class="form-control w200" />
    </div>
  
   
      <button type="submit" class="btn btn-primary">
      <span class="glyphicon glyphicon-ok"></span> 저장</button>
    
      <a href="delete?id=${ book.id }" class="btn btn-danger" data-confirm-delete>
          <i class="glyphicon glyphicon-remove"></i> 삭제</a>
     
  </form:form>
   
</div>
</body>
</html>
