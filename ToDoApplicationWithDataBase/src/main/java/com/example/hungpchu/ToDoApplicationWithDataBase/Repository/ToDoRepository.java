package com.example.hungpchu.ToDoApplicationWithDataBase.Repository;

import com.example.hungpchu.ToDoApplicationWithDataBase.Model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
public interface ToDoRepository  extends JpaRepository<ToDo, Long> {

    /**
     * @Transactional and @Modifying needed for update or delete query
     * @param deleteKey
     */
    @Transactional
    @Modifying
    @Query("DELETE FROM ToDo t WHERE t.title = :deleteKey OR t.detail =: deleteKey")
    void deleteAllShit(@Param("deleteKey") String deleteKey );
}
