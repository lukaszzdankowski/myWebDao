<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/header.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Add new user</h1>
        <a href="/user/list" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="fas fa-download fa-sm text-white-50"></i>List of users</a>
    </div>

    <form action = "/user/add" method="post">
        <label for="username">Name:</label><br>
        <input type="text" id="username" name="username" placeholder="Type name of new user"><br>
        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email" placeholder="Type email of new user"><br>
        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password" placeholder="Type password of new user"><br>
        <input type="submit" value="Save user">
    </form>

</div>
<!-- /.container-fluid -->

<%@ include file="/footer.jsp" %>

