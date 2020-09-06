package com.example.demo.entity.s1;


public class Music {
    // 엔티티 수가 많아질 수 있다.
    // 그럴 때 관리에 좋은 자료구조가 List이다.
    // B2B - 업체정보, 쇼핑몰 - 상품정보, 회원 관리 - 회원정보
    // 등을 엔티티라고 할 수 있다.
    private String writer = "sdr4linux";
    private String title = "gogogo";

    public String getWriter() {
        return writer;
    }

    public String getTitle() {
        return title;
    }

}
