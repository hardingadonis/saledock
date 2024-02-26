<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html data-bs-theme="light" lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Sale Dock - Thêm sản phẩm vào đơn hàng</title>
        <link rel="icon" type="image/png" sizes="512x512" href="<%=request.getContextPath()%>/view/assets/images/favicon/favicon.png">

        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/assets/fonts/fontawesome-all.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/assets/fonts/line-awesome.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/assets/css/animate.min.css">
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/assets/css/validate/validator.css">

    </head>

    <body id="page-top">
        <div id="wrapper">
            <%@include file="../../../common/_sidenav.jsp" %>
            <div class="d-flex flex-column" id="content-wrapper">
                <div id="content">
                    <%@include file="../../../common/_nav.jsp" %>
                    <div class="container-fluid">
                        <h3 class="text-dark mb-4">Thêm sản phẩm vào đơn hàng</h3>
                        <div class="row justify-content-center mb-3">
                            <div class="col-lg-8 col-xxl-10">
                                <div class="row">
                                    <div class="col-xxl-12">
                                        <div class="card shadow mb-3">
                                            <c:choose>
                                                <c:when test="${requestScope.message eq 'productNotExist'}">
                                                    <div class="alert alert-danger text-center" role="alert">
                                                        Sản phẩm không tồn tại. Vui lòng kiểm tra lại thông tin sản phẩm.
                                                    </div>
                                                </c:when>
                                                <c:when test="${requestScope.message eq 'notInputProduct'}">
                                                    <div class="alert alert-danger text-center" role="alert">
                                                        Chưa nhập tên sản phẩm. Vui lòng kiểm tra lại.
                                                    </div>
                                                </c:when>
                                                <c:when test="${requestScope.message eq 'productNotExist'}">
                                                    <div class="alert alert-danger text-center" role="alert">
                                                        Chưa nhập số lượng sản phẩm cần mua. Vui lòng kiểm tra lại.
                                                    </div>
                                                </c:when>
                                                <c:when test="${requestScope.message eq 'missingCustomer'}">
                                                    <div class="alert alert-danger text-center" role="alert">
                                                        Tên người dùng bị trống. Vui lòng kiểm tra và nhập vào.
                                                    </div>
                                                </c:when>
                                            </c:choose>
                                            <div class="card-header py-3">
                                                <p class="text-primary m-0 fw-bold">Thông tin sản phẩm</p>
                                            </div>
                                            <div class="card-body">
                                                <form id="form-add-product-into-order" method="post">
                                                    <div class="row">
                                                        <div class="col">
                                                            <div class="mb-3 form-group">
                                                                <input type="hidden" id="product-id" name="productId" />
                                                                <label class="form-label"><strong>Tên sản phẩm</strong></label>
                                                                <input class="form-control" type="text" id="product-name" name="productName">
                                                                <span class="form-message"></span>
                                                            </div>
                                                        </div>
                                                        <div class="col">
                                                            <div class="mb-3">
                                                                <label class="form-label"><strong>Đơn giá</strong></label>
                                                                <input class="form-control" id="product-price" name="productPrice" readonly="">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col">
                                                            <div class="mb-3 form-group">
                                                                <label class="form-label"><strong>Số lượng</strong></label>
                                                                <div class="input-group">    
                                                                    <button class="btn btn-outline-secondary" type="button" onclick="decrementQuantity(this)">-</button>
                                                                    <input type="number" class="form-control" id="product-quantity" name="productQuantity" min="1" onchange="calculateTotal(this)">
                                                                    <button class="btn btn-outline-secondary" type="button" onclick="incrementQuantity(this)">+</button>
                                                                </div>
                                                                <span class="form-message"></span>
                                                            </div>
                                                        </div>
                                                        <div class="col">
                                                            <div class="mb-3 form-group">
                                                                <label class="form-label"><strong>Thành tiền</strong></label>
                                                                <input class="form-control" id="product-total-price" name="productTotalPrice" readonly="">
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="mb-3">
                                                        <button class="btn btn-primary btn-sm" id="save-button" type="submit">Thêm vào đơn hàng</button>
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

            <!--Danh sach goi y-->
            <script>
                $(document).ready(function () {
                    var availableProducts = [
                        <c:forEach var="product" items="${requestScope.products}">
                            "${product.name}",
                        </c:forEach>
                    ];
                    $("#product-name").autocomplete({
                        source: availableProducts,
                        select: function( event, ui ) {
                            var selectedProduct = ui.item.value;
                            <c:forEach var="product" items="${requestScope.products}">
                                if("${product.name}" === selectedProduct) {
                                    $('#product-id').val("${product.ID}");
                                    $('#product-price').val(formatCurrency("${product.price}"));
                                    $('#product-quantity').val(1);
                                }
                            </c:forEach>
                            calculateTotal();
                        }
                    });
                });
            </script>

            <!--Validate input-->
            <script>
                //Validate form add product into order
                Validator({
                    form: '#form-add-product-into-order',
                    errorSelector: '.form-message',
                    formGroupSelector: '.form-group',
                    rules: [
                        Validator.isRequired('#product-name', 'Vui lòng nhập tên sản phẩm!'),
                        Validator.isRequired('#product-quantity', 'Vui lòng nhập số lượng sản phẩm!')
                    ]
                });
            </script>

            <script>
                function incrementQuantity(button) {
                    var input = $(button).siblings('input[name="productQuantity"]');
                    var value = parseInt(input.val());
                    input.val(value + 1);
                    calculateTotal(input);
                }

                function decrementQuantity(button) {
                    var input = $(button).siblings('input[name="productQuantity"]');
                    var value = parseInt(input.val());
                    if (value > 1) {
                        input.val(value - 1);
                        calculateTotal(input);
                    }
                }

                function calculateTotal() {
                    var quantity = parseInt($('#product-quantity').val());
                    var price = parseFloat($('#product-price').val().replace(/[^0-9.-]+/g, '')) * 1000;
                    var total = quantity * price;
                    
                    $('#product-total-price').val(formatCurrency(total));
                }

                function formatCurrency(number) {
                    return Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND', minimumFractionDigits: 0 }).format(number);
                    
                }
                
                $('#product-quantity').change(calculateTotal);
            </script>

    </body>

</html>