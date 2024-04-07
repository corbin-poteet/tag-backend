package com.thrive.tagbackend.repository;

import com.thrive.tagbackend.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TagRepository extends JpaRepository<Tag, String> {

}
