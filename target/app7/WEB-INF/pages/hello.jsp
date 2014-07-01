<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h1>clients</h1>
<table>
    <thead>

        <td>Names</td>
        <td>Email</td>
        <td>Tel</td>
        <td>Physical address</td>

    </thead>



    <c:forEach items="${reports}" var="rep" >
        <c:out value="${rep}"/>
    </c:forEach>

<c:forEach items="${clients}" var="client">
    <c:out value="${client.cid}"/>
    <tr>
        <td><c:out value="${client.names}"/></td>
        <td><c:out value="${client.email}"/></td>
        <td><c:out value="${client.tel1}"/></td>
        <td><c:out value="${client.phy_address}"/></td>

    </tr>

</c:forEach>

</table>

<a href="/clients/"><button>Add new client</button></a>

</body>
</html>

