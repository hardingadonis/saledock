<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html data-bs-theme="light" lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Table - Brand</title>
        <link rel="icon" type="image/png" sizes="512x512" href="<%=request.getContextPath()%>/view/assets/imgages/favicon/favicon.png">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/assets/fonts/fontawesome-all.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/assets/fonts/line-awesome.min.css">
    </head>

    <body id="page-top">

        <%@ include file="../../common/sidenav.jsp"%>
        <%@ include file="../../common/nav.jsp"%>
        <div id="wrapper">
            <nav class="navbar align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0 navbar-dark">
                <div class="container-fluid d-flex flex-column p-0"><a class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0" href="#">
                        <div class="sidebar-brand-icon rotate-n-15"><i class="la la-balance-scale"></i></div>
                        <div class="sidebar-brand-text mx-3"><span>SALE DOCK</span></div>
                    </a>
                    <hr class="sidebar-divider my-0">
                    <ul class="navbar-nav text-light" id="accordionSidebar">
                        <li class="nav-item"><a class="nav-link" href="index.html"><i class="fas fa-tachometer-alt"></i><span>Bảng điều khiển</span></a></li>
                        <li class="nav-item"></li>
                        <li class="nav-item"></li>
                        <li class="nav-item"></li>
                        <li class="nav-item"><a class="nav-link active" href="customer.html" title="Quản lý khách hàng"><i class="fas fa-table"></i><span>Khách hàng</span></a><a class="nav-link" href="product.html" title="Quản lý khách hàng"><i class="fas fa-table"></i><span data-bs-toggle="tooltip" data-bss-tooltip="" data-bs-placement="right" title="Quản lý sản phẩm">Sản phẩm</span></a><a class="nav-link" href="order.html" title="Quản lý khách hàng"><i class="fas fa-table"></i><span data-bs-toggle="tooltip" data-bss-tooltip="" data-bs-placement="right" title="Quản lý sản phẩm">Đơn hàng</span></a></li>
                    </ul>
                    <div class="text-center d-none d-md-inline"><button class="btn rounded-circle border-0" id="sidebarToggle" type="button"></button></div>
                </div>
            </nav>
            <div class="d-flex flex-column" id="content-wrapper">
                <div id="content">
                    <nav class="navbar navbar-expand bg-white shadow mb-4 topbar static-top navbar-light">
                        <div class="container-fluid"><button class="btn btn-link d-md-none rounded-circle me-3" id="sidebarToggleTop" type="button"><i class="fas fa-bars"></i></button>
                            <ul class="navbar-nav flex-nowrap ms-auto">
                                <li class="nav-item dropdown no-arrow">
                                    <div class="nav-item dropdown no-arrow"><a class="dropdown-toggle nav-link" aria-expanded="false" data-bs-toggle="dropdown" href="#"><span class="d-none d-lg-inline me-2 text-gray-600 small">Valerie Luna</span><img class="border rounded-circle img-profile" src="<%=request.getContextPath()%>assets/img/avatars/employee.png"></a>
                                        <div class="dropdown-menu shadow dropdown-menu-end animated--grow-in"><a class="dropdown-item" href="#"><i class="fas fa-sign-out-alt fa-sm fa-fw me-2 text-gray-400"></i>&nbsp;Logout</a></div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </nav>
                    <div class="container-fluid">
                        <h3 class="text-dark mb-4">Khách hàng</h3>
                        <div class="card shadow">
                            <div class="card-header d-xxl-flex justify-content-between align-items-center align-items-xxl-center py-3">
                                <p class="text-primary m-0 fw-bold">Quản lý khách hàng</p><a class="btn btn-primary btn-sm" role="button" href="add-customer.html">Thêm khách hàng</a>
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
                                        <c:forEach items="${sessionScope.listC}" var="customer">
                                            <tbody>
                                                <tr>
                                                    <td><img class="rounded-circle me-2" width="30" height="30" src="<%=request.getContextPath()%>/view/assets/images/icons/customer.png">${customer.name}</td>
                                                    <td>${customer.code}</td>
                                                    <td>${customer.email}</td>
                                                    <td class="text-start"><a class="btn btn-primary btn-sm" role="button" data-bs-toggle="tooltip" data-bss-tooltip="" style="margin: 2px;" title="Thông tin chi tiết" href="<%=request.getContextPath()%>customer-detail.html"><i class="la la-info-circle"></i></a><button class="btn btn-warning btn-sm" data-bs-toggle="tooltip" data-bss-tooltip="" type="button" style="margin: 2px;" title="Chỉnh sửa"><i class="la la-edit"></i></button></td>
                                                </tr>

                                            </tbody>
                                        </c:forEach>
                                    </table>
                                </div>
                                <div class="row">
                                    <div class="col-md-6 align-self-center">
                                        <p id="dataTable_info" class="dataTables_info" role="status" aria-live="polite">Hiển thị 1 trên 1 khách hàng</p>
                                    </div>
                                    <div class="col-md-6">
                                        <nav class="d-lg-flex justify-content-lg-end dataTables_paginate paging_simple_numbers">
                                            <ul class="pagination">
                                                <li class="page-item disabled"><a class="page-link" aria-label="Previous" href="<%=request.getContextPath()%>#"><span aria-hidden="true">«</span></a></li>
                                                <li class="page-item active"><a class="page-link" href="<%=request.getContextPath()%>#">1</a></li>
                                                <li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>#">2</a></li>
                                                <li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>#">3</a></li>
                                                <li class="page-item"><a class="page-link" aria-label="Next" href="<%=request.getContextPath()%>#"><span aria-hidden="true">»</span></a></li>
                                            </ul>
                                        </nav>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <footer class="bg-white sticky-footer">
                    <div class="container my-auto">
                        <div class="text-center my-auto copyright">
                            <h6>Copyright © Sale Dock 2024</h6><a href="https://github.com/hardingadonis/saledock" target="_blank"><img class="img-fluid" src="https://contrib.rocks/image?repo=hardingadonis/saledock" style="transform: scale(0.70);"></a>
                        </div>
                    </div>
                </footer>
            </div><a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a>
        </div>
        <script src="<%=request.getContextPath()%>/view/assets/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/view/assets/js/bs-init.js"></script>
        <script src="<%=request.getContextPath()%>/view/assets/js/theme.js"></script>
        <%@ include file="../../common/footer.jsp"%>
        <%@ include file="../../common/goback.jsp"%>
    </body>

</html>
