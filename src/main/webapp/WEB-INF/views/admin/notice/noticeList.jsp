<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: kimhak
  Date: 2017-03-03
  Time: 오후 5:44
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="/websrc/admin/js/simple/notice.js"></script>
<!-- Right side column. Contains the navbar and content of the page -->
<form id="listForm">
<aside class="right-side">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            공지사항
            <small>리스트</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="javascript:location.href='/home'"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="javascript:location.href='/notice/noticeList'">공지사항</a></li>
            <li class="active">공지사항 리스트</li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="box">
                    <div class="box-header">
                        <h3 class="box-title">공지사항</h3>
                    </div><!-- /.box-header -->
                    <div class="col-xs-12"><!-- searching start -->
                        <div class="box box-info">
                            <div class="box box-body">
                                <div class="row">
                                    <div class="col-lg-4">
                                        <div class="form-group">
                                            <label>공지 이름 :</label>
                                            <input type="text" class="form-control" id="noticeName" name="noticeName" value="${noticePVO.noticeName}">
                                        </div>
                                    </div>
                                    <div class="col-lg-4">
                                        <div class="form-group">
                                            <label>공지 시간 :</label>
                                            <input type="text" class="form-control" id="datepicker1">
                                        </div>
                                    </div>
                                    <div class="col-lg-4">
                                        <div class="form-group">
                                            <label>노출 여부</label>
                                            <select class="form-control" id="useYn" name="useYn">
                                                <option value="" <c:if test="${noticePVO.useYn eq '' or noticePVO.useYn eq null}">selected</c:if> >전체</option>
                                                <option value="Y" <c:if test="${noticePVO.useYn eq 'Y'}">selected</c:if> >노출</option>
                                                <option value="N" <c:if test="${noticePVO.useYn eq 'N'}">selected</c:if> >비노출</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="box-footer">
                                <div align="middle">
                                    <button onclick="search()" class="btn btn-primary"><li class="fa fa-search"></li> 검색</button>
                                    <button id="cancel" class="btn btn-danger"><li class="fa fa-ban"></li> 취소</button>
                                </div>
                            </div>
                        </div>
                    </div><!-- searching end -->

                    <div class="box-body table-responsive">
                        <table id="example2" class="table table-bordered table-hover">
                            <thead>
                            <tr>
                                <th width="20%">공지사항</th>
                                <th width="30%">공지사항 내용</th>
                                <th width="15%">작성시간</th>
                                <th width="15%">공개시간</th>
                                <th width="8%" style="text-align: center;">공개여부</th>
                                <th width="12%" style="text-align: center;">공지 관리</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="data" items="${list}" varStatus="status">
                                <tr>
                                    <td>${data.noticeName}</td>
                                    <td>${data.noticeText}</td>
                                    <td>${data.createTime}</td>
                                    <td>${data.releaseTime}</td>
                                    <td style="text-align: center;">
                                        <c:if test="${data.useYn eq 'Y'}">
                                            <small class="badge middle bg-green">노출</small>
                                        </c:if>
                                        <c:if test="${data.useYn eq 'N'}">
                                            <small class="badge middle bg-red">비노출</small>
                                        </c:if>
                                    </td>
                                    <td style="text-align: center;">
                                        <button type="button" class="btn btn-info btn-sm" onclick="updateNotice('${data.noticeId}')"><i class="fa fa-gavel"></i>  수정</button>
                                        <button type="button" class="btn btn-danger btn-sm" onclick="deleteNotice('${data.noticeId}')"><i class="fa fa-trash-o"></i>  삭제</button>
                                    </td>
                                </tr>
                            </c:forEach>
                            <c:if test="${fn:length(list) < 1 }">
                                <tr>
                                    <td colspan="6">등록된 공지사항이 없습니다.</td>
                                </tr>
                            </c:if>
                            </tbody>
                        </table>
                        <!-- paging start -->
                        ${pagingHtml}
                        <!-- paging end -->
                    </div><!-- /.box-body -->
                </div><!-- /.box -->
            </div>
        </div>
    </section><!-- /.content -->
</aside><!-- /.right-side -->
    <input type="hidden" name="pageNo" id="pageNo" value="${noticePVO.pageNo}">
</form>
<form id="paramsId">
    <input type="hidden" id="noticeId" name="noticeId">
</form>