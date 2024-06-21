package com.example.Notes_App.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;

import com.example.Notes_App.entity.Notes;
import com.example.Notes_App.entity.User;

public interface NotesRepository extends JpaRepository<Notes, Integer> {
    
    // Find all notes associated with a user
    List<Notes> findByUser(User user);
    
    // Find the top 10 latest notes for a user, ordered by created date
    List<Notes> findTop10ByUserOrderByCreatedDtDesc(User user);
    
    // Custom query to find the last ten note IDs for a user
    @Query("SELECT n.id FROM Notes n WHERE n.user.id = :userId ORDER BY n.createdDt DESC")
    List<Long> findLastTenNoteIds(@Param("userId") Long userId, Pageable pageable);
    
    // Custom query to delete notes for a user that are not in the last ten note IDs
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM notes WHERE user_id = :userId AND id NOT IN :lastTenNoteIds", nativeQuery = true)
    void deleteUsers(@Param("userId") Long userId, @Param("lastTenNoteIds") List<Long> lastTenNoteIds);
}
