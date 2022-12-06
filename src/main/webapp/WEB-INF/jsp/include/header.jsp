<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Insert title here</title>
</head>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>


<!-- include bootstrap here -->
<!-- include global CSS files here -->

<body>

<div class="container">
	<div class="row mt-1 mb-3 justify-content-center">
		<div class="col-6">
			<a href="/">Home</a> |
			<a href="/user/createuser">Create User</a> |

			<sec:authorize access="hasAnyAuthority('ADMIN')">
				<a href="/admin/admintest">Admin Test</a> |
			</sec:authorize>

			<sec:authorize access="isAuthenticated()">
				<a href="/user/logout">Logout</a> |
				<sec:authentication property="principal.username" />
			</sec:authorize>

			<sec:authorize access="!isAuthenticated()">
				<a href="/user/login">Login</a>
			</sec:authorize>
		</div>
	</div>
</div>

<!-- site navigation bar on top of page -->