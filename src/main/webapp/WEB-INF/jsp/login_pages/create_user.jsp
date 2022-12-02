<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../include/header.jsp" />

<div class="container">
    <div class="row mt-3 mb-1">
        <h2>Create user</h2>
    </div>

        <c:if test="${bindingResult.hasErrors()}">
          <c:forEach items="${bindingResult.getAllErrors()}" var="error">
            <p class="mt-0 mb-1" style="color:red">${error.getDefaultMessage()}</p>
          </c:forEach>
        </c:if>

<form action="/user/createuser" method="POST">
  <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Email address</label>
        <input type="email" value="${form.email}" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
        <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
  </div>

  <div class="row">
      <div class="mb-3 col-6">
        <label for="exampleInputPassword1" class="form-label">Password</label>
        <input type="password" value="${form.password}"name="password" class="form-control" id="exampleInputPassword1">
      </div>

      <div class="mb-3 col-6">
        <label for="confirmPassword" class="form-label">Confirm Password</label>
        <input type="password" value="${form.confirmPassword}"name="confirmpassword" class="form-control" id="confirmPassword">
      </div>
      </div>

      <div class="row">
        <div class="mb-3">
          <label for="firstName" class="form-label">First Name</label>
          <input type="text" value="${form.firstName}"name="firstName" class="form-control" id="firstName" aria-describedby="firstNameHelp">
          <label class="firstNameHelp" for="form-text">Please give me your first name</label>
        </div>

        <div class="mb-3">
          <label for="lastName" class="form-label">Last Name</label>
          <input type="text" value="${form.lastName}"name="lastName" class="form-control" id="lastName" aria-describedby="lastNameHelp">
          <label class="lastNameHelp" for="form-text">Please give me your last name</label>
        </div>
      </div>

      <div class="mb-3 col-4">
        <label for="address" class="form-label">Address</label>
        <input type="text" value="${form.address}"name="address" class="form-control" id="address" aria-describedby="addressHelp">
        <label class="addressHelp" for="form-text">Please give me your address</label>
      </div>

      <div class="row">
        <div class="mb-3 col-4">
          <label for="city" class="form-label">City</label>
          <input type="text" value="${form.city}"name="city" class="form-control" id="city" aria-describedby="cityHelp">
          <label class="cityHelp" for="form-text">Enter Your City</label>
      </div>

        <div class="mb-3 col-4">
          <label for="state" class="form-label">State</label>
          <input type="text" value="${form.state}"name="state" class="form-control" id="state" aria-describedby="stateHelp">
          <label class="stateHelp" for="form-text">Enter Your State</label>
        </div>

        <div class="mb-3 col-4">
          <label for="zip" class="form-label">Zip</label>
          <input type="text" value="${form.zip}"name="zip" class="form-control" id="zip" aria-describedby="zipHelp">
          <label class="zipHelp" for="form-text">Enter Your Zip</label>
        </div>

        <div class="mb-3 col-4">
          <label for="phone" class="form-label">Phone</label>
          <input type="text" value="${form.phone}"name="phone" class="form-control" id="phone" aria-describedby="phoneHelp">
          <label class="phoneHelp" for="form-text">Enter Your Phone Number</label>
        </div>

        </div>

      </div>






        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>






<jsp:include page="../include/footer.jsp" />