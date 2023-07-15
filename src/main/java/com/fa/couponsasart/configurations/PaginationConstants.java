package com.fa.couponsasart.configurations;

import org.springframework.data.domain.Sort;

public class PaginationConstants {

    public static final Integer MAX_PAGE_SIZE = 500;

    public static class Defaults {

        public static final Integer FIRST_PAGE = 0;
        public static final Integer PAGE_SIZE = 25;

        public static final Sort ID_DESC_SORT = Sort.by(Sort.Order.desc("id"));
    }
}
