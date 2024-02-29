<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html data-bs-theme="light" lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Sale Dock - Quản lý khách hàng</title>
        <link rel="icon" type="image/png" sizes="512x512" href="<%=request.getContextPath()%>/view/assets/images/favicon/favicon.png">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/assets/fonts/fontawesome-all.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/assets/fonts/line-awesome.min.css">
    </head>

    <body id="page-top">
        <div id="wrapper">
            <%@include file="../../../common/_sidenav.jsp" %>
            <div class="d-flex flex-column" id="content-wrapper">
                <div id="content">
                    <%@include file="../../../common/_nav.jsp" %>
                    <div class="container-fluid">
                        <h3 class="text-dark mb-4">Khách hàng</h3>
                        <div class="card shadow">
                            <div class="card-header d-xxl-flex justify-content-between align-items-center align-items-xxl-center py-3">
                                <p class="text-primary m-0 fw-bold">Quản lý khách hàng</p><a class="btn btn-primary btn-sm" role="button" href="<%=request.getContextPath()%>/add-customer">Thêm khách hàng</a>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive table mt-2" id="dataTable" role="grid" aria-describedby="dataTable_info">
                                    <table class="table my-0" id="dataTable">
                                        <thead>
                                            <tr>
                                                <th>Tên khách hàng</th>
                                                <th>Mã khách hàng</th>
                                                <th>Email</th>
                                                <th>Thao tác</th>
                                            </tr>
                                        </thead>
                                        <c:forEach items="${requestScope.customers}" var="customer">
                                            <tbody>                                        
                                                <tr>
                                                    <td><img class="rounded-circle me-2" width="30" height="30" src="<%=request.getContextPath()%>/view/assets/images/icons/customer.png">${customer.name}</td>
                                                    <td>${customer.code}</td>
                                                    <td>${customer.email}</td>
                                                    <td class="text-start">
                                                        <a class="btn btn-primary btn-sm" role="button" data-bs-toggle="tooltip" data-bss-tooltip="" style="margin: 2px;" title="Thông tin chi tiết" href="<%=request.getContextPath()%>/customer-detail?id=${customer.ID}">
                                                            <i class="la la-info-circle"></i>
                                                        </a>
                                                        <a class="btn btn-warning btn-sm" role="button" data-bs-toggle="tooltip" data-bss-tooltip="" style="margin: 2px;" title="Thông tin chi tiết" href="<%=request.getContextPath()%>/update-customer?id=${customer.ID}">
                                                            <i class="la la-edit"></i>
                                                        </a>

                                                    </td>
                                                </tr>

                                            </tbody>
                                        </c:forEach>
                                    </table>
                                </div>
                                <div class="row">
                                    <div class="col-md-6 align-self-center">
                                        <p id="dataTable_info" class="dataTables_info" role="status" aria-live="polite">
                                            Hiển thị ${requestScope.currentPage * requestScope.pageSize < requestScope.customerCount ? requestScope.currentPage * requestScope.pageSize : requestScope.customerCount} 
                                            trên ${requestScope.customerCount} khách hàng
                                        </p>
                                    </div>

                                    <div class="col-md-6">
                                        <nav class="d-lg-flex justify-content-lg-end dataTables_paginate paging_simple_numbers">
                                            <ul class="pagination">

                                                <li class="page-item ${requestScope.currentPage == 1 ? 'disabled' : ''}">
                                                    <a class="page-link" aria-label="Previous" href="customer?page=${requestScope.currentPage - 1}">
                                                        <span aria-hidden="true">«</span>
                                                    </a>
                                                </li>

                                                <c:forEach begin="1" end="${requestScope.totalPages}" var="pageIndex">

                                                    <li class="page-item ${pageIndex == requestScope.currentPage ? 'active' : ''}">
                                                        <a class="page-link" href="customer?page=${pageIndex}">${pageIndex}</a>
                                                    </li>

                                                </c:forEach>

                                                <li class="page-item ${requestScope.currentPage == requestScope.totalPages ? 'disabled' : ''}"> 
                                                    <a class="page-link" aria-label="Next" href="customer?page=${requestScope.currentPage + 1}">
                                                        <span aria-hidden="true">»</span>
                                                    </a>
                                                </li>
                                            </ul>
                                        </nav>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>                                            
                <%@include file="../../../common/_footer.jsp" %>                         
            </div>
            <%@include file="../../../common/_goback.jsp" %>
        </div>

        <script src="<%=request.getContextPath()%>/view/assets/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/view/assets/js/bs-init.js"></script>
        <script src="<%=request.getContextPath()%>/view/assets/js/theme.js"></script>
    </body>

</html>
