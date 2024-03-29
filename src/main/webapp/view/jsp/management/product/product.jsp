<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html data-bs-theme="light" lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Sale Dock - Quản lý sản phẩm</title>
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
                        <h3 class="text-dark mb-4">Sản phẩm</h3>
                        <div class="card shadow">
                            <div class="card-header d-xxl-flex justify-content-between align-items-center align-items-xxl-center py-3">
                                <p class="text-primary m-0 fw-bold">Quản lý sản phẩm</p>
                                <div>
                                    <a href="<%=request.getContextPath()%>/download?type=product" class="btn btn-primary btn-sm">Tải xuống danh sách</a>
                                    <a href="<%=request.getContextPath()%>/add-product" class="btn btn-primary btn-sm">Thêm sản phẩm</a>
                                </div>
                            </div>
                            <c:if test="${!requestScope.productList.isEmpty()}">
                                <div class="card-body">
                                    <div class="table-responsive table mt-2" id="dataTable" role="grid" aria-describedby="dataTable_info">
                                        <table class="table my-0" id="dataTable">
                                            <thead>
                                                <tr>
                                                    <th width="20%">Mã sản phẩm</th>
                                                    <th width="40%">Tên sản phẩm</th>
                                                    <th width="30%">Phân loại</th>
                                                    <th width="10%">Thao tác</th>
                                                </tr>
                                            </thead>
                                            <c:forEach items="${requestScope.productList}" var="product">
                                                <tbody>
                                                    <tr>
                                                        <td>${product.code}</td>
                                                        <td>${product.name}</td>
                                                        <td>${product.category.name}</td>
                                                        <td class="text-start">
                                                            <a class="btn btn-primary btn-sm" role="button" data-bs-toggle="tooltip" data-bss-tooltip="" style="margin: 2px;" title="Thông tin chi tiết" href="<%=request.getContextPath()%>/product-detail?id=${product.ID}">
                                                                <i class="la la-info-circle"></i>
                                                            </a>
                                                            <a class="btn btn-warning btn-sm" data-bs-toggle="tooltip" data-bss-tooltip="" style="margin: 2px;" title="Chỉnh sửa" href="<%=request.getContextPath()%>/update-product?id=${product.ID}" >
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
                                                Hiển thị ${requestScope.currentPage * requestScope.limit < requestScope.numOfPro ? requestScope.currentPage * requestScope.limit : requestScope.numOfPro}
                                                trên ${requestScope.numOfPro} sản phẩm
                                            </p>
                                        </div>
                                        <div class="col-md-6">
                                            <nav class="d-lg-flex justify-content-lg-end dataTables_paginate paging_simple_numbers">
                                                <ul class="pagination">
                                                    <li class="page-item ${requestScope.currentPage == 1 ? 'disabled' : ''}">
                                                        <a class="page-link" aria-label="Previous" href="<%=request.getContextPath()%>/product?page=${requestScope.currentPage - 1}"><span aria-hidden="true">«</span></a>
                                                    </li>
                                                    <c:forEach var="i" begin="1" end="${requestScope.totalPage}">
                                                        <li class="page-item ${i == requestScope.currentPage ? 'active' : ''}">
                                                            <a class="page-link" href="<%=request.getContextPath()%>/product?page=${i}">${i}</a>
                                                        </li>
                                                    </c:forEach>
                                                    <li class="page-item ${requestScope.currentPage == requestScope.totalPage ? 'disabled' : ''}">
                                                        <a class="page-link" aria-label="Next" href="<%=request.getContextPath()%>/product?page=${requestScope.currentPage + 1}"><span aria-hidden="true">»</span></a>
                                                    </li>
                                                </ul>
                                            </nav>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${requestScope.productList.isEmpty()}">
                                <div class="card-body">
                                    <div class="row">
                                        <h3 style="text-align: center;">Không có sản phẩm nào để quản lí.</h3>
                                    </div>
                                </div>
                            </c:if>
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
