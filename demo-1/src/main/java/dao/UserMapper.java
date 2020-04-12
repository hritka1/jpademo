package dao;

public interface UserMapper implements RowMapper<Student> 
{
	   public Student mapRow(ResultSet rs, int rowNum) throws SQLException 
	   {
		      Student student = new Student();
		      student.setId(rs.getInt("id"));
		      student.setName(rs.getString("name"));
		      student.setAge(rs.getInt("age"));
		      return student;
		}
}