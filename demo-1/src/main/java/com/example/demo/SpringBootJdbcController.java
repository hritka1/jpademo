package com.example.demo;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.User;

@Controller
public class SpringBootJdbcController extends JdbcDaoSupport {
		
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value="/")
	public String Index()
	{
		//jdbc.execute("insert into user values(11,'as')");
		return "home";
	}
	
	
	User u;
	
	@RequestMapping(method = RequestMethod.POST, value="/insert")
	public String insert()
	{
		/* jdbc.execute("insert into user values('${user.id}','${user.name})'"); */
		String sql = "INSERT INTO user " +
				"(id, name) VALUES (?, ?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				u.getId(), u.getName()});
		return "home";
	}
}

