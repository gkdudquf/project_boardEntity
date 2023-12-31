package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//사용자게시글  DTO엔 String 타입의 createdAt(작성일) 변수 있어야함, 다중파일 받는것도!!
@Entity
@Getter
@Setter
@Table(name = "member_board_table")
public class MemberBoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 10)
    private String season;
    @Column(length = 50)
    private String boardWriter;
    @Column(length = 50)
    private String boardTitle;
    @Column(length = 500)
    private String boardContents;
    @Column
    private int boardLikes;
    @Column
    private int boardHits;
    @Column
    private int fileAttached;
    @OneToMany(mappedBy = "memberBoardEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<AlarmEntity> alarmEntityList = new ArrayList<>();
    @OneToMany(mappedBy = "memberBoardEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<MemberBoardFileEntity> memberBoardFileEntityList = new ArrayList<>();
    @OneToMany(mappedBy = "memberBoardEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<BoardLikesEntity> likesEntityList = new ArrayList<>();
    @OneToMany(mappedBy = "memberBoardEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CommentEntity> commentEntityList = new ArrayList<>();
}
