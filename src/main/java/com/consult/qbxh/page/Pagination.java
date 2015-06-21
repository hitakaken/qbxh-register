package com.consult.qbxh.page;

import com.google.sitebricks.Show;
import com.google.sitebricks.rendering.EmbedAs;

/**
 * Created by hp on 2015/6/21.
 */
@EmbedAs("Pagination")
@Show("/page/Pagination.html")
public class Pagination {
    private long current;
    private long total;

    public long getCurrent() {
        return current;
    }

    public void setCurrent(long current) {
        this.current = current;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public boolean isFirst(){
        return current <=1;
    }

    public boolean isLast(){
        return current >= total;
    }

    public boolean hasPrevious(){
        return !isFirst();
    }

    public boolean hasNext(){
        return !isLast();
    }


}
