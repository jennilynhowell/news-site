package com.jennilyn.webapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ARTICLE")
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
    All dates stored as UTC
     */
    @Column(name = "created_at")
    private Instant createdDt;

    @Column(name = "updated_at")
    private Instant updatedDt;

    @Column(name = "source", nullable = false)
    private String source;

    @Column(name = "author_first", nullable = false)
    private String authorFirstName;

    @Column(name = "author_last", nullable = false)
    private String authorLastName;

    @Column(name = "body", nullable = false)
    private String body;

    @OneToMany(mappedBy = "KEYWORD", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "KEYWORD.id")
    private List<KeywordEntity> keywords;

}
