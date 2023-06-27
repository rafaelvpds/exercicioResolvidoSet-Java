package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.Users;

public class Program {

	public static void main(String[] args) {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter with File");

		Set<Users> set = new HashSet<>();
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {
				String fields[] = line.split(" ");
				String name = fields[0];
				String date = fields[1];
				set.add(new Users(name, formato.parse(date)));
				line = br.readLine();

			}

			System.out.println("Total users " + set.size());

			for (Users user : set) {
				System.out.println(user.getName());
			}

		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

		sc.close();

	}

}
