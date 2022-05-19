<!DOCTYPE html>
<html>
    <head>
        <%
            if (session.getAttribute("name") == null) {
                response.sendRedirect("login.jsp");
            }
        %>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>The Car Clinic</title>
        <meta name="description" content="">
        <meta name="viewport"
              content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="robots" content="all,follow">
        <!-- Bootstrap CSS-->
        <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome CSS-->
        <link rel="stylesheet"
              href="vendor/font-awesome/css/font-awesome.min.css">
        <!-- Fontastic Custom icon font-->
        <link rel="stylesheet" href="css/fontastic.css">
        <!-- Google fonts - Poppins -->
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
        <!-- theme stylesheet-->
        <link rel="stylesheet" href="css/style.blue.css"
              id="theme-stylesheet">
        <!-- Custom stylesheet - for your changes-->
        <link rel="stylesheet" href="css/custom.css">
        <!-- Favicon-->
        <link rel="shortcut icon" href="img/favicon.ico">
        <!-- Tweaks for older IEs-->
        <!--[if lt IE 9]>
                <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
                <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
    </head>
    <body onload="load()">
        <div class="page">
            <!-- Main Navbar-->
            <header class="header">
                <nav class="navbar">
                    <!-- Search Box-->
                    <div class="search-box">
                        <button class="dismiss">
                            <i class="icon-close"></i>
                        </button>
                        <form id="searchForm" action="#" role="search">
                            <input type="search" placeholder="What are you looking for..."
                                   class="form-control">
                        </form>
                    </div>
                    <div class="container-fluid">
                        <div
                            class="navbar-holder d-flex align-items-center justify-content-between">
                            <!-- Navbar Header-->
                            <div class="navbar-header">
                                <!-- Navbar Brand -->
                                <a href="customer.jsp"
                                   class="navbar-brand d-none d-sm-inline-block">
                                    <div class="brand-text d-none d-lg-inline-block">
                                        <span></span><strong>The Car Clinic</strong>
                                    </div>
                                    <div class="brand-text d-none d-sm-inline-block d-lg-none">
                                        <strong>AL</strong>
                                    </div>
                                </a>
                                <!-- Toggle Button-->
                                <a id="toggle-btn" href="#" class="menu-btn active"><span></span><span></span><span></span></a>
                            </div>
                            <!-- Navbar Menu -->
                            <ul
                                class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">

                                <li class="nav-item"><a href="logout.jsp"
                                                        class="nav-link logout"> <span class="d-none d-sm-inline">Logout</span><i
                                            class="fa fa-sign-out"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </header>
            <div class="page-content d-flex align-items-stretch">
                <!-- Side Navbar -->
                <nav class="side-navbar">
                    <!-- Sidebar Header-->
                    <div class="sidebar-header d-flex align-items-center">
                        <div class="avatar">
                            <img src="img/user.png" alt="..." class="img-fluid rounded-circle">
                        </div>
                        <div class="title">
                            <h1 class="h4">${name}</h1>
                            <p>User</p>
                        </div>
                    </div>
                    <!-- Sidebar Navidation Menus-->
                    <span class="heading">Main</span>
                    <ul class="list-unstyled">
                        <li class="active"><a href="customer.jsp"><i class="fa fa-users"></i>Customer</a></li>
                        
                        <li><a href="user.jsp"><i class="fa fa-user"></i>User</a></li>
                        <li><a href="logout.jsp"><i class="fa fa-sign-out"></i>Logout</a></li>
                    </ul>
                </nav>
                <div class="content-inner">
                    <!-- Page Header-->
                    <header class="page-header">
                        <div class="container-fluid">
                            <h2 class="no-margin-bottom">Customer Management System</h2>
                        </div>
                    </header>
                    <!-- Breadcrumb-->

                    <!-- Forms Section-->
                    <section class="forms">

                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-header">
                                    <h4 class="card-title"> Customer Table</h4>
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table" id="table">
                                            <thead class=" text-primary">
                                            <th>#</th>
                                            <th>ID</th>
                                            <th>First name</th>
                                            <th>Last name</th>
                                            <th>Address</th>
                                            <th>Nic</th>
                                            <th>Email</th>
                                            <th>Phone</th>
                                            </thead>
                                            <tbody>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>



                        <!-- HTML FORM CREATION Customer -->
                        <div class="col-md-12">
                            <div class="card card-user">
                                <div class="card-header">
                                    <h5 class="card-title">Customer Management</h5>
                                </div>
                                <div class="card-body">
                                    <form id="form">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <input id="customer_id" type="hidden" class="form-control" value="0" autocomplete="off">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label>First name</label>
                                                    <input id="fname" type="text" onkeypress="onclickvalidateName()" class="form-control" placeholder="First name" autocomplete="off">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label>Last name</label>
                                                    <input id="lname" type="text" onkeypress="onclickvalidateName()" class="form-control" placeholder="Last name" autocomplete="off">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label>Address</label>
                                                    <input id="address" type="text" class="form-control" placeholder="Address" autocomplete="off">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label>Nic</label>
                                                    <input id="nic" type="text" onkeypress="onClickValidatioeNIC()" class="form-control" placeholder="Nic" autocomplete="off">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label>Email</label>
                                                    <input id="email" type="text" class="form-control" placeholder="Email" autocomplete="off">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label>Phone</label>
                                                    <input id="phone" maxlength="10" onkeypress="onClickValidationContactNumber()" type="text" class="form-control" placeholder="Phone" autocomplete="off">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="update ml-auto mr-auto">
                                                <button onclick="save()" type="button" class="btn btn-success btn-round">Save Customer</button>
                                                <button onclick="update()" type="button" class="btn btn-success btn-round">Update Customer</button>
                                                <button onclick="delet()" type="button" class="btn btn-success btn-round">Delete Customer</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>


                    </section>
                    <!-- Page Footer-->
                    <footer class="main-footer">
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-sm-6">
                                </div>
                                <div class="col-sm-6 text-right">
                                    <p>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </footer>
                </div>
            </div>
        </div>
        <!-- JavaScript files-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/popper.js/umd/popper.min.js">

        </script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <script src="vendor/jquery.cookie/jquery.cookie.js">

        </script>
        <script src="vendor/chart.js/Chart.min.js"></script>
        <script src="vendor/jquery-validation/jquery.validate.min.js"></script>
        <!-- Main File-->
        <script src="js/front.js"></script>



        <script src="ajax/jquery.3.2.1.min.js" type="text/javascript"></script>
        <script src="ajax/ajax.js" type="text/javascript"></script>
        <script src="ajax/CustomerJS.js" type="text/javascript"></script>
    </body>
</html>