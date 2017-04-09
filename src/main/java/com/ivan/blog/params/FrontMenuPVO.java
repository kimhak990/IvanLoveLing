package com.ivan.blog.params;

/**
 * Created by kimha on 2017-03-09.
 */
public class FrontMenuPVO extends PageVO{
    String frontMenuId;
    String frontMenuName;
    String depth;
    int parent;
    String createTime;
    String updateTime;
    String useYn;

    public String getFrontMenuId() {
        return frontMenuId;
    }

    public void setFrontMenuId(String frontMenuId) {
        this.frontMenuId = frontMenuId;
    }

    public String getFrontMenuName() {
        return frontMenuName;
    }

    public void setFrontMenuName(String frontMenuName) {
        this.frontMenuName = frontMenuName;
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
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUseYn() {
        return useYn;
    }

    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }

}
