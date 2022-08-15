package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.fundamentos.bean.MyBeanYaalan;
import com.fundamentos.springboot.fundamentos.component.ComponentDependency;
import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.pojo.UserPojo;
import com.fundamentos.springboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
	@Qualifier("componentTwoImplement")
	private final ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;

	private MyBeanYaalan myBeanYaalan;

	private MyBeanWithProperties myBeanWithProperties;

	private UserPojo userPojo;

	private UserRepository userRepository;
	public FundamentosApplication(ComponentDependency componentDependency, MyBean myBean,MyBeanWithDependency myBeanWithDependency,MyBeanYaalan myBeanYaalan,MyBeanWithProperties myBeanWithProperties,UserPojo userPojo,UserRepository userRepository){
      this.componentDependency=componentDependency;
	  this.myBean=myBean;
	  this.myBeanWithDependency=myBeanWithDependency;
	  this.myBeanYaalan=myBeanYaalan;
	  this.myBeanWithProperties=myBeanWithProperties;
	  this.userPojo=userPojo;
	  this.userRepository=userRepository;
	}
	public static void main(String[] args) {

		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//ejemplosInyeccion();
		saveUsersInDataBase();
	}

	private void saveUsersInDataBase(){
		User user =new User("Yaalan","yaalan23@gmail.com", LocalDate.of(1997,01,25));
		User user1 =new User("lucia","lucia23@gmail.com", LocalDate.of(1996,02,20));
		User user4 = new User("Oscar", "oscar@domain.com", LocalDate.of(1998,03,15));
		User user5 = new User("Test1", "Test1@domain.com", LocalDate.of(1995,04,10));
		User user6 = new User("Test2", "Test2@domain.com", LocalDate.of(1988,05,12));
		User user7 = new User("Test3", "Test3@domain.com", LocalDate.of(1977,06,28));
		User user8 = new User("Test4", "Test4@domain.com", LocalDate.of(1999,07,26));
		User user9 = new User("Test5", "Test5@domain.com", LocalDate.of(2000,8,11));
		User user10 = new User("Test6", "Test6@domain.com", LocalDate.of(2005,9,03));
		User user11 = new User("Test7", "Test7@domain.com", LocalDate.of(2007,10,9));
		User user12 = new User("Test8", "Test8@domain.com", LocalDate.of(2012,11,07));
		User user13 = new User("Test9", "Test9@domain.com", LocalDate.of(2021,12,01));

		List <User> list= Arrays.asList(
				user,
				user1,
				user4,
				user5,
				user6,
				user7,
				user8,
				user9,
				user10,
				user11,
				user12,
				user13);

		list.stream().forEach(userRepository::save);

	}

	private  void ejemplosInyeccion(){
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		myBeanYaalan.datosYaalan("juan", 25, "yaalan23@gmail.com");
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + "-" + userPojo.getPassword() + "-" + userPojo.getAge());
		try {
			int value = 10 / 0;
			LOGGER.debug("El resultado es:" + value);
		} catch (Exception e) {
			LOGGER.error("Esto es un error al dividir por cero"+ e.getMessage());
		}
	}
}
