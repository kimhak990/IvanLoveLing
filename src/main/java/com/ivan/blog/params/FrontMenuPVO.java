package com.ivan.blog.params;

/**
 * Created by kimha on 2017-03-09.
 */
public class FrontMenuPVO extends PageVO{
    String frontMenuId;
    String FrontMenuName;
    String depth;
    int parent;
    String createTime;
    String UpdateTime;
    String useYn;

    public String getFrontMenuId() {
        return frontMenuId;
    }

    public void setFrontMenuId(String frontMenuId) {
        this.frontMenuId = frontMenuId;
    }

    public String getFrontMenuName() {
        return FrontMenuName;
    }

    public void setFrontMenuName(String frontMenuName) {
        FrontMenuName = frontMenuName;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(String updateTime) {
        UpdateTime = updateTime;
    }

    public String getUseYn() {
        return useYn;
    }

    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }

}
