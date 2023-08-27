package com.blogger.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blogger.entities.BlogData;

@Repository
public interface BlogDataRepository extends CrudRepository<BlogData, Integer> {

}
