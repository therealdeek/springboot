<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="include/header.jsp" />

<div class="container">
	<h2 class="mb-3">File upload example</h2>

	<form method="POST" action="/fileuploadSubmit" enctype="multipart/form-data">
	   <div class="row col-4 mb-2">
	   		Select a file to upload
	   </div>
	   <div class="row col-4 mb-3">
	   		<input type="file" name="file" />
	   	</div>
	   	<div class="row col-1 mb-1">
	        <input class="btn btn-primary" type="submit" value="Submit" />
	    </div>
	</form>

	<img src="${filename}" style="max-width=500px">
</div>

<jsp:include page="include/footer.jsp" />