<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
    <title>Reports</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>


<body>

<h1>${message1}</h1>
<div>
    <form:form method="GET" action="get_questions">
        <table>

            <tr>
                <td><form:label path="page_number">Page Number</form:label></td>
                <td><form:input path="page_number" ></form:input></td> &nbsp;&nbsp;
                <td colspan="2">
                    <input type="submit" value="LOAD"/>
                </td>
            </tr>

        </table>
    </form:form>




</div>

</body>


</html>

