package com.zzheads.model;

import com.github.slugify.Slugify;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zzhea on 27.06.2016.
 */
public class CourseIdea {
    private String title;
    private String creator;
    private String slug;
    private Set<String> voters;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseIdea that = (CourseIdea) o;

        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        return creator != null ? creator.equals(that.creator) : that.creator == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        return result;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getSlug() {
        return slug;
    }

    public List<String> getVoters() {
        return new ArrayList<>(voters);
    }

    public boolean addVoter (String voterUserName) {
        return voters.add(voterUserName);
    }

    public int getVoteCount() {
        return voters.size();
    }

    public CourseIdea(String title, String creator) throws IOException {
        voters = new HashSet<>();
        this.title = title;
        this.creator = creator;
        try {
            Slugify slugify = new Slugify();
            slug = slugify.slugify(title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
