<nav class="navbar align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0 navbar-dark">
    <div class="container-fluid d-flex flex-column p-0">
        <a class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0" href="<%=request.getContextPath()%>/dashboard">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="la la-balance-scale"></i>
            </div>
            <div class="sidebar-brand-text mx-3">
                <span>SALE DOCK</span>
            </div>
        </a>

        <hr class="sidebar-divider my-0">

        <ul class="navbar-nav text-light" id="accordionSidebar">
            <li class="nav-item">
                <a class="nav-link ${requestScope.page eq 'dashboard' ? 'active' : ''}" href="<%=request.getContextPath()%>/dashboard" data-bs-toggle="tooltip" data-bss-tooltip="" data-bs-placement="right" title="Bảng điều khiển">
                    <i class="fas fa-tachometer-alt"></i>
                    <span>Bảng điều khiển</span>
                </a>
            </li>

            <li class="nav-item">
                <a class="nav-link ${requestScope.page eq 'customer' ? 'active' : ''}" href="<%=request.getContextPath()%>/customer" data-bs-toggle="tooltip" data-bss-tooltip="" data-bs-placement="right" title="Quản lí khách hàng">
                    <i class="fas fa-table"></i>
                    <span>
                        Khách hàng
                    </span>
                </a>

                <a class="nav-link ${requestScope.page eq 'product' ? 'active' : ''}" href="<%=request.getContextPath()%>/product" data-bs-toggle="tooltip" data-bss-tooltip="" data-bs-placement="right" title="Quản lí sản phẩm">
                    <i class="fas fa-table"></i>
                    <span>
                        Sản phẩm
                    </span>
                </a>

                <a class="nav-link ${requestScope.page eq 'order' ? 'active' : ''}" href="<%=request.getContextPath()%>/order"  data-bs-toggle="tooltip" data-bss-tooltip="" data-bs-placement="right" title="Quản lí đơn hàng">
                    <i class="fas fa-table"></i>
                    <span>
                        Đơn hàng
                    </span>
                </a>
            </li>
        </ul>

        <div class="text-center d-none d-md-inline">
            <button class="btn rounded-circle border-0" id="sidebarToggle" type="button"></button>
        </div>
    </div>
</nav>
