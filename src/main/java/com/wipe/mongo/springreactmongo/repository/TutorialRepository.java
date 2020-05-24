package com.wipe.mongo.springreactmongo.repository;

import java.util.List;

import com.wipe.mongo.springreactmongo.model.Tutorial;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TutorialRepository extends MongoRepository<Tutorial, String> {
  List<Tutorial> findByTitleContaining(String title);

  List<Tutorial> findByPublished(boolean published);
}