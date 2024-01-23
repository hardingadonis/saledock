<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@page import="io.hardingadonis.saledock.utils.Singleton" %>

<!DOCTYPE html>
<html data-bs-theme="light" lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Sale Dock - Bảng điều khiển</title>
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
                        <div class="d-sm-flex justify-content-between align-items-center mb-4">
                            <h3 class="text-dark mb-0">Bảng điều khiển</h3>

                            <div class="d-inline-flex">
                                <div class="me-3 d-inline-flex">
                                    <label for="duration">
                                        <strong>
                                            Khoảng thời gian
                                        </strong>
                                    </label>
                                    <select class="form-select form-select-sm" id="duration">
                                        <option value="today" selected>Hôm nay</option>
                                        <option value="yesterday">Hôm qua</option>
                                        <option value="1-week-ago">1 tuần trước</option>
                                        <option value="1-month-ago">1 tháng trước</option>
                                        <option value="3-month-ago">3 tháng trước</option>
                                        <option value="6-month-ago">6 tháng trước</option>
                                    </select>
                                </div>

                                <button class="ms-3 btn btn-primary btn-sm d-none d-sm-inline-block">
                                    <i class="fas fa-download fa-sm text-white-50"></i>&nbsp;Tải báo cáo
                                </button>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-6 col-xl-4 mb-4" data-bss-hover-animate="pulse">
                                <div class="card shadow border-start-primary py-2">
                                    <div class="card-body">
                                        <div class="row align-items-center no-gutters">
                                            <div class="col me-2">
                                                <div class="text-uppercase text-primary fw-bold text-xs mb-1"><span>Tổng số khách hàng</span></div>
                                                <div class="text-dark fw-bold h5 mb-0"><span>🤝 ${Singleton.customerDAO.count()} khách hàng</span></div>
                                            </div>
                                            <div class="col-auto"><i class="fas fa-table fa-2x text-gray-300"></i></div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-6 col-xl-4 mb-4" data-bss-hover-animate="pulse">
                                <div class="card shadow border-start-success py-2">
                                    <div class="card-body">
                                        <div class="row align-items-center no-gutters">
                                            <div class="col me-2">
                                                <div class="text-uppercase text-success fw-bold text-xs mb-1"><span>Tổng số sản phẩm</span></div>
                                                <div class="text-dark fw-bold h5 mb-0"><span>📦 ${Singleton.productDAO.count()} sản phẩm</span></div>
                                            </div>
                                            <div class="col-auto"><i class="fas fa-table fa-2x text-gray-300"></i></div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-6 col-xl-4 mb-4" data-bss-hover-animate="pulse">
                                <div class="card shadow border-start-warning py-2">
                                    <div class="card-body">
                                        <div class="row align-items-center no-gutters">
                                            <div class="col me-2">
                                                <div class="text-uppercase text-warning fw-bold text-xs mb-1"><span>Tổng số đơn hàng</span></div>
                                                <div class="text-dark fw-bold h5 mb-0"><span>🛒 ${Singleton.orderDAO.countOrderInProcess()} đơn hàng cần được xử lý</span></div>
                                            </div>
                                            <div class="col-auto"><i class="fas fa-table fa-2x text-gray-300"></i></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-7 col-xl-8">
                                <div class="card shadow mb-4">
                                    <div class="card-header d-flex justify-content-between align-items-center">
                                        <h6 class="text-primary fw-bold m-1">Đơn hàng (đã bán)</h6>
                                    </div>
                                    <div class="card-body">
                                        <div class="chart-area">
                                            <canvas id="order-by-sold"></canvas>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-5 col-xl-4">
                                <div class="card shadow mb-4">
                                    <div class="card-header d-flex justify-content-between align-items-center">
                                        <h6 class="text-primary fw-bold m-1">Đơn hàng (theo trạng thái)</h6>
                                    </div>
                                    <div class="card-body">
                                        <div class="chart-area">
                                            <canvas id="order-by-status"></canvas>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-7 col-xl-8">
                                <div class="card shadow mb-4">
                                    <div class="card-header d-flex justify-content-between align-items-center">
                                        <h6 class="text-primary fw-bold m-1">Top 10 khách hàng mua nhiều nhất</h6>
                                    </div>
                                    <div class="card-body">
                                        <div class="chart-area">
                                            <canvas id="customer-top-10"></canvas>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-5 col-xl-4">
                                <div class="card shadow mb-4">
                                    <div class="card-header d-flex justify-content-between align-items-center">
                                        <h6 class="text-primary fw-bold m-1">Top 10 sản phẩm được mua nhiều nhất</h6>
                                    </div>
                                    <div class="card-body">
                                        <div class="chart-area">
                                            <canvas id="product-top-10"></canvas>
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

        <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.1/dist/chart.umd.min.js"></script>
        <script src="<%=request.getContextPath()%>/view/assets/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/view/assets/js/bs-init.js"></script>
        <script src="<%=request.getContextPath()%>/view/assets/js/theme.js"></script>
        <script src="<%=request.getContextPath()%>/view/assets/js/others/dashboard/dashboard.js"></script>
    </body>

</html>