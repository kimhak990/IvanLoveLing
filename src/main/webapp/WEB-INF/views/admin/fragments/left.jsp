<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="wrapper row-offcanvas row-offcanvas-left">
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="left-side sidebar-offcanvas">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="/websrc/admin/img/avatar3.png" class="img-circle" alt="User Image" />
                </div>
                <div class="pull-left info">
                    <p>Hello, Ivan</p>

                    <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                </div>
            </div>
            <!-- search form -->
            <form action="#" method="get" class="sidebar-form">
                <div class="input-group">
                    <input type="text" name="q" class="form-control" placeholder="Search..."/>
                    <span class="input-group-btn">
                                <button type='submit' name='seach' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
                            </span>
                </div>
            </form>
            <!-- /.search form -->
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu">
                <li class="active">
                    <a id="home" href="javascript:;">
                        <i class="fa fa-home"></i> <span>Home</span>
                    </a>
                </li>
                <li class="treeview">
                    <a href="javascript:;">
                        <i class="fa fa-book"></i> <span>myStory</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="#"><i class="fa fa-angle-double-right"></i> 스토리 등록</a></li>
                        <li><a href="#"><i class="fa fa-angle-double-right"></i> 스토리 리스트</a></li>
                        <li><a href="#"><i class="fa fa-angle-double-right"></i> 스토리 보드 권한 관리</a></li>
                    </ul>
                </li>

                <li class="treeview">
                    <a href="javascript:;">
                        <i class="fa fa-comment"></i> <span>MomentStory</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="#"><i class="fa fa-angle-double-right"></i> 쪽지글 등록</a></li>
                        <li><a href="#"><i class="fa fa-angle-double-right"></i> 쪽지글 리스트</a></li>
                        <li><a href="#"><i class="fa fa-angle-double-right"></i> 쪽지글 보드 권한 관리</a></li>
                    </ul>
                </li>
                <li class="treeview">
                    <a href="javascript:;">
                        <i class="fa fa-bullhorn"></i> <span>SYS Notice</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="javascript:location.href='/notice/noticeList'"><i class="fa fa-angle-double-right"></i> 시스템 공지 리스트</a></li>
                        <li><a href="javascript:location.href='/notice/addNoticePage'"><i class="fa fa-angle-double-right"></i> 시스템 공지 등록</a></li>
                    </ul>
                </li>
                <li class="treeview">
                    <a href="javascript:;">
                        <i class="fa fa-bullhorn"></i> <span>Front Menu</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="javascript:location.href='/frontMenu/frontMenuList'"><i class="fa fa-angle-double-right"></i> 프론트 메뉴 리스트</a></li>
                        <li><a href="javascript:location.href='/frontMenu/addFrontMenuPage'"><i class="fa fa-angle-double-right"></i> 프론트 메뉴 등록</a></li>
                    </ul>
                </li>
            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>
    <!-- Right side column. Contains the navbar and content of the page -->

