<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

    <div class="container">
        <div class="row mt-3 mb-1 justify-content-center">
            <div class="col-4">
            	<h2>Login</h2>
            </div>
        </div>

        <form action="/user/loginpost" method="POST">
            <div class="row justify-content-center">
	            <div class="mt-2 mb-3 col-4">
	                <label for="username" class="form-label">Username</label>
	                <input type="username" name="username" class="form-control" id="username"
	                    aria-describedby="usernameHelp">
	                <div id="usernameHelp" class="form-text">Enter your username</div>
	            </div>
            </div>
            <div class="row justify-content-center">
	            <div class="mt-2 mb-3 col-4">
	                <label for="password" class="form-label">Password</label>
	                <input type="password" name="password" class="form-control" id="password"
	                    aria-describedby="passwordHelp">
	                <div id="passwordHelp" class="form-text">Enter your password</div>
	            </div>
	        </div>

            <div class="row justify-content-center">
	            <div class="mt-2 mb-3 col-4">
	            	<button type="submit" class="btn btn-primary">Submit</button>
	             </div>
	        </div>
        </form>
    </div>

<jsp:include page="../include/footer.jsp" />