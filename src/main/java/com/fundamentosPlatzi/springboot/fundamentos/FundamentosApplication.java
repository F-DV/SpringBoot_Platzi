package com.fundamentosPlatzi.springboot.fundamentos;

import com.fundamentosPlatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosPlatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosPlatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosPlatzi.springboot.fundamentos.bean.MyBeanWithPropertiesImplement;
import com.fundamentosPlatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosPlatzi.springboot.fundamentos.pojo.UserPojo;
import org.apache.catalina.User;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.apache.tomcat.util.security.Escape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency;										//Declaramos interface
	//private MyBean myBean;																	//Declaramos la interface
	private MyBeanWithDependency myBeanWithDependency;
	//private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;

	@Autowired
	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, UserPojo userPojo,MyBeanWithDependency myBeanWithDependency){

		this.componentDependency = componentDependency;										//Instanciamos la interface, "la inyectamos"
		//this.myBean = myBean;																//Inyectamos la dependencia en el constructor
		this.myBeanWithDependency = myBeanWithDependency;									//Inyectamos dependencia
		///this.myBeanWithProperties = myBeanWithProperties;								//Inyectamos dependencia con bean en confidurations
		this.userPojo = userPojo;
	}


	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		ejemplosAnteriores();

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
