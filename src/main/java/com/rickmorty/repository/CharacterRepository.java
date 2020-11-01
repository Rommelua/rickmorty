package com.rickmorty.repository;

import com.rickmorty.model.Character;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends CrudRepository<Character, Long> {
    List<Character> findByNameContainingIgnoreCase(String query);
}
