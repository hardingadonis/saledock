<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html data-bs-theme="light" lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Sale Dock - Thêm đơn hàng</title>
        <link rel="icon" type="image/png" sizes="512x512" href="<%=request.getContextPath()%>/view/assets/images/favicon/favicon.png">

        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">        
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/assets/fonts/fontawesome-all.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/assets/fonts/line-awesome.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/assets/css/animate.min.css">
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/assets/css/validate/validator.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/assets/css/sweetalert2.min.css">

    </head>

    <body id="page-top">
        <div id="wrapper">
            <%@include file="../../../common/_sidenav.jsp" %>
            <div class="d-flex flex-column" id="content-wrapper">
                <div id="content">
                    <%@include file="../../../common/_nav.jsp" %>
                    <div class="container-fluid">
                        <h3 class="text-dark mb-4">Thêm đơn hàng mới</h3>
                        <div class="row justify-content-center mb-3">
                            <div class="col-lg-8 col-xxl-10">
                                <div class="row">
                                    <div class="col-xxl-12">
                                        <div class="card shadow mb-3">
                                            <c:choose>
                                                <c:when test="${param.message eq 'addSuccess'}">
                                                    <div class="alert alert-success text-center" role="alert">
                                                        Thêm sản phẩm thành công.
                                                    </div>
                                                </c:when>
                                                <c:when test="${param.message eq 'deleteSuccess'}">
                                                    <div class="alert alert-success text-center" role="alert">
                                                        Xoá sản phẩm thành công.
                                                    </div>
                                                </c:when>
                                                <c:when test="${param.message eq 'emptyProduct'}">
                                                    <div class="alert alert-danger text-center" role="alert">
                                                        Chưa có sản phẩm nào được thêm. Vui lòng thêm sản phẩm vào đơn hàng.
                                                    </div>
                                                </c:when>
                                                <c:when test="${param.message eq 'productNotExist'}">
                                                    <div class="alert alert-danger text-center" role="alert">
                                                        Sản phẩm không tồn tại. Vui lòng kiểm tra lại thông tin sản phẩm.
                                                    </div>
                                                </c:when>
                                                <c:when test="${param.message eq 'customerNotExist'}">
                                                    <div class="alert alert-danger text-center" role="alert">
                                                        Người dùng không tồn tại. Vui lòng kiểm tra lại.
                                                    </div>
                                                </c:when>
                                            </c:choose>
                                            <div class="card-header py-3">
                                                <p class="text-primary m-0 fw-bold">Thông tin đơn hàng</p>
                                            </div>
                                            <div class="card-body">
                                                <form id="form-add-order" method="post">
                                                    <div class="row">
                                                        <div class="col">
                                                            <div class="mb-3 form-group">
                                                                <input type="hidden" id="cus-id" name="customerId" value="${customerId}" />
                                                                <label class="form-label" for="username"><strong>Tên Khách hàng</strong></label>
                                                                <input class="form-control" id="cus-name" name="customerName"">
                                                                <span class="form-message"></span>
                                                            </div>
                                                        </div>
                                                        <div class="col">
                                                            <div class="row">
                                                                <div class="mb-3 form-group">
                                                                    <label class="form-label" for="text"><strong>Tổng tiền</strong></label>
                                                                    <fmt:formatNumber value="${totalCost}" type="currency" currencySymbol="₫" pattern="#,##0 ¤" var="formattedTotalCost" />
                                                                    <input class="form-control" type="text" id="total-cost" readonly="" value="${formattedTotalCost}">
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col">
                                                            <label class="form-label" for="username"><strong>Danh sách sản phẩm</strong></label>
                                                            <div class="table-responsive">
                                                                <table class="table" id="add-product-table">
                                                                    <thead>
                                                                        <tr>
                                                                            <th>STT</th>
                                                                            <th>Tên sản phẩm</th>
                                                                            <th>Đơn giá</th>
                                                                            <th>Số lượng</th>
                                                                            <th>Thành tiền</th>
                                                                            <th></th>
                                                                        </tr>
                                                                    </thead>
                                                                    <tbody>
                                                                        <c:forEach var="entry" items="${productMap}">
                                                                            <c:set var="productId" value="${entry.key}" />
                                                                            <c:set var="quantity" value="${entry.value}" />

                                                                            <c:forEach var="product" items="${products}">
                                                                                <c:if test="${product.ID eq productId}">
                                                                                    <tr>
                                                                                        <td class="stt"></td>
                                                                                        <td>${product.name}</td>
                                                                                        <td><fmt:formatNumber type="currency" value="${product.price}" currencySymbol="₫" pattern="#,##0 ¤" /></td>
                                                                                        <td>${quantity}</td>
                                                                                        <td><fmt:formatNumber type="currency" value="${product.price * quantity}" currencySymbol="₫" pattern="#,##0 ¤" /></td>
                                                                                        <td>
                                                                                            <button class="btn btn-danger btn-sm" type="button" id="delete-button">
                                                                                                <i class="la la-trash"></i>
                                                                                            </button>
                                                                                        </td>
                                                                                    </tr>
                                                                                </c:if>
                                                                            </c:forEach>
                                                                        </c:forEach>
                                                                    </tbody>
                                                                </table>
                                                            </div>
                                                            <button class="btn btn-primary btn-sm" type="button" id="add-product-btn" style="margin-bottom: 15px;" onclick="redirectToAddProductPage()">
                                                                Thêm sản phẩm vào đơn hàng <i class="la la-plus"></i>
                                                            </button>
                                                        </div>
                                                    </div>
                                                    <div class="mb-3">
                                                        <div class="mb-3">
                                                            <label class="form-label" for="country"><strong>Ghi chú</strong></label>
                                                            <textarea class="form-control" name="note"></textarea>
                                                        </div>
                                                        <button class="btn btn-primary btn-sm" id="back-button" type="button" onclick="goBack()">Quay lại</button>
                                                        <button class="btn btn-primary btn-sm" id="save-button" type="submit">Lưu lại</button>
                                                    </div>
                                                </form>
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
            <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
            <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
            <script src="<%=request.getContextPath()%>/view/assets/js/validate/validator.js"></script>
            <script src="<%=request.getContextPath()%>/view/assets/js/sweetalert2.all.min.js"></script>
            <script src="<%=request.getContextPath()%>/view/assets/js/management/order/add-order/confirm-popup.js"></script>
            <script src="<%=request.getContextPath()%>/view/assets/js/alert-timeout.js"></script>

            <!--Danh sach goi y-->
            <script>
                $(document).ready(function () {
                    var customerIdInput = $('#cus-id');
                    var customerNameInput = $('#cus-name');
                    var customerIdParam = '<%= request.getParameter("customerId") %>';
                    var customerIdAttribute = '<%= request.getAttribute("customerId") %>';
                    
                    var selectedCustomerId = customerIdParam.trim() !== '' ? customerIdParam : customerIdAttribute;
                    
                    var customers = [
                        <c:forEach var="customer" items="${requestScope.customers}">
                            { label: "${customer.name}", value: "${customer.ID}" },
                        </c:forEach>
                    ];

                    customerNameInput.autocomplete({
                        source: function (request, response) {
                            var term = request.term.toLowerCase();
                            var suggestions = customers.filter(function (customer) {
                                return customer.label.toLowerCase().indexOf(term) !== -1;
                            });
                            response(suggestions);
                        },
                        select: function (event, ui) {
                            $('#cus-name').val(ui.item.label);
                            $('#cus-id').val(ui.item.value);
                            return false;
                        }
                    });
                    
                    customerNameInput.focusout(function () {
                        if (customerNameInput.val().trim() === '') {
                            customerIdInput.val('');
                        }
                    });

                    if (customerIdParam && customerIdParam.trim() !== '') {
                        var selectedCustomer = customers.find(function (customer) {
                            return customer.value === customerIdParam;
                        });
                        if (selectedCustomer) {
                            $('#cus-name').val(selectedCustomer.label);
                            $('#cus-id').val(selectedCustomer.value);
                        } else {
                            $('#cus-name').val('');
                            $('#cus-id').val('');
                        }
                    } else {
                        $('#cus-name').val('');
                        $('#cus-id').val('');
                    }
                });
            </script>

            <!--Validate input-->
            <script>
                //Validate form add order
                Validator({
                    form: '#form-add-order',
                    errorSelector: '.form-message',
                    formGroupSelector: '.form-group',
                    rules: [
                        Validator.isRequired('#cus-name', 'Vui lòng nhập tên khách hàng!')
                    ]
                });
            </script>
            
            <script>
                function redirectToAddProductPage() {
                    var customerId = encodeURIComponent($('#cus-id').val());

                    window.location.href = '<%=request.getContextPath()%>/add-product-into-order?customerId=' + customerId;
                }
                
                function goBack(){
                    window.location.href = '<%=request.getContextPath()%>/add-order?action=goBack';
                }                   
            </script>
            
            <script>
                document.addEventListener('DOMContentLoaded', function () {
                    var rows = document.querySelectorAll('#add-product-table tbody tr');

                    rows.forEach(function (row, index) {
                        var sttCell = row.querySelector('.stt');
                        sttCell.textContent = index + 1;
                    });
                });
            </script>
            
            <script>
                $("#delete-button").click(function(event) {
                    event.preventDefault();
                    confirmDelete(${productId}, ${customerId});
                });
                
                $("#save-button").click(function(event) {
                    event.preventDefault();
                    confirmAddOrder(${customerId});
                });
            </script>

    </body>

</html>