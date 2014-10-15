<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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


<table>
    <tr>
    <h4>RISK HUB INSURANCE AGENCY</h4>
    </tr>
    <tr>
        Sales Day Book From:${dateFrom}    To:${dateTo}
    </tr>
    <tr>

    </tr>
    <tr>
        <td>Tran Date</td>
        <td>Effective</td>
        <td>Tran Expiry</td>
        <td>Ref</td>
        <td>Type</td>
        <td>Policy No</td>
        <td>Client Name</td>
        <td>Premium</td>
        <td>Commission</td>
        <td>T.Levy</td>
        <td>S.Duty</td>
        <td>Coverage</td>
    </tr>

    <c:forEach var="col" items="${report1}">


        <tr>
            <td>${col.invdate}</td>
            <td>${col.effdate}</td>
            <td>${col.expdate}</td>
            <td>${col.inv}</td>
            <td>${col.psta}</td>
            <td>${col.pol}</td>
            <td>${col.clientname}</td>
            <td>${col.premium}</td>
            <td>${col.comm}</td>
            <td>${col.tlevy}</td>
            <td>${col.sduty}</td>
            <td>${col.risk}</td>
        </tr>


    </c:forEach>
</table>