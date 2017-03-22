package com.ivan.blog.params;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Created by kimha on 2017-03-07.
 */
public class PageVO{

    public static int DEFAULT_PAGESIZE = 10;

    private int pageIndex; // 게시글 번호
    private int pageSize; // 게시 글 수
    private int firstPageNo; // 첫 번째 페이지 번호
    private int prevPageNo; // 이전 페이지 번호
    private int startPageNo; // 시작 페이지 (페이징 네비 기준)
    private int pageNo; // 현재 페이지 번호
    private int endPageNo; // 끝 페이지 (페이징 네비 기준)
    private int nextPageNo; // 다음 페이지 번호
    private int finalPageNo; // 마지막 페이지 번호
    private int totalCount; // 게시 글 전체 수
    private int pageDataIdx;//showing Data Number

    public static int getDEFAULT_PAGESIZE() {
        return DEFAULT_PAGESIZE;
    }

    public static void setDEFAULT_PAGESIZE(int dEFAULT_PAGESIZE) {
        DEFAULT_PAGESIZE = dEFAULT_PAGESIZE;
    }


    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    /**
     * @return the pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return the firstPageNo
     */
    public int getFirstPageNo() {
        return firstPageNo;
    }

    /**
     * @param firstPageNo the firstPageNo to set
     */
    public void setFirstPageNo(int firstPageNo) {
        this.firstPageNo = firstPageNo;
    }

    /**
     * @return the prevPageNo
     */
    public int getPrevPageNo() {
        return prevPageNo;
    }

    /**
     * @param prevPageNo the prevPageNo to set
     */
    public void setPrevPageNo(int prevPageNo) {
        this.prevPageNo = prevPageNo;
    }

    /**
     * @return the startPageNo
     */
    public int getStartPageNo() {
        return startPageNo;
    }

    /**
     * @param startPageNo the startPageNo to set
     */
    public void setStartPageNo(int startPageNo) {
        this.startPageNo = startPageNo;
    }

    /**
     * @return the pageNo
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * @param pageNo the pageNo to set
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * @return the endPageNo
     */
    public int getEndPageNo() {
        return endPageNo;
    }

    /**
     * @param endPageNo the endPageNo to set
     */
    public void setEndPageNo(int endPageNo) {
        this.endPageNo = endPageNo;
    }

    /**
     * @return the nextPageNo
     */
    public int getNextPageNo() {
        return nextPageNo;
    }

    /**
     * @param nextPageNo the nextPageNo to set
     */
    public void setNextPageNo(int nextPageNo) {
        this.nextPageNo = nextPageNo;
    }

    /**
     * @return the finalPageNo
     */
    public int getFinalPageNo() {
        return finalPageNo;
    }

    /**
     * @param finalPageNo the finalPageNo to set
     */
    public void setFinalPageNo(int finalPageNo) {
        this.finalPageNo = finalPageNo;
    }

    /**
     * @return the totalCount
     */

    public int getPageDataIdx() {
        return pageDataIdx;
    }

    public void setPageDataIdx(int pageDataIdx) {
        this.pageDataIdx = pageDataIdx;
    }
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * @param totalCount the totalCount to set
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        this.makePaging();
    }

    /**
     * 페이징 생성
     */
    private void makePaging() {
        if (pageNo <= 0) pageNo = 1;
        if (pageSize <= 0) pageSize = DEFAULT_PAGESIZE;
        if (endPageNo <= 0) endPageNo = 1;

        firstPageNo = 1;
        finalPageNo = (totalCount + (pageSize - 1)) / pageSize; // 마지막 페이지
        if(finalPageNo <= 0) {
            finalPageNo = 1;
        }

        if (pageNo > finalPageNo) pageNo = finalPageNo; // 기본 값 설정
        if(pageNo <= 1){
            pageIndex = 0;
        }else{
            pageIndex = (pageNo - 1) * pageSize;
        }

        startPageNo = ((pageNo - 1) / 10) * 10 + 1; // 시작 페이지 (페이징 네비 기준)
        endPageNo = startPageNo + 10 - 1; // 끝 페이지 (페이징 네비 기준)

        if (endPageNo > finalPageNo) { // [마지막 페이지 (페이징 네비 기준) > 마지막 페이지] 보다 큰 경우
            endPageNo = finalPageNo;
        }

        prevPageNo = (pageNo == 1 ? 1 : pageNo - 1);
        nextPageNo = (pageNo == finalPageNo ? finalPageNo : pageNo + 1);

         if(pageNo == 1){
             pageDataIdx = 10;
         }else if (pageNo != endPageNo){
             pageDataIdx = pageSize * pageNo;
         }else if (pageNo == endPageNo && pageNo * pageSize == totalCount){
             pageDataIdx = pageSize * pageNo;
         }else {
             pageDataIdx = (pageSize * (pageNo -1)) + (pageSize * pageNo - totalCount);
         }
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
