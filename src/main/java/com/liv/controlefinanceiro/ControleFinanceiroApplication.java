package com.liv.controlefinanceiro;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ControleFinanceiroApplication implements CommandLineRunner {
	
//	@Autowired
//	private S3Service s3;


	public static void main(String[] args) {
		SpringApplication.run(ControleFinanceiroApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {		
//		s3.uploadFile("//home//04534779682//jaguar.jpg");
	}

}
