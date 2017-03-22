<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
    <header id="header"><!-- Header S -->
        <title><decorator:title default="블로그 관리자 페이지" /></title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="robots" content="all">
        <link rel="stylesheet" type="text/css" href="/websrc/admin/css/bootstrap.css"/>
        <link href="/websrc/admin/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="/websrc/admin/css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="/websrc/admin/css/AdminLTE.css" rel="stylesheet" type="text/css" />
        <link href="/websrc/admin/css/datatables/dataTables.bootstrap.css" rel="stylesheet" type="text/css" />
        <script src="/websrc/admin/js/jquery-2.2.2.js" type="text/javascript"></script>
        <!-- Bootstrap -->
        <script src="/websrc/admin/js/bootstrap.js" type="text/javascript"></script>
        <!-- AdminLTE App -->
        <script src="/websrc/admin/js/AdminLTE/app.js" type="text/javascript"></script>

        <script type="text/javascript" src="/websrc/admin/js/common/common.js"></script>

    </header><!-- Header E -->
    <decorator:head/>
</head>
<body class="skin-blue">
<page:applyDecorator name="top"/>
<page:apply-decorator name="left"/>
<div id="container">	<!-- id="container" S -->
    <decorator:body/>
</div>
</body>
</html>
