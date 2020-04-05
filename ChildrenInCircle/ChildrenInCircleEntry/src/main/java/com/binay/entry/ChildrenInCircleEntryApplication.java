package com.binay.entry;

import java.util.Optional;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.binay.algo.ChildrenInCircle_GameManager;
import com.binay.algo.exception.InvalidArguementException;

import lombok.extern.slf4j.Slf4j;



@SpringBootApplication(scanBasePackages = {"com.binay.entry", "com.binay.algo"})
@Slf4j
public class ChildrenInCircleEntryApplication implements CommandLineRunner{

	public static void main(String[] args) {
		
		SpringApplication app = new SpringApplication(ChildrenInCircleEntryApplication.class);
		app.setBannerMode(Banner.Mode.CONSOLE);
        app.run(args);
		
	}

	@Override
	public void run(String... args) throws Exception {

		try {

			int n = 0;
			int k = 0;

			if (args.length > 0 ) {
				for (String arg : args) {

					if(arg.contains("n="))
						n = Integer.parseInt(arg.replace("n=", ""));

					if(arg.contains("k="))
						k = Integer.parseInt(arg.replace("k=", ""));
				}  
			}


			Optional<ChildrenInCircle_GameManager.GameOutputEntity> outputEntity = ChildrenInCircle_GameManager.getEliminationSequenceAndWinner(n, k);
			System.out.println("Sequence of children as they go out : " + outputEntity.get().getEliminationSequence());
			System.out.println("Id of the winning child : " + outputEntity.get().getWinnerIndex());

		}catch(InvalidArguementException e)
		{
			log.error("PLEASE PROVIDE CORRECT INPUT");
		}
		catch(NumberFormatException e)
		{
			log.error("Invalid number porvided");
		}

	}
	
}
