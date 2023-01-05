<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/header.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">User delete confirmation</h1>
        <a href="/user/list" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="fas fa-download fa-sm text-white-50"></i>List of users</a>
    </div>

    <table class="table table-bordered">
        <tr>
            <th>Id</th><td>${user.id}</td>
        </tr>
        <tr>
            <th>User name</th><td>${user.userName}</td>
        </tr>
        <tr>
            <th>Email</th><td>${user.email}</td>
        </tr>
    </table>
    <h6>Do you want to delete this user?</h6>
    <form action = "/user/delete" method="post">
        <input type="hidden" name="id" value="${user.id}"/>
        <input type="submit" value="Delete user">
    </form>
</div>
<!-- /.container-fluid -->

<%@ include file="/footer.jsp" %>

