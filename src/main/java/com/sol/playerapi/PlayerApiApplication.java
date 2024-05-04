package com.sol.playerapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.sol.service.CSVReaderService;

@SpringBootApplication(scanBasePackages = {"com.sol"})
public class PlayerApiApplication {
	
	@Autowired
    private CSVReaderService csvReaderService;

	public static void main(String[] args) {
		SpringApplication.run(PlayerApiApplication.class, args);
	}
	
//	@Bean
//    public CommandLineRunner commandLineRunner() {
//        return args -> {
//            System.out.println("Starting CSV import");
//            csvReaderService.readCSV("player.csv");
//            System.out.println("CSV import finished");
//        };
//    }

}
