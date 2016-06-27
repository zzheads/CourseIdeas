package com.zzheads.model;

import java.util.List;

/**
 * Created by zzhea on 27.06.2016.
 */
public interface CourseIdeaDAO {
    boolean add(CourseIdea idea);

    List<CourseIdea> findAll ();

    CourseIdea findBySlug (String slug);
}
