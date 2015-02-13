<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
    <title>CareerCup questions</title>
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


<body class="span12" >
<h4>Questions on page ${page_num}</h4>

<div>
    <form:form method="GET" action="get_questions">
        <table>

            <tr>
                <td><form:label path="page_number"><h3>Page Number</h3></form:label></td>
                <td><form:input path="page_number" ></form:input></td> &nbsp;&nbsp;
                <td colspan="2">
                    <input type="submit" value="LOAD"/>
                </td>
            </tr>

        </table>
    </form:form>




</div>
<div class="span12">

    <table class="table table-bordered">
        <thead>
        <tr>
            <td>Question ID</td>
            <td>Question</td>
            <td>Company that asked the question</td>
        </tr>
        </thead>

    <c:forEach var="col" items="${questions}">


       <tr>
            <td>
                    ${col.question_id}
            </td>
            <td>
                    ${col.question}
            </td>
            <td>
                    ${col.company_name}
            </td>

        </tr>


    </c:forEach>

    </table>
</div>
</body>


</html>

