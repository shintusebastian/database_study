package co.pragra.learning.databaselearning.dao;

import co.pragra.learning.databaselearning.domain.Student;
import co.pragra.learning.databaselearning.mapper.StudentMapper;
import lombok.Data;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository//we use this annotation to represent database classes.
@Data


public class StudentDAO {

    private NamedParameterJdbcTemplate template;

    public StudentDAO(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    //    private JdbcTemplate template;
//
//using jdbc template
//    public StudentDAO(JdbcTemplate template) {
//        this.template = template;
//    }
//    public boolean createStudent(Student student){//creating a method to create a Student.
//        String sql="INSERT INTO STUDENT VALUES ( ? , ? , ? , ? , ? )";//we added question mark to replace with value later on
//        int update = template.update(sql, student.getId(), student.getFirstName(), student.getLastName(), student.getCreateDate(), student.getUpdateDate());
//
//        if(update!=1){//we make sure only 1 row is getting updated.
//    return false;
//
//}
//return true;
//    }
    //using Named parameter jdbc template.
    public boolean createStudent(Student student){//creating a method to create a Student.
        String sql="INSERT INTO STUDENT VALUES ( :id , :firstName , :lastName , :createDate , :updateDate )";
        int update = template.update(sql, new BeanPropertySqlParameterSource(student));//this should match with the bean name

        if(update!=1){//we make sure only 1 row is getting updated.
    return false;

}
return true;
    }

    public List<Student> getAllStudent(){
        return template.query("SELECT * FROM STUDENT", new BeanPropertyRowMapper<>(Student.class));

        //the BeanProperty Row Mapper will check the property of Student Class and map it with the database column.
    }


//implementation using jdbc template
//    public void updateStudent(Student student){
//        String sql= "UPDATE STUDENT SET LAST_NAME='SEB' WHERE FIRST_NAME='Shintu'";
//        template.execute(sql);
//
//   }
    //implementation using jdbc template
//    public Student updateFirstName(String firstName, int id){
//        String sql="UPDATE STUDENT SET FIRST_NAME=? WHERE ID=?";// we should remember the question marks properly.
//        int update = template.update(sql, firstName, id);
//return getbyId(id);
//    }

    public Student updateFirstName(String firstName, int id){
        String sql="UPDATE STUDENT SET FIRST_NAME=:firstName WHERE ID=:id";// we should remember the question marks properly.
        Map<String,Object> map=new HashMap<>();
        map.put("id",id);
        map.put("firstName",firstName);
        int update = template.update(sql, map);
return getbyId(id);
    }
//implementatino using JDBC template
//    public Student getbyId(int id){
//        return template.queryForObject("SELECT * FROM STUDENT WHERE ID = ? ", new StudentMapper(),id);
//
//    }
public Student getbyId(int id){
    return template.queryForObject("SELECT * FROM STUDENT WHERE ID = :id ", Collections.singletonMap("id",id), new StudentMapper());

}

//implementation using JDBC class.
//    public Student getbyID(int id){
//        return template.queryForObject("SELECT * FROM STUDENT WHERE ID = ? ",
//                (rs,index)->Student.builder().id(rs.getInt("ID")).firstName(rs.getString("FIRST_NAME")).
//                        lastName(rs.getString("LAST_NAME")).createDate(rs.getDate("CREATE_DATE").
//                                toInstant()).
//                        updateDate(rs.getDate("UPDATE_DATE").toInstant()).build()
//                ,id);

//    }
}
