package com.alev.dao;

import com.alev.models.Content;

import java.util.List;

public interface MediaDao {

    public void save(Content content);
    public List<Content> getAll();

}