package com.example.demo.repository.s7;

import com.example.demo.entity.s7.VideoMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VideoMemberRepository extends JpaRepository<VideoMember, Long> {
    public List<VideoMember> findByUserId(String userId);

    // List 보기 구현하는 코드를 아래처럼 간단하게 쓸 수 있다.
    // 사용하는 DB에 따라 쿼리문을 바꿔 써야 하지만 JPA를 쓰면 신경쓰지 않아도 된다.
    // 생산성과 유지보수성 향상
    // (JPA를 쓰지 않은 경우 잘못 만들면 시간이 갈수록 수습할 수 없는 상황이 올수 있다)
    @Query("select vm.userNo, vm.userPw, vm.userName, vm.regDate from VideoMember vm")
    public List<Object[]> listAllVideoMember();
}
