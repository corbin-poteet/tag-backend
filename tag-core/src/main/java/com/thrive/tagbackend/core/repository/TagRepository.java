package com.thrive.tagbackend.core.repository;

import com.thrive.tagbackend.core.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TagRepository extends JpaRepository<Tag, String> {

}
