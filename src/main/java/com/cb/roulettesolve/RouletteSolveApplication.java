package com.cb.roulettesolve;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class RouletteSolveApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(RouletteSolveApplication.class, args);
	}
	@Override
	public void run(String... args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a number: ");
		int enteredNumber = scanner.nextInt();
		System.out.print("Enter a 2nd number: ");
		int secondNumber = scanner.nextInt();

		int profit = 0;
		int profit2 = 0;
		for(int x =0; x < 1000000000; x++){
			Random random = new Random();
			int randomNumber = random.nextInt(37);

			if(enteredNumber == randomNumber){
				profit += 350;
				profit2 += 170;
			} else if (secondNumber == randomNumber) {
				profit2 += 170;
				profit -= 10;
			} else {
				profit2 -= 10;
				profit -= 10;
			}
		}
		System.out.println("You entered: " + enteredNumber);
		System.out.println("we simulated 1000000000 roulette roles at 10$ each roll");
		System.out.println("Totala profit betting $10 on 1 number: $" + profit);
		System.out.println("Totala profit betting $5 on 2 separate numbers: $" + profit2);

		scanner.close();
	}
}
