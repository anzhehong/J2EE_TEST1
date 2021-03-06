<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">

  * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
  }

  caption {
    text-align: left;
    font-size: 1.5em;
    color: seagreen;
    font-weight: bold;
    text-transform: uppercase;
    padding: 5px;
  }

  table {
    color: #333;
    font-family: sans-serif;
    font-size: .9em;
    font-weight: 300;
    line-height: 40px;
    border: 2px solid #428bca;
    width: 800px;
    margin: 20px auto;
  }

  thead tr:first-child {
    background: #428bca;
    color: #fff;
    font-weight: bold;
    text-align: left;
    text-transform: uppercase;
  }

  th {padding: 0 15px 0 20px;}
  td:first-child {padding-left: 20px;}

  thead tr:last-child th {border-bottom: 3px solid #ddd;}

  tbody tr:hover {background-color: #f0fbff;}
  tbody tr:last-child td {border: none;}
  tbody td {
    text-align: left;
    border-bottom: 2px solid #ddd;}

  td:nth-child(3),
  td:nth-child(4),
  td:nth-child(6){
    text-align: center;
  }

  .link {
    color: #428bca;
    text-align: center;
    text-decoration: none;
    padding-left: 15px;
  }

  .link:hover {
    text-decoration: underline;
    cursor: pointer;
  }
</style>
<html>
<title>Course List</title>
<body>
<table>
  <caption>Course List</caption>
  <thead>
  <tr>
    <th>Title</th>
    <th>Email</th>
  </tr>
  </thead>
  <tbody>

  <c:forEach items="${teachers}" var="teachers">
    <tr>
      <td>${teachers.title}</td>
      <td>${teachers.email}</td>
    </tr>
  </c:forEach>

  </tbody>
</table>
</body>
</html>
