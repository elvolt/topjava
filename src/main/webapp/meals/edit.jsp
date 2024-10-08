<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Edit Meal</title>
</head>
<body>
<h3><a href="../index.html">Home</a></h3>
<div>
    <form method="POST" action="<%=request.getContextPath()%>/meals">
        DateTime : <input type="datetime-local" name="dateTime"><br/>
        Description : <input type="text" name="description"/> <br/>
        Calories : <input type="number" name="calories"/> <br/>
        <input type="submit" value="Submit"/>
    </form>
</div>
</body>
</html>
