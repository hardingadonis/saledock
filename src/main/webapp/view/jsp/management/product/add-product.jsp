<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="io.hardingadonis.saledock.utils.Singleton" %>

<!DOCTYPE html>
<html data-bs-theme="light" lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Sale Dock - Thêm sản phẩm</title>
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
                        <h3 class="text-dark mb-4">Thêm sản phẩm mới</h3>
                        <div class="row justify-content-center mb-3">
                            <div class="col-lg-8">
                                <div class="row">
                                    <div class="col">
                                        <div class="card shadow mb-3">
                                            <div class="card-header py-3">
                                                <p class="text-primary m-0 fw-bold">Thêm sản phẩm mới</p>
                                            </div>
                                            <div class="card-body">
                                                <form id="add-product" enctype="multipart/form-data" action="add-product" method="post">
                                                    <div class="row">

                                                        <div class="col">
                                                            <div class="mb-3">
                                                                <label class="form-label" for="email">
                                                                    <strong>Tên sản phẩm</strong>
                                                                </label>
                                                                <input class="form-control" type="text" id="nameP" placeholder="Nhập tên sản phẩm" name="nameP" required oninvalid="this.setCustomValidity('Vui lòng nhập Tên sản phẩm.')" oninput="this.setCustomValidity('')">
                                                            </div>
                                                        </div>

                                                        <div class="col">
                                                            <div class="mb-3">
                                                                <label class="form-label" for="username">
                                                                    <strong>Phân loại sản phẩm</strong>
                                                                </label>
                                                                <select class="form-control" name="categoryP" id="exampleFormControlSelect1" required="">
                                                                    <c:forEach items="${requestScope.categories}" var="cat">
                                                                        <option value="${cat.ID}">${cat.name}</option>
                                                                    </c:forEach>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col">
                                                            <div class="mb-3">
                                                                <label class="form-label" for="email">
                                                                    <strong>Giá tiền</strong>
                                                                </label>
                                                                <input class="form-control" type="number" id="priceP" placeholder="Nhập giá tiền sản phẩm" name="priceP" required min="0" oninvalid="this.setCustomValidity('Vui lòng nhập Giá sản phẩm.')" oninput="this.setCustomValidity('')">
                                                            </div>
                                                        </div>
                                                        <div class="col">
                                                            <div class="mb-3">
                                                                <label class="form-label" for="imageUpload">
                                                                    <strong>Ảnh sản phẩm</strong>
                                                                </label>
                                                                <input class="form-control" type="file" id="imageUpload" name="imageUpload" accept="image/*">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="mb-3">
                                                        <div class="mb-3">
                                                            <label class="form-label" for="country">
                                                                <strong>Mô tả chi tiết</strong>
                                                            </label>
                                                            <textarea class="form-control" name="descriptionP" id="descriptionP"></textarea>
                                                        </div>
                                                        <a class="btn btn-primary btn-sm" href="product">Quay lại</a>

                                                        <button class="btn btn-primary btn-sm" type="submit">Thêm sản phẩm</button>
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


        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="<%=request.getContextPath()%>/view/assets/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/view/assets/js/bs-init.js"></script>
        <script src="<%=request.getContextPath()%>/view/assets/js/theme.js"></script>
        <script src="<%=request.getContextPath()%>/view/assets/js/management/product/add-product.js"></script>
    </body>
</html>