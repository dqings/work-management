package com.dqings.wm.workmanagement.po;

import lombok.Data;

import java.util.List;

@Data
public class PageBean<T> {
    private int currentPage;
    private int pageSize;
    private int total;
    private List<T> rows;
}
