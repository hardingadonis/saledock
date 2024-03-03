<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html data-bs-theme="light" lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Quên mật khẩu - Sale Dock</title>
        <link rel="icon" type="image/png" sizes="512x512" href="<%=request.getContextPath()%>/view/assets/images/favicon/favicon.png">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/assets/css/validate/validator.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/assets/css/others/login/form-login.css">
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
                                        <c:choose>
                                            <c:when test="${requestScope.message eq 'fail'}">
                                                <div class="alert alert-danger text-center" role="alert">
                                                    Lỗi: Không thể hoàn thành hành động được yêu cầu.
                                                </div>
                                            </c:when>
                                            <c:when test="${requestScope.message eq 'emailNotExist'}">
                                                <div class="alert alert-danger text-center" role="alert">
                                                    Tài khoản không tồn tại. Vui lòng sử dụng một địa chỉ email khác.
                                                </div>
                                            </c:when>
                                        </c:choose>
                                        <div class="text-center">
                                            <h4 class="text-dark mb-2">Quên mật khẩu?</h4>
                                            <p class="mb-4">Bạn sẽ nhận được email thay đổi mật khẩu!</p>
                                        </div>
                                        <form class="user" action="#" id="form-forgot-password" method="post">
                                            <div class="mb-3 form-group">
                                                <input type="hidden" name="action" value="submitEmail">
                                                <input class="form-control form-control-user" type="email" id="input-email" aria-describedby="emailHelp" placeholder="Nhập email nhân viên..." name="forgot-email">
                                                <span class="form-message"></span>
                                            </div>
                                            <button class="btn btn-primary d-block btn-user w-100" type="submit">Quên mật khẩu</button>
                                        </form>
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

        <!--Validate Forgot Password-->
        <script>
            Validator({
                form: '#form-forgot-password',
                errorSelector: '.form-message',
                formGroupSelector: '.form-group',
                rules: [
                    Validator.isRequired('#input-email', 'Vui lòng nhập email nhân viên!'),
                    Validator.isEmail('#input-email', 'Vui lòng nhập đúng kiểu email! Ví dụ: abc@gmail.com...')
                ]
            });
        </script>
    </body>

</html>
