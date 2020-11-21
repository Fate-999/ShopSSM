package com.jayant.pojo;

public class Pager {
    private int curPage;
    private int perPageRows;
    private int rowCount;
    private int pageCount;

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getPerPageRows() {
        return perPageRows;
    }

    public void setPerPageRows(int perPageRows) {
        this.perPageRows = perPageRows;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getPageCount() {
        return (rowCount + perPageRows - 1) / perPageRows;
    }

    public int getFirstLimitParam() {
        return (this.curPage - 1) * this.perPageRows;
    }
}
