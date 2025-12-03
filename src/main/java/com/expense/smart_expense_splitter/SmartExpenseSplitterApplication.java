package com.expense.smart_expense_splitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SmartExpenseSplitterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartExpenseSplitterApplication.class, args);
        System.out.println("SmartExpenseSplitterApplication started..");
	}

}
