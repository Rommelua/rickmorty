package com.rickmorty.repository;

import com.rickmorty.model.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {
    Location getByUrl(String url);
}
