<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@page import="io.hardingadonis.saledock.utils.Singleton" %>

<!DOCTYPE html>
<html data-bs-theme="light" lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Customer Detail - Brand</title>
        <link rel="icon" type="image/png" sizes="512x512" href="<%=request.getContextPath()%>/view/assets/images/favicon/favicon.png">
        
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/line-awesome/1.3.0/line-awesome/css/line-awesome.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/assets/css/animate.min.css">
    </head>

    <body id="page-top">
        <div id="wrapper">
            <%@include file="../../../common/_sidenav.jsp" %>
            <div class="d-flex flex-column" id="content-wrapper">
                <div id="content">
                    <%@include file="../../../common/_nav.jsp" %>
                    <div class="container-fluid">
                        <h3 class="text-dark mb-4">Thông tin khách hàng</h3>
                        <div class="row justify-content-center mb-3">
                            <div class="col-lg-8">
                                <div class="row mb-3 d-none">
                                    <div class="col">
                                        <div class="card text-white bg-primary shadow">
                                            <div class="card-body">
                                                <div class="row mb-2">
                                                    <div class="col">
                                                        <p class="m-0">Peformance</p>
                                                        <p class="m-0"><strong>65.2%</strong></p>
                                                    </div>
                                                    <div class="col-auto"><i class="fas fa-rocket fa-2x"></i></div>
                                                </div>
                                                <p class="text-white-50 small m-0"><i class="fas fa-arrow-up"></i>&nbsp;5% since last month</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col">
                                        <div class="card text-white bg-success shadow">
                                            <div class="card-body">
                                                <div class="row mb-2">
                                                    <div class="col">
                                                        <p class="m-0">Peformance</p>
                                                        <p class="m-0"><strong>65.2%</strong></p>
                                                    </div>
                                                    <div class="col-auto"><i class="fas fa-rocket fa-2x"></i></div>
                                                </div>
                                                <p class="text-white-50 small m-0"><i class="fas fa-arrow-up"></i>&nbsp;5% since last month</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <div class="card shadow mb-3">
                                            <div class="card-header py-3">
                                                <p class="text-primary m-0 fw-bold">Thông tin khách hàng</p>
                                            </div>
                                            <div class="card-body">
                                                <form>
                                                    <div class="row">
                                                        
                                                        <div class="col">
                                                            <div class="mb-3"><label class="form-label" for="username"><strong>Tên khách hàng</strong></label>
                                                                <input class="form-control" type="text" id="username" placeholder="Nhập tên khách hàng" name="username" readonly="">
                                                            </div>
                                                        </div>

                                                        <div class="col">
                                                            <div class="mb-3"><label class="form-label" for="email"><strong>Mã khách hàng</strong></label>
                                                                <input class="form-control" type="email" id="email" placeholder="Mã khách hàng" name="email" readonly="">
                                                            </div>
                                                        </div>
                                                        
                                                    </div>
                                                    
                                                    <div class="mb-3">
                                                        
                                                        <div class="mb-3"><label class="form-label" for="address"><strong>Địa chỉ</strong></label>
                                                            <input class="form-control" type="text" id="address" placeholder="Nhập địa chỉ của khách hàng" name="address" readonly="">
                                                        </div>
                                                        
                                                        <div class="mb-3"><label class="form-label" for="country"><strong>Email</strong></label>
                                                            <input class="form-control" type="text" id="country" placeholder="Nhập email khách hàng" name="country" readonly="">
                                                        </div>
                                                        
                                                        <button class="btn btn-primary btn-sm" type="button">Quay lại</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
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