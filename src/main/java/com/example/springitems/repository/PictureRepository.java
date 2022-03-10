package com.example.springitems.repository;

import com.example.springitems.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture,Integer> {



}
