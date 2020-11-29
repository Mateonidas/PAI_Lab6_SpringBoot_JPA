<%@ page import="com.polec.lab6.entity.CountryEntity" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Country List</title>
</head>
<body>

<h3>Country List</h3>
<hr>

<form action="${pageContext.request.contextPath}/findAll" method="post">
    <input type="submit" value="Show all countries" >
</form>

<form action="${pageContext.request.contextPath}/continent" method="post" >
    <label for="continent">Continent:</label>
    <input type="text" id="continent" name="continent">
    <input type="submit" value="Show" >
</form>

<form action="${pageContext.request.contextPath}/populationGreaterThen" method="post" >
    <label for="populationGreaterThen">Population greater then:</label>
    <input type="text" id="populationGreaterThen" name="population">
    <input type="submit" value="Show" >
</form>

<form action="${pageContext.request.contextPath}/populationLessThen" method="post" >
    <label for="populationLessThen">Population less then:</label>
    <input type="text" id="populationLessThen" name="population">
    <input type="submit" value="Show" >
</form>

<form action="${pageContext.request.contextPath}/surface" method="post" >
    <label for="continentSurface">Continent:</label>
    <input type="text" id="continentSurface" name="continent">
    <label for="minArea">Minimal area:</label>
    <input type="text" id="minArea" name="minArea">
    <label for="maxArea">Maximum area:</label>
    <input type="text" id="maxArea" name="maxArea">
    <input type="submit" value="Show" >
</form>

<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Code</th>
        <th>Continent</th>
        <th>Population</th>
        <th>Surface Area</th>
    </tr>
    </thead>
    <tbody>

    <%
    ArrayList<CountryEntity> list = (ArrayList<CountryEntity>)session.getAttribute("countries");
        for (CountryEntity country : list) {
    %>
    <tr>
        <td> <%=country.getName()%> </td>
        <td> <%=country.getCode()%> </td>
        <td> <%=country.getContinent()%> </td>
        <td> <%=country.getPopulation()%> </td>
        <td> <%=country.getSurfaceArea()%> </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

</body>
</html>