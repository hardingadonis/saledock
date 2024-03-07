<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@page import="io.hardingadonis.saledock.utils.Singleton" %>

<!DOCTYPE html>
<html data-bs-theme="light" lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Sale Dock - Thêm khách hàng</title>
        <link rel="icon" type="image/png" sizes="512x512" href="<%=request.getContextPath()%>/view/assets/images/favicon/favicon.png">

        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://f...content-available-to-author-only...s.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
        <link rel="stylesheet" href="https://c...content-available-to-author-only...e.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
        <link rel="stylesheet" href="https://c...content-available-to-author-only...e.com/ajax/libs/line-awesome/1.3.0/line-awesome/css/line-awesome.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/assets/css/animate.min.css">

    </head>

    <body id="page-top">
        <div id="wrapper">
            <%@include file="../../../common/_sidenav.jsp" %>
            <div class="d-flex flex-column" id="content-wrapper">
                <div id="content">
                    <%@include file="../../../common/_nav.jsp" %>
                    <div class="container-fluid">
                        <h3 class="text-dark mb-4">Thêm khách hàng mới</h3>
                        <div class="row justify-content-center mb-3">
                            <div class="col-lg-8">
                                <div class="row">
                                    <div class="col">
                                        <div class="card shadow mb-3">
                                            <div class="card-header py-3">
                                                <p class="text-primary m-0 fw-bold">Thêm khách hàng mới</p>
                                            </div>
                                            <div class="card-body">
                                                <form action="./add-customer" method="post" id="form-add-customer">
                                                    <div class="row">
                                                        <div class="col">
                                                            <div class="mb-3 form-group">
                                                                <label class="form-label" for="name">
                                                                    <strong>Tên khách hàng</strong>
                                                                </label>
                                                                <div class="mb-3 form-group">
                                                                    <input class="form-control" type="text" id="name-customer" placeholder="Nhập tên khách hàng" name="name" >
                                                                    <span class="form-message text-danger"></span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col">
                                                            <div class="mb-3">
                                                                <label class="form-label" for="code">
                                                                    <strong>Mã khách hàng</strong>
                                                                </label>
                                                                <div class="mb-3 form-group">
                                                                    <input class="form-control" type="text" id="code-customer" placeholder="Mã khách hàng" name="code" >
                                                                    <span class="form-message text-danger"></span>
                                                                </div> 
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="mb-3">
                                                        <div class="mb-3">
                                                            <label class="form-label" for="address">
                                                                <strong>Địa chỉ</strong>
                                                            </label>
                                                            <div class="mb-3 form-group">
                                                                <input class="form-control" type="text" id="address-customer" placeholder="Nhập địa chỉ của khách hàng" name="address"  >
                                                                <span class="form-message text-danger"></span>
                                                            </div>
                                                        </div>
                                                        <div class="mb-3">
                                                            <label class="form-label" for="email">
                                                                <strong>Email</strong>
                                                            </label>
                                                            <div class="mb-3 form-group">
                                                                <input class="form-control" type="email" id="email-customer" placeholder="Nhập email khách hàng" name="email"  >
                                                                <span class="form-message text-danger"></span>
                                                            </div>
                                                        </div>
                                                        <button class="btn btn-primary btn-sm" type="submit">Lưu lại</button>
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
        <script src="<%=request.getContextPath()%>/view/assets/js/validate/validator.js"></script>

        <script>
            Validator({
                form: '#form-add-customer',
                errorSelector: '.form-message',
                formGroupSelector: '.form-group',
                rules: [
                    Validator.isRequired('#name-customer', 'Vui lòng nhập tên khách hàng!'),
                    Validator.isRequired('#code-customer', 'Vui lòng nhập mã khách hàng!'),
                    Validator.isRequired('#address-customer', 'Vui lòng nhập mã khách hàng!'),
                    Validator.isRequired('#email-customer', 'Vui lòng nhập mã khách hàng!')


                ]
            });
        </script>
    </body>

</html>