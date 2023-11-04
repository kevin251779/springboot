package com.example.demo.Repos;

import com.example.demo.Models.LikeList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeListRepo extends JpaRepository<LikeList, Long> {
    LikeList findBySn(long sn);

}
