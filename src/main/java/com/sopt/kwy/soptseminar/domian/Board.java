package com.sopt.kwy.soptseminar.domian;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
public class Board extends AuditingTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private User user;

    @Column
    private String thumbnail;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Boolean isPublic;
    private Board(User user, String thumbnail, String title, String content, Boolean isPublic) {
        this.user = user;
        this.thumbnail = thumbnail;
        this.title =title;
        this.content = content;
        this.isPublic = isPublic;
    }

    public static Board newInstance(User user, String thumbnail, String title, String content, Boolean isPublic) {
        return new Board(user, thumbnail, title, content, isPublic);
    }
}
