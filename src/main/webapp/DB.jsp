<%--
  Created by IntelliJ IDEA.
  User: Cristhian
  Date: 26/04/2023
  Time: 7:27 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ejemplo de tabla HTML con estilos CSS</title>
    <style>
        table {
            width: 80%;
            margin: 0 auto;
            border-collapse: collapse;
            background-color: #f9f9f9;
            color: #333;
            font-family: Arial, sans-serif;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: center;
        }

        th {
            background-color: #0d6efd;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Columna 1</th>
        <th>Columna 2</th>
        <th>Columna 3</th>
        <th>Columna 4</th>
        <th>Columna 5</th>
        <th>Columna 6</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>Dato 1</td>
        <td>Dato 2</td>
        <td>Dato 3</td>
        <td>Dato 4</td>
        <td>Dato 5</td>
        <td>Dato 6</td>
    </tr>
    <tr>
        <td>Dato 1</td>
        <td>Dato 2</td>
        <td>Dato 3</td>
        <td>Dato 4</td>
        <td>Dato 5</td>
        <td>Dato 6</td>
    </tr>
    <!-- Agrega más filas aquí -->
    </tbody>
</table>
</body>
</html>
