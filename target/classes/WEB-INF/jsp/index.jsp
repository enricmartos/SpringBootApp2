<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
  <title>LMS</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">LMS</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/">All Topics</a></li>
      <li><a href="newTopic">New Topic</a></li>
    </ul>
  </div>
</nav>
  
<div class="container">
	<c:choose>
		<c:when test="${mode == 'TOPIC_VIEW' }">
			<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>Topic name</th>
			        <th>Description</th>
			        <th>Image</th>
			        <td>Edit</td>
			        <td>Delete</td>
			      </tr>
			    </thead>
			    <tbody>
			      <tr>
			      	<c:forEach var="topic" items ="${topics}">
			      		<tr> 
			      			<td>${topic.name}</td>
			      			<td>${topic.description}</td>
			      			<td><img src="/img/uploaded_img/${topic.attachment.name}.${topic.attachment.extension}"
			      			width = 30px height = 30px ></img> </td>
			      			<td><a href="updateTopic?id=${topic.id}"><div class="glyphicon glyphicon-pencil"></div></a></td>
			      			<td><a href="deleteTopic?id=${topic.id}"><div class="glyphicon glyphicon-trash"></div></a></td>
			      		</tr>
			        </c:forEach>
			    </tbody>
		   	</table>
		</c:when>
		
		<c:when test="${mode == 'TOPIC_EDIT' || mode == 'TOPIC_NEW'}">
			<form action="save" method="POST"  enctype="multipart/form-data">
			<input type="hidden" class="form-control" value="${topic.id}" id="id" name="id">
			    <div class="form-group">
			      <label for="name">Name</label>
			      <input type="text" class="form-control" value="${topic.name}" id="name" name="name">
			    </div>
			    <div class="form-group">
			      <label for="description">Description</label>
			      <input type="text" class="form-control" value="${topic.description}" id="description" name="description">
			    </div>
				
				<c:choose>
				<c:when test="${mode == 'TOPIC_NEW'}" >
				 <div class="form-group">
			      <label for="file">Attachment</label>
			      <input type="file" class="form-control" id="file" name="file">
			    </div>
				</c:when >
				<c:otherwise>
				<div class="form-group">
			      <label for="file">Attachment</label>
			      <img src="/img/uploaded_img/${topic.attachment.name}.${topic.attachment.extension}"
			      width = 30px height = 30px ></img>
			      
			      <input type="file" class="form-control" id="file" name="file">
			    </div>
				</c:otherwise> 
			    </c:choose>
			    
			    <button type="submit" class="btn btn-default">Submit</button>
			  </form>
		</c:when>
	</c:choose>

</div>

</body>
</html>
