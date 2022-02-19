package com.fundamentosPlatzi.springboot.fundamentos;

import com.fundamentosPlatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosPlatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosPlatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosPlatzi.springboot.fundamentos.bean.MyBeanWithPropertiesImplement;
import com.fundamentosPlatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosPlatzi.springboot.fundamentos.entity.User;
import com.fundamentosPlatzi.springboot.fundamentos.pojo.UserPojo;
import com.fundamentosPlatzi.springboot.fundamentos.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.apache.tomcat.util.security.Escape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication

public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency;										//Declaramos interface
	//private MyBean myBean;																	//Declaramos la interface
	private MyBeanWithDependency myBeanWithDependency;
	//private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;


	@Autowired
	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, UserPojo userPojo,MyBeanWithDependency myBeanWithDependency,UserRepository userRepository){

		this.componentDependency = componentDependency;										//Instanciamos la interface, "la inyectamos"
		//this.myBean = myBean;																//Inyectamos la dependencia en el constructor
		this.myBeanWithDependency = myBeanWithDependency;									//Inyectamos dependencia
		///this.myBeanWithProperties = myBeanWithProperties;								//Inyectamos dependencia con bean en confidurations
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		//ejemplosAnteriores();
		saveUsersInDatabase();
		getInformationJpqlFromUser();

	}
	private void getInformationJpqlFromUser(){
		LOGGER.info("Usuario con el metodo findByuserEmail : " + userRepository.findByUserEmail("Felipe@gmail.com").
				orElseThrow(() -> new RuntimeException("No se encontro el usuario")));
	}

	private void saveUsersInDatabase(){
		User user1 = new User("Jhon","Jhon@gmail.com", LocalDate.of(2021,03,20));
		User user2 = new User("Felipe","Felipe@gmail.com", LocalDate.of(2021,05,13));
		User user3 = new User("Andres","Andres@gmail.com", LocalDate.of(2021,07,20));
		User user4 = new User("Carlos","Carlos@gmail.com", LocalDate.of(2021,01,19));
		User user5 = new User("Andredy","Andredy@gmail.com", LocalDate.of(2021,02,18));
		User user6 = new User("Jairo","Jairo@gmail.com", LocalDate.of(2021,10,17));
		User user7 = new User("Fernando","Fernandp@gmail.com", LocalDate.of(2021,12,16));
		User user8 = new User("Amanda","Amanda@gmail.com", LocalDate.of(2021,01,15));
		User user9 = new User("Sara","Sara@gmail.com", LocalDate.of(2021,02,14));
		User user10 = new User("Maxi","maxi@gmail.com", LocalDate.of(2021,03,13));
		List<User> list = Arrays.asList(user1,user2,user3,user4,user4,user5,user6,user7,user8,user9,user9);
		list.stream().forEach(userRepository::save);

	}

	public void ejemplosAnteriores(){
		componentDependency.saludar();
		//myBean.print();
		myBeanWithDependency.printWithDependency();
		//System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getAge() + " " + userPojo.getPassword());

		try{
			//funcionalidad que genera error
			int value = 10/0;
			LOGGER.debug("mi valor : " + value);
		}catch(Exception e){
			LOGGER.error("Esto es un error al dividir por cero" + e.getStackTrace());
		}
	}
}
