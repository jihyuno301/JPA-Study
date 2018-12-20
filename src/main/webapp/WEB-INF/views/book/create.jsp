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
  <style> .error { color: red; }</style>
</head>
<body>
<div class="container">
  <h1>책 등록</h1>
  <hr />
  <form:form method="post" modelAttribute="bookModel">  
   
    <div class="form-group">
      <label>title:</label>
      <form:input path="title" class="form-control w200" />
      <form:errors path="title" class="error" />
    </div>
    <div class="form-group">
      <label>author:</label>
      <form:input path="author" class="form-control w200" />
      <form:errors path="author" class="error" />
    </div>
    <div class="form-group">
      <label>categoryId:</label>
      <form:select path="categoryId" class="form-control w200" itemValue="id" itemLabel="name" items="${categories }" />
  	  <form:errors path="categoryId" class="error" />
    </div>
      
      
    <div class="form-group">
      <label>price:</label>
      <form:input path="price" class="form-control w200" />
       <form:errors path="price" class="error" />
    </div>
     <div class="form-group">
      <label>publisherId:</label>
        <form:select path="publisherId" class="form-control w200" itemValue="id" itemLabel="title" items="${publishers }" />
       <form:errors path="publisherId" class="error" />
    </div>
   
      <button type="submit" class="btn btn-primary">
      <span class="glyphicon glyphicon-ok"></span> 저장</button>
    
    
  </form:form>
   
</div>
</body>
</html>
