package com.example.db_setup;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team,Integer>{
    
    public static <I extends Collection<Team>> List<Team.ReducedDTO> mapDto(I collection){
            return collection.stream().map(t->(new Team.ReducedDTO(t))).toList();
    }
    
    List<Team> findAll();
    
    Team getById(Integer ID);

    @Modifying
    @Transactional
    @Query(
        value="Insert INTO student_team_association(team_id, user_id) VALUES (:tid, :uid)",
        nativeQuery = true
    )
    public int insertStudent(@Param("uid") Integer uid, @Param("tid") Integer tid);

    @Transactional
    @Modifying
    @Query(
        value="Delete FROM student_team_association WHERE team_id=:tid and user_id=:uid",
        nativeQuery = true
    )
    public int deleteStudent(@Param("uid") Integer uid, @Param("tid") Integer tid);

    @Query(
        value="SELECT t.* FROM teams t JOIN student_team_association s WHERE s.user_id=:user AND s.team_id=t.id;",
        nativeQuery = true
    )
    public List<Team> getStudentTeams(@Param("user") Integer user);
}