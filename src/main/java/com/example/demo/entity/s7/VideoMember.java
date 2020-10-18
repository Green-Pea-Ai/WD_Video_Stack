package com.example.demo.entity.s7;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(value="hibernateLazyInitializer")

// 롬복
@Getter
@Setter
@EqualsAndHashCode(of = "userNo")
@ToString

// JPA, Repository 기능 구현할 때 코드량이 많았는데 그것을 자동으로 해준다
@Entity
@Table(name = "video_member")
public class VideoMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no")
    private Long userNo;

    @Column(length = 50, nullable = false)
    private String userId;

    @Column(length = 100, nullable = false)
    private String userName;

    @Column(length = 200, nullable = false)
    private String userPw;

    @Column(length = 16, nullable = false)
    private String job;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @CreationTimestamp
    private Date regDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @UpdateTimestamp
    private Date updDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_no")
    private List<VideoMemberAuth> authList = new ArrayList<VideoMemberAuth>();

    public void addAuth(VideoMemberAuth auth) { authList.add(auth); }

    public  void clearAuthList() { authList.clear(); }

}
