package com.example.Employment.Manager.EmploymentManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmploymentManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmploymentManagerApplication.class, args);
	}
	/*
	* Если поменять EmployeeController на EmployeeRepositoryImpl вылетала ошибка зациклиности(в EmployeeRepository создавал метод update)
	* Если в EmployeeRepository добавить метод, то при EmployeController вылетит исключение,
	  проблема в слове update как я понял, там не создание, а немного иное переопределение что ли?
	  Т.к. метод findPosition так же выкинет исключение.
	* Немного не разобрался как добавить метод update, при моём способе он не изменяет а создает новый,
	* Скорее всего проблема в автогенерации id, надо попробовать убрать и глянуть результат.
	* */
}
