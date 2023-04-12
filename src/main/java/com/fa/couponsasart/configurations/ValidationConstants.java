package com.fa.couponsasart.configurations;

public class ValidationConstants {

    public static class Regex {
        public final static String EMAIL = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

        public final static String PASSWORD = "[\\w\\W]+"; // TODO implement this regex
    }

    public static class Client {
        public final static int PASSWORD_MIN_LEN = 6;

        public final static int PASSWORD_MAX_LEN = 64;
    }

    public static class Coupon {
        public final static int TITLE_MIN_LEN = 2;

        public final static int TITLE_MAX_LEN = 32;

        public final static int DESCRIPTION_MAX_LEN = 300;
    }
}
