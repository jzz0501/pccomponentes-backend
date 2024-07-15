package com.data.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pagination<T> {

    private Integer currentPage;

    private Integer totalPage;

    private Long totalItem;

    private String nextPageURL;

    private String prevPageURL;

    private List<T> items;

    public Pagination(Page<T> page) {
        this.currentPage = page.getPageable().getPageNumber() + 1;
        this.totalPage = page.getTotalPages();
        this.totalItem = page.getTotalElements();
        this.nextPageURL = "";
        this.prevPageURL = "";
        this.items = page.getContent();
    }

}