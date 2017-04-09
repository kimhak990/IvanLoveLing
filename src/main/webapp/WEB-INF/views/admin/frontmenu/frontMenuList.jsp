<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: kimha
  Date: 2017-03-09
  Time: 오후 7:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="/websrc/admin/js/simple/frontMenu.js"></script>
<!-- Right side column. Contains the navbar and content of the page -->
<form id="listForm">
    <aside class="right-side">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                프론트 메뉴
                <small>리스트</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="javascript:location.href='/home'"><i class="fa fa-dashboard"></i> Home</a></li>
                <li><a href="javascript:location.href='/notice/noticeList'">프로트 메뉴</a></li>
                <li class="active">프론트 메뉴 리스트</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">프론트 메뉴</h3>
                        </div><!-- /.box-header -->
                        <div class="col-xs-12"><!-- searching start -->
                            <div class="box box-info">
                                <div class="box box-body">
                                    <div class="row">
                                        <div class="col-lg-4">
                                            <div class="form-group">
                                                <label>메뉴 명 :</label>
                                                <input type="text" class="form-control" id="frontMenuName" name="frontMenuName" value="${frontMenuPVO.frontMenuName}">
                                            </div>
                                        </div>
                                        <div class="col-lg-4">
                                            <div class="form-group">
                                                <label>카테고리 뎁스 :</label>
                                                <input type="text" class="form-control" id="depth" name="depth" value="${frontMenuPVO.depth}">
                                            </div>
                                        </div>
                                        <div class="col-lg-4">
                                            <div class="form-group">
                                                <label>노출 여부</label>
                                                <select class="form-control" id="useYn" name="useYn">
                                                    <option value="" <c:if test="${frontMenuPVO.useYn eq '' or frontMenuPVO.useYn eq null}">selected</c:if> >전체</option>
                                                    <option value="Y" <c:if test="${frontMenuPVO.useYn eq 'Y'}">selected</c:if> >노출</option>
                                                    <option value="N" <c:if test="${frontMenuPVO.useYn eq 'N'}">selected</c:if> >비노출</option>
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
                                    <th width="20%">메뉴 명</th>
                                    <th width="30%">메뉴 뎁스</th>
                                    <th width="15%">상위 메뉴</th>
                                    <th width="15%">등록 시간</th>
                                    <th width="8%" style="text-align: center;">공개여부</th>
                                    <th width="12%" style="text-align: center;">공지 관리</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="data" items="${list}" varStatus="status">
                                    <tr>
                                        <td>${data.frontMenuName}</td>
                                        <td>${data.depth}</td>
                                        <td>${data.parent}</td>
                                        <td>${data.createTime}</td>
                                        <td style="text-align: center;">
                                            <c:if test="${data.useYn eq 'Y'}">
                                                <small class="badge middle bg-green">노출</small>
                                            </c:if>
                                            <c:if test="${data.useYn eq 'N'}">
                                                <small class="badge middle bg-red">비노출</small>
                                            </c:if>
                                        </td>
                                        <td style="text-align: center;">
                                            <button type="button" class="btn btn-info btn-sm" onclick="updateFrontMenu('${data.frontMenuId}')"><i class="fa fa-gavel"></i>  수정</button>
                                            <button type="button" class="btn btn-danger btn-sm" onclick="deleteFrontMenu('${data.frontMenuId}')"><i class="fa fa-trash-o"></i>  삭제</button>
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
    <input type="hidden" name="pageNo" id="pageNo" value="${frontMenuPVO.pageNo}">
</form>
<form id="paramsId">
    <input type="hidden" id="frontMenuId" name="frontMenuId">
</form>