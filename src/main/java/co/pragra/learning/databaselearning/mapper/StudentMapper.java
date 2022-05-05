package co.pragra.learning.databaselearning.mapper;

import co.pragra.learning.databaselearning.domain.Student;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
       return Student.builder().id(rs.getInt("ID")).firstName(rs.getString("FIRST_NAME")).
                lastName(rs.getString("LAST_NAME")).build();
//        createDate(rs.getDate("CREATE_DATE").toInstant()).
//                updateDate(rs.getDate("UPDATE_DATE").toInstant()) this code gave us error. So we removed it.
    }
}

