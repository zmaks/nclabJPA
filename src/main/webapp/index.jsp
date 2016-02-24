
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.nclab.jpa.entity.Car" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
  <title>Cars</title>
</head>
<body>
<h3>Cars and owners:</h3>
<table>
  <tr>
    <td>ID</td>
    <td>Mark</td>
    <td>Model</td>
    <td>Color</td>
    <td>Owner ID</td>
    <td>Owner Name</td>
  </tr>
  <%
    List<Car> cars = (List<Car>)request.getAttribute("cars");
    for(Car car : cars) {
  %>
  <tr>
    <td><%=car.getId()%></td>
    <td><%=car.getMark()%></td>
    <td><%=car.getModel()%></td>
    <td><%=car.getColor()%></td>
    <td><%=car.getOwner().getId()%></td>
    <td><%=car.getOwner().getFname()%> <%=car.getOwner().getLname()%></td>
  </tr>

  <%
    }
  %>
</table>
<br>
<p></p>
<form action="/nclabJPA/carsinfo" method="post">
  Car ID: <input type="text" name="carId" id="carId"><br>
  Mark: <input type="text" name="mark" id="mark"><br>
  Model: <input type="text" name="model" id="model"><br>
  Color: <input type="text" name="color" id="color"><br>
  Owner ID: <input type="text" name="ownerID" id="ownerID"><br>

  <input type="submit" name="createorupdate" value="Create or update"><br>
  <br>
  <p></p>
  <input type="text" name="deletedId" id="deletedId"><br>
  <input type="submit" name="deleteCar" value="Delete car"><br>
  <br>


</form>


</body>
</html>
