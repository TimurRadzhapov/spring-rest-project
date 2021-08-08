package com.restapp.restapi.repository;

import com.restapp.restapi.model.StudentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentResponseRepository extends JpaRepository<StudentResponse, Long> {
    @Query(value = "select st.id, st.full_name, st.date_of_birth, pr.text as progress from students st left join progress pr  on (st.progress_id = pr.id)", nativeQuery = true)
    List<StudentResponse> getAllStudents();
}
