package com.jennilyn.webapp.repository;

import com.jennilyn.webapp.model.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

    List<ArticleEntity> findAllByAuthorLastNameAndFirstName(String lastName, String firstName);

    List<ArticleEntity> findAllByKeyword(String keyword);

}
