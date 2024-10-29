<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/commons/taglib.jsp"%>





<!DOCTYPE html>
<html lang="en">
<!-- BEGIN HEAD -->
<head>
    
    <title>WEB - Dashboard</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    <meta content="" name="description" />
    <meta content="" name="author" />
</head>
<body class="page-container-bg-solid page-sidebar-closed hide-logo page-header-fixed">
    <!-- BEGIN HEADER -->
    <div>
        <%@ include file="/commons/admin/header.jsp" %>
    </div>
    <!-- END HEADER -->
    
    <div class="clearfix"></div>

    <div class="container-fluid">
        <div class="page-container">
            <!-- BEGIN CONTAINER -->
            
            <!-- sidebar -->
            <div class="sidebar">
                <sitemesh:write property="body" />
            </div>
            <!-- End body -->
            
            <!-- END CONTAINER -->

            <!-- BEGIN FOOTER -->
            <!-- header -->
            <div>
                <%@ include file="/commons/admin/footer.jsp" %>
            </div>
            <!-- END FOOTER -->
        </div>
    </div>
</body>
<!-- END BODY -->
</html>