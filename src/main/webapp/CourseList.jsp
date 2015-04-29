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

<style type="text/css">
  fieldset
  {
    border: 2px solid #428bca;
    margin:5px;
    padding:20px;
    background:white;
  }
  legend
  {
    font-size:1em;
    color:seagreen;
  }

  form {
    text-align: left;
    font-family: sans-serif;
    margin:20px auto;
    width:800px;
  }
</style>



<html>
<title>Course List</title>

<head lang="en">
  <meta charset="UTF-8">
  <title></title>
</head>
<body>



<form method="post" action="ShowCourses?action=find">
  <fieldset  >
    <legend><b>Find Courses</b></legend>
    <label>Course Name</label>
    <input type="text" name="courseName" size="30" placeholder="input course name">
    <select name="operator" >
      <option value="and" selected>AND</option>
      <option value="or">OR</option>
    </select>
    <label>Teacher</label>
    <input type="text" size="20" placeholder="input teacher name" name="teacherName"/>
    <input type="submit" value="find"/>
  </fieldset>
</form>






</body>

<body>
<table>
  <caption>Course List</caption>
  <thead>
  <tr>
    <th>Code</th>
    <th>Name</th>
    <th>Class</th>
    <th>Semester</th>
    <th>Teacher</th>
    <th>Students</th>
  </tr>
  </thead>

  <tbody>
    <c:forEach items="${taughtCourses}" var="taughtCourses">
      <c:forEach items="${courses}" var="courses">
        <c:forEach items="${teachers}" var="teachers">
          <c:if test="${courses.code==taughtCourses.course}">
            <tr>
              <td>${courses.code}</td>
              <%--<td>${courses.name}</td>--%>
              <td>
                <a href="
                 <c:url value="ShowDetails">
                 <c:param name="action" value="nameDetail"></c:param>
                 <c:param name="courseName" value="${courses.name}"></c:param>
                  </c:url> ">${courses.name}
                </a>
              </td>

              <td>${taughtCourses.classid}</td>
              <td>${taughtCourses.semester}</td>
              <%--<td>${teachers.name}</td>--%>

              <td>
                <a href="<c:url value="ShowDetails">
                <c:param name="action" value="teacherDetail"></c:param>
                <c:param name="teacherName" value="${teachers.name}"></c:param>
                </c:url> ">${teachers.name}
                </a>
              </td>

              <td>${taughtCourses.numberOfStudents}</td>
            </tr>
          </c:if>
        </c:forEach>
      </c:forEach>
    </c:forEach>

  </tbody>
</table>
</body>
</html>
