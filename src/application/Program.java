package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

public class Program {
	
	public static void main(String args[]) {
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		List<Shape> list = new ArrayList<>();
		
		System.out.print("Enter the number of shapes: ");
		int n = scan.nextInt();
		
		for(int i = 1; i<=n; i++) {
			System.out.println("Shape #" + i + " data: ");
			System.out.print("Retangle or Cricle (r/c?)");
			char answer = scan.next().charAt(0);
			System.out.println("Color (BLACK/BLUE/RED)");	
			Color color = Color.valueOf(scan.next().toUpperCase());
			scan.nextLine();
			if (answer == 'r') {
				System.out.print("Width: ");
				Double width = scan.nextDouble();
				System.out.print("Height: ");
				Double height = scan.nextDouble();
				scan.nextLine();
				
				Shape rectangle = new Rectangle(color, width, height);
				list.add(rectangle);
				
			}else if (answer == 'c') {
				System.out.print("Radius: ");
				Double radius = scan.nextDouble();
				scan.nextLine();
				
				Shape circle = new Circle(color, radius);
				list.add(circle);
			} else {
				System.out.print("Invalid shpe type");
				i--;
			}
		}
		
		System.out.println();
		System.out.println("SHAPE AREAS: ");
		for(Shape shape : list) {
			System.out.println(String.format("%.2f", shape.area()));
		}
		
		scan.close();
		
	}
}
