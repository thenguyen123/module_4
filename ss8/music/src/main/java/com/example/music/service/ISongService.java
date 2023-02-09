package com.example.music.service;

import com.example.music.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    void save(Song song);
    void update(Song song);
    Song findById(int id);
}
