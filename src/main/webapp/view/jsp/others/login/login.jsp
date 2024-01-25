<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html data-bs-theme="light" lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Login - Sale Dock</title>
        <link rel="icon" type="image/png" sizes="512x512" href="<%=request.getContextPath()%>/view/assets/images/favicon/favicon.png">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/assets/css/validate/validator.css">
    </head>

    <body class="bg-gradient-primary">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-9 col-lg-12 col-xl-10">
                    <div class="card shadow-lg o-hidden border-0 my-5">
                        <div class="card-body p-0">
                            <div class="row">
                                <div class="col-lg-6 m-auto">
                                    <div class="p-5">
                                        <div class="text-center">
                                            <h4 class="text-dark mb-4">Đăng nhập Sale Dock</h4>
                                        </div>
                                        <div class="container">
                                            <c:choose>
                                                <c:when test="${param.message eq 'fail'}">
                                                    <div class="alert alert-danger text-center" role="alert">
                                                        Lỗi: Không thể hoàn thành hành động được yêu cầu.
                                                    </div>
                                                </c:when>
                                                <c:when test="${param.message eq 'notCorrect'}">
                                                    <div class="alert alert-danger text-center" role="alert">
                                                        Mã nhân viên hoặc mật khẩu không chính xác!
                                                    </div>
                                                </c:when>
                                                <c:when test="${param.message eq 'notLogin'}">
                                                    <div class="alert alert-warning text-center" role="alert">
                                                        Vui lòng đăng nhập để truy cập.
                                                    </div>
                                                </c:when>
                                            </c:choose>

                                            <form class="user" id="form-signin" method="post">
                                                <div class="mb-3 form-group">
                                                    <input class="form-control form-control-user" type="text" id="signin-code" aria-describedby="codeHelp" placeholder="Nhập mã nhân viên..." name="employee-code">
                                                    <span class="form-message"></span>
                                                </div>
                                                <div class="mb-3 form-group">
                                                    <input class="form-control form-control-user" type="password" id="signin-password" placeholder="Nhập mật khẩu" name="password">
                                                    <span class="form-message"></span>
                                                </div>
                                                <div class="mb-3">
                                                    <button class="btn btn-primary d-block btn-user w-100" type="submit">Đăng nhập</button>
                                                </div>
                                                <hr>
                                            </form>
                                            <div class="text-center"><a class="small" href="forgot-password.html">Quên mật khẩu?</a></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <script src="<%=request.getContextPath()%>/view/assets/js/bootstrap.min.js"></script>
            <script src="<%=request.getContextPath()%>/view/assets/js/bs-init.js"></script>
            <script src="<%=request.getContextPath()%>/view/assets/js/theme.js"></script>
            <script src="<%=request.getContextPath()%>/view/assets/js/validate/validator.js"></script>

            <!--Validate Login-->
            <script>
                Validator({
                    form: '#form-signin',
                    errorSelector: '.form-message',
                    formGroupSelector: '.form-group',
                    rules: [
                        Validator.isRequired('#signin-code', 'Vui lòng nhập mã nhân viên!'),

                        Validator.isRequired('#signin-password', 'Vui lòng nhập mật khẩu!'),
                        Validator.minLength('#signin-password', 5, 'Mật khẩu phải có ít nhất 5 kí tự!')
                    ]
                });
            </script>
    </body>

</html>