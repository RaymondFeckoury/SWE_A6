package com.example.demo.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.MovieEntity;


@Repository
public interface Movierepo extends JpaRepository<MovieEntity,String> {
 //List<MovieEntity>findidBymoviename(String moviename);
}