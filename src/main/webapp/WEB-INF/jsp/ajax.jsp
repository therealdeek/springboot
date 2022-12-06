<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="include/header.jsp" />

<script>
		$(document).ready(
			function() {
				$('input[type=radio]').change(function () {
					console.log(this.value);

					$.ajax({
					    url: "/ajaxcall",
					    data: {
					        clickedValue: this.value
					        },
					    success: function (result) {
					        console.log("server responded : " + result);
					        },


					});
				});
			}
		);
	</script>

    <div class="container">
        <h2 class="mb-3">Ajax example</h2>

        <input type="radio" id="html" name="fav_language" value="HTML">
        <label for="html">HTML</label><br>
        <input type="radio" id="css" name="fav_language" value="CSS">
        <label for="css">CSS</label><br>
        <input type="radio" id="javascript" name="fav_language" value="JavaScript">
        <label for="javascript">JavaScript</label>

    </div>


<jsp:include page="include/footer.jsp" />
