package co.pragra.learning.databaselearning.dao;

import co.pragra.learning.databaselearning.domain.Course;
import lombok.Data;
import lombok.NoArgsConstructor;//this has failed the running of the application.
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Data

public class CourseDAO {
   // private JdbcTemplate template;

    private NamedParameterJdbcTemplate template;

    public CourseDAO(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    //    public CourseDAO(JdbcTemplate template) {
//        this.template = template;
//    }
//    public boolean createCourse(Course course){
//        String sql="INSERT INTO COURSE VALUES ( ?, ?, ?, ?, ?)";
//        int update = template.update(sql, course.getId(), course.getCourseName(), course.getCourseFee(), course.getCreateDate(), course.getUpdateDate());
//   if(update!=1){
//       return false;
//   }
//   return true;
//    }
    public boolean createCourse(Course course){
        String sql="INSERT INTO COURSE VALUES (:id, :courseName, :courseFee, :createDate, :updateDate )";
        int update = template.update(sql, new BeanPropertySqlParameterSource(course));
        if(update!=1){//we make sure only 1 row is getting updated.
            return false;
        }
        return true;
    }


    public List<Course> getAllCourse(){
     return   template.query("SELECT * FROM COURSE", new BeanPropertyRowMapper<>(Course.class));
    }
}

