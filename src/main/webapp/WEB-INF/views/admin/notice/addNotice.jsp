<%--
  Created by IntelliJ IDEA.
  User: kimha
  Date: 2017-03-03
  Time: 오후 5:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="/websrc/admin/js/simple/notice.js"></script>
<aside class="right-side">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            공지사항 등록
            <small>To Front</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 공지사항</a></li>
            <li class="active">공지사항 등록</li>
        </ol>
    </section>
<section class="content">
    <form method="post" id="noticeForm" name="noticeForm">
    <div class="row">
        <div class="col-xs-12 connectedSortable">
        </div><!-- /.col -->
    </div>

    <div class="content">
        <div class="col-md-12">
            <!-- general form elements disabled -->
            <div class="box box-primary">
                <div class="box-header">
                    <h3 class="box-title">Add Notice</h3>
                </div><!-- /.box-header -->
                <div class="box-body">

                        <!-- text input -->
                        <div class="form-group">
                            <label>Text</label>
                            <input type="text" class="form-control" id="noticeName" name="noticeName">
                        </div>

                        <!-- radio -->
                        <div class="form-group">
                            <label>노출: </label>
                            <label>
                                <input type="radio" name="useYn" class="minimal-red" value="Y" checked/>
                            </label>

                            <label>  비노출: </label>
                            <label>
                                <input type="radio" name="useYn" class="minimal-red" value="N"/>
                            </label>
                        </div>
                        <!-- textarea -->
                        <div class="form-group">
                            <label>Textarea</label>
                            <textarea class="form-control" id="noticeText" name="noticeText" rows="3"></textarea>
                        </div>
                        <button type="button" class="btn btn-success btn-sm" id="writeButton">등록</button>
                        <button  class="btn btn-danger btn-sm" id="cancelButton">취소</button>

                </div><!-- /.box-body -->
            </div><!-- /.box -->
        </div>
    </div>
    </form>
</section>
