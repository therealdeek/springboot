<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../include/header.jsp" />

<table border="1">
      <tr>
        <th>Instructor</th>
        <th>Count</th>
        <th>Get Count</th>
      </tr>
      <c:forEach items="${instructorCounts}" var="instCount">
        <tr>
          <td>${instCount.instructor}</td>
          <td>${instCount.cnt}</td>
          <td>${instCount.get("cnt")}</td>
        </tr>
      </c:forEach>
  </table>

<jsp:include page="../include/footer.jsp" />