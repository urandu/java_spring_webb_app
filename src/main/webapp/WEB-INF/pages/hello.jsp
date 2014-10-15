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


<header>
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Inspro reports</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">


                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Management <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#">order by</a></li>
                            <ul>
                                <li><a onclick="dateFilter();" href="#">By insurance company</a></li>
                            </ul>

                            <li><a href="#">balance per policy number</a></li>
                            <li><a href="#">sales day book</a></li>
                            <li class="divider"></li>
                            <li><a href="#">assurance receipts</a></li>
                            <li><a href="#">Sales by receipts</a></li>
                            <li class="divider"></li>

                        </ul>
                    </li>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">Link</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#">Action</a></li>
                            <li><a href="#">Another action</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Separated link</a></li>
                        </ul>
                    </li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</header>
<body>
<div id="my-for" class="col-xs-6 col-sm-3 " >
<form method="get" action="http://localhost:8084/by_icomp" modelAttribute="report1" >
    <label for="dateFrom">Date From</label>
    <input type="date" id="dateFrom" name="dateFrom" />
    </br>
    <label for="dateTo">Date To</label>
    <input type="date" id="dateTo" name="dateTo" />
    </br>
    <label for="icomp">Insurance Company</label>
    <select id="icomp" class="form-control" >
        <option value="ALL" selected >All</option>
        <c:forEach items="${icomps}" var="company">
            <option value="${company.cname}">${company.cname}</option>
        </c:forEach>
    </select>
    </br>
    <label for="renewal">Renewal/New Business</label>
    <select id="renewal" class="form-control" >
        <option value="ALL" selected >ALL</option>
        <option value="CREDIT NOTE"  >CREDIT NOTE</option>
        <option value="ENDORSEMENT"  >ENDORSEMENT</option>
        <option value="NEW BUSINESS"  >NEW BUSINESS</option>
        <option value="RENEWAL"  >RENEWAL</option>

    </select>
    <input type="submit">

</form>
</div>


<div>
    <form:form method="GET" action="report1_result">
        <table>
            <tr>
                <td><form:label path="dateFrom">Date from</form:label></td>
                <td><form:input type="date" path="dateFrom" /></td>
            </tr>
            <tr>
                <td><form:label path="dateTo">Date To</form:label></td>
                <td><form:input type="date"  path="dateTo" /></td>
            </tr>
            <tr>
                <td><form:label path="icomp">Company</form:label></td>
                <td><form:select path="icomp">
                    <form:option value="ALL"   >ALL</form:option>
                    <c:forEach items="${icomps}" var="company">
                        <form:option value="${company.cname}">${company.cname}</form:option>
                    </c:forEach>
                     </form:select>
                </td>
            </tr>
            <tr>
                <td><form:label path="renewal">Renewal/</form:label></td>
                <td><form:select path="renewal" >
                <form:option value="ALL"   >ALL</form:option>
                <form:option value="CREDIT NOTE" >CREDIT NOTE</form:option>
                <form:option value="ENDORSEMENT"  >ENDORSEMENT</form:option>
                <form:option value="NEW BUSINESS"  >NEW BUSINESS</form:option>
                <form:option value="RENEWAL"  >RENEWAL</form:option>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Submit"/>
                </td>
            </tr>
        </table>
    </form:form>




</div>

</body>

<script >




    function dateFilter()
    {


            $("#my-form").toggle();

            $("#my-form").click(function(){$("#my-form").toggle()})


    }
    dateFilter();
</script>
</html>

