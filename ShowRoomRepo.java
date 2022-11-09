package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.ShowRoom;

@Repository
public interface ShowRoomRepo extends JpaRepository<ShowRoom,String> {

}
