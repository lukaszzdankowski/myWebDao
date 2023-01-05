<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/header.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Edit user</h1>
        <a href="/user/list" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="fas fa-download fa-sm text-white-50"></i>List of users</a>
    </div>

    <form action = "/user/edit" method="post">
        <input type="hidden" name="id" value="${user.id}"/>
        <label for="username">Name:</label><br>
        <input type="text" id="username" name="username" value="${user.userName}" placeholder="Old name: ${user.userName}"><br>
        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email" value="${user.email}" placeholder="Old email: ${user.email}"><br>
        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password" placeholder="Type new password"><br>
        <input type="submit" value="Save user">
    </form>

</div>
<!-- /.container-fluid -->

<%@ include file="/footer.jsp" %>

