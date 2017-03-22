<%--
  Created by IntelliJ IDEA.
  User: kimha
  Date: 2017-03-03
  Time: 오전 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Main content -->
<section class="content">
    <div class="row">
        <div class="col-lg-3 col-xs-6">
            <div class="box box-warning">
                <div class="box-header">
                    <i class="fa fa-calendar"></i>
                    <div class="box-title">Calendar</div>

                    <!-- tools box -->
                    <div class="pull-right box-tools">
                        <!-- button with a dropdown -->
                        <div class="btn-group">
                            <button class="btn btn-warning btn-sm dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bars"></i></button>
                            <ul class="dropdown-menu pull-right" role="menu">
                                <li><a href="#">Add new event</a></li>
                                <li><a href="#">Clear events</a></li>
                                <li class="divider"></li>
                                <li><a href="#">View calendar</a></li>
                            </ul>
                        </div>
                    </div><!-- /. tools -->
                </div><!-- /.box-header -->

                <div class="box-body no-padding">
                    <!--The calendar -->
                    <div id="calendar"></div>
                </div><!-- /.box-body -->
            </div><!-- /.box -->
        </div>
    </div>
</section><!-- /.content -->
</aside><!-- /.right-side -->
</div><!-- ./wrapper -->