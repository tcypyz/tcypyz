package com.example.smserver.utils;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/28
 */
public class PageInfoUtils {

    public static <T extends Serializable, E> void transform(PageInfo<T> from, PageInfo<E> to) {
        to.setPageNum(from.getPageNum());
        to.setPageSize(from.getPageSize());
        to.setSize(from.getSize());
        to.setStartRow(from.getStartRow());
        to.setEndRow(from.getEndRow());
        to.setTotal(from.getTotal());
        to.setPages(from.getPages());
        to.setPrePage(from.getPrePage());
        to.setNextPage(from.getNextPage());
        to.setIsFirstPage(from.isIsFirstPage());
        to.setIsLastPage(from.isIsLastPage());
        to.setHasPreviousPage(from.isHasPreviousPage());
        to.setHasNextPage(from.isHasNextPage());
        to.setNavigatePages(from.getNavigatePages());
        to.setNavigatepageNums(from.getNavigatepageNums());
        to.setNavigateFirstPage(from.getNavigateFirstPage());
        to.setNavigateLastPage(from.getNavigateLastPage());
    }
}
