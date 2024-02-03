<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<<<<<<< HEAD
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
=======

>>>>>>> 34617db1c335c459baa5b86a8dd0d1839a565a08
<%@page import="io.hardingadonis.saledock.utils.Singleton" %>

<!DOCTYPE html>
<html data-bs-theme="light" lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<<<<<<< HEAD
        <title>Sale Dock - Chi tiết đơn hàng</title>
=======
        <title>Sale Dock - Thông tin đặt hàng</title>
>>>>>>> 34617db1c335c459baa5b86a8dd0d1839a565a08
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
<<<<<<< HEAD
                        <h3 class="text-dark mb-4">Thông tin đơn hàng</h3>
                        <div class="row justify-content-center mb-3">
                            <div class="col-lg-8 col-xxl-10">
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
                                    <div class="col-xxl-12">
                                        <div class="card shadow mb-3">
                                            <div class="card-header py-3">
                                                <p class="text-primary m-0 fw-bold">Thông tin đơn hàng</p>
=======
                        <h3 class="text-dark mb-4">Thông tin đặt hàng</h3>
                        <div class="row justify-content-center mb-3">
                            <div class="col-lg-8">
                                <div class="row">
                                    <div class="col">
                                        <div class="card shadow mb-3">
                                            <div class="card-header py-3">
                                                <p class="text-primary m-0 fw-bold">Thông tin đặt hàng</p>
>>>>>>> 34617db1c335c459baa5b86a8dd0d1839a565a08
                                            </div>
                                            <div class="card-body">
                                                <form>
                                                    <div class="row">
<<<<<<< HEAD
                                                        <div class="col">
                                                            <div class="mb-3">
                                                                <label class="form-label" for="username"><strong>Mã đơn hàng</strong></label>
                                                                <input class="form-control" type="text" id="username" value ="${requestScope.ord.code}" name="username" readonly="">
=======

                                                        <div class="col">
                                                            <div class="mb-3">
                                                                <label class="form-label" for="code"><strong>Mã đặt hàng</strong></label>
                                                                <input class="form-control" type="text" id="code" placeholder="${requestScope.ord.code}" name="code" readonly="">
                                                            </div>
                                                        </div>
                                                        
                                                        <div class="col">
                                                            <div class="mb-3">
                                                                <label class="form-label" for="customername"><strong>Tên khách hàng</strong></label>
                                                                <input class="form-control" type="text" id="customername" placeholder="${requestScope.ord.customer.name}" name="customername" readonly="">
>>>>>>> 34617db1c335c459baa5b86a8dd0d1839a565a08
                                                            </div>
                                                        </div>

                                                        <div class="col">
<<<<<<< HEAD
                                                            <div class="mb-3">
                                                                <label class="form-label" for="email"><strong>Ngày tạo</strong></label>
                                                                <input class="form-control" type="email" id="createAt" value ="${requestScope.ord.createdAt}" name="email" readonly="">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col">
                                                            <div class="mb-3">
                                                                <label class="form-label" for="username"><strong>Khách hàng</strong></label>
                                                                <input class="form-control" type="text" value ="${requestScope.ord.customer.name}" readonly="">
                                                            </div>
                                                        </div>
                                                        <div class="col">
                                                            <div class="mb-3">
                                                                <label class="form-label" for="email"><strong>Nhân viên phụ trách</strong></label>
                                                                <input class="form-control" type="email" id="email-1" value = "${requestScope.ord.employee.fullName}" name="email" readonly="">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col">
                                                            <div class="mb-3"><label class="form-label" for="username"><strong>Tổng tiền</strong></label>
                                                                <input class="form-control price" type ="text" value ="${requestScope.ord.total}" readonly="">
                                                            </div>
                                                        </div>

                                                        <div class="col">
                                                            <div class="mb-3"><label class="form-label" for="email"><strong>Trạng thái</strong></label>
                                                                <c:choose>
                                                                    <c:when test="${requestScope.ord.status.toString() == 'PENDING'}">
                                                                        <input class="form-control" type="email" id="email-2" value="Đang xử lý" name="email" readonly="">
                                                                    </c:when>
                                                                    <c:when test="${requestScope.ord.status == 'DONE'}">
                                                                        <input class="form-control" type="email" id="email-2" value="Đã xong" name="email" readonly="">
                                                                    </c:when>
                                                                    <c:when test="${requestScope.ord.status == 'CANCELLED'}">
                                                                        <input class="form-control" type="email" id="email-2" value="Đã hủy" name="email" readonly="">
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <input class="form-control" type="email" id="email-2" value="Đang giao" name="email" readonly="">
                                                                    </c:otherwise>
                                                                </c:choose>


                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col"><label class="form-label" for="username"><strong>Danh sách sản phẩm</strong></label>
                                                            <div class="table-responsive">
                                                                <table class="table">
                                                                    <thead>
                                                                        <tr>
                                                                            <th>STT</th>
                                                                            <th>Tên sản phẩm</th>
                                                                            <th>Đơn giá</th>
                                                                            <th>Số lượng</th>
                                                                            <th>Thành tiền</th>
                                                                        </tr>
                                                                    </thead>
                                                                    <tbody>
                                                                        <c:forEach var="orderDetail" items="${requestScope.ord.orderDetails}" varStatus="loop" begin="0">
                                                                            <tr>
                                                                                <td>${loop.index + 1}</td>
                                                                                <td>${orderDetail.product.name}</td>
                                                                                <td class="price">
                                                                                    ${orderDetail.product.price};
                                                                                </td>
                                                                                <td>${orderDetail.quantity}</td>
                                                                                <td class="price">
                                                                                    ${orderDetail.product.price * orderDetail.quantity};
                                                                                </td>
                                                                            </tr>
                                                                        </c:forEach>
                                                                    </tbody>
                                                                </table>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="mb-3">
                                                        <div class="mb-3">
                                                            <label class="form-label" for="country"><strong>Ghi chú</strong></label><textarea class="form-control" readonly=""></textarea>
=======
                                                            <div class="mb-3"><label class="form-label" for="status"><strong>Tình trạng đặt hàng</strong></label>
                                                                <input class="form-control" type="text" id="status" placeholder="${requestScope.ord.status}" name="status" readonly="">
                                                            </div>
                                                        </div>

                                                    </div>

                                                    <div class="mb-3">

                                                        <div class="mb-3"><label class="form-label" for="total"><strong>Tổng cộng</strong></label>
                                                            <input class="form-control" type="text" id="total" placeholder="${requestScope.ord.total}" name="total" readonly="">
                                                        </div>

                                                        <div class="mb-3"><label class="form-label" for="note"><strong>Ghi chú</strong></label>
                                                            <input class="form-control" type="text" id="note" placeholder="${requestScope.ord.note}" name="note" readonly="">
>>>>>>> 34617db1c335c459baa5b86a8dd0d1839a565a08
                                                        </div>

                                                        <button class="btn btn-primary btn-sm" type="button">
                                                            <a class="back" href="<%=request.getContextPath()%>/order" style="color: white; text-decoration: none;">Quay lại</a>
                                                        </button>
<<<<<<< HEAD
=======

>>>>>>> 34617db1c335c459baa5b86a8dd0d1839a565a08
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
<<<<<<< HEAD
        <script src="<%=request.getContextPath()%>/view/assets/js/management/order/order-detail.js"></script>
    </body>

</html>
=======
    </body>

</html>
>>>>>>> 34617db1c335c459baa5b86a8dd0d1839a565a08
