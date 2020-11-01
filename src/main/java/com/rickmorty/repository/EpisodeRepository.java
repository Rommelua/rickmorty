package com.rickmorty.repository;

import com.rickmorty.model.Episode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodeRepository extends CrudRepository<Episode, Long> {
    Episode getByUrl(String url);
}
