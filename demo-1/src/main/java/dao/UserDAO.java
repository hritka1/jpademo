package dao;
import java.util.List;
import javax.sql.DataSource;

import com.example.demo.bean.User;

public interface UserDAO {
	
	/** 
     * This is the method to be used to initialize
     * database resources ie. connection.
  */
  public void setDataSource(DataSource ds);
  
  /** 
     * This is the method to be used to list down
     * all the records from the Student table.
  */
  public List<User> listUser();
  
  /** 
     * This is the method to be used to delete
     * a record from the Student table corresponding
     * to a passed student id.
  */
  public void delete(Integer id); 

}
