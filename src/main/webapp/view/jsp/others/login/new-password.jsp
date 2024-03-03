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
                                            <c:when test="${requestScope.message eq 'success'}">
                                                <div class="alert alert-success text-center" role="alert">
                                                    Mã OTP hợp lệ. Hãy thay đổi mật khẩu của bạn.
                                                </div>
                                            </c:when>
                                            <c:when test="${requestScope.message eq 'fail'}">
                                                <div class="alert alert-danger text-center" role="alert">
                                                    Vui lòng nhập lại mật khẩu!
                                                </div>
                                            </c:when>
                                            <c:when test="${requestScope.message eq 'notCorrect'}">
                                                <div class="alert alert-danger text-center" role="alert">
                                                    Mật khẩu nhập lại không chính xác. Vui lòng nhập lại!
                                                </div>
                                            </c:when>
                                        </c:choose>
                                        <div class="text-center">
                                            <h4 class="text-dark mb-2">Quên mật khẩu?</h4>
                                            <p class="mb-4">Tạo mật khẩu mới!</p>
                                        </div>
                                        <form class="user" action="#" id="form-new-password" method="post">
                                            <input type="hidden" name="action" value="newPassword">
                                            <div class="form-group d-flex mb-3">
                                                <label for="show-email" class="font-italic font-weight-bold">Địa chỉ email của bạn: </label>
                                                <p class="ml-5 font-italic font-weight-bold text-success" style="margin-left: 10px;">${sessionScope.email}</p>
                                            </div>
                                            <div class="mb-3 form-group">
                                                <input class="form-control form-control-user" type="password" id="new-password" aria-describedby="" placeholder="Nhập mật khẩu mới..." name="new-password">
                                                <span class="form-message"></span>
                                            </div>
                                            <div class="mb-3 form-group">
                                                <input class="form-control form-control-user" type="password" id="confirm-password" aria-describedby="" placeholder="Nhập lại mật khẩu..." name="confirm-password">
                                                <span class="form-message"></span>
                                            </div>
                                            <button class="btn btn-primary d-block btn-user w-100" type="submit">Xác nhận</button>
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
                form: '#form-new-password',
                errorSelector: '.form-message',
                formGroupSelector: '.form-group',
                rules: [
                    Validator.isRequired('#new-password', 'Vui lòng nhập mật khẩu mới!'),
                    Validator.minLength('#new-password', 5, 'Vui lòng nhập mật khẩu có ít nhất 5 kí tự!'),

                    Validator.isRequired('#confirm-password', 'Vui lòng nhập lại mật khẩu!'),
                    Validator.minLength('#confirm-password', 5, 'Vui lòng nhập mật khẩu có ít nhất 5 kí tự!'),
                    Validator.isConfirmed('#confirm-password', function () {
                        return document.querySelector('#new-password').value;
                    }, 'Mật khẩu nhập lại không chính xác!')
                ]
            });
        </script>
    </body>

</html>
