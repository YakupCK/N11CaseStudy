package com.n11.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Utils {

	//path of the file to read/write footer links
	static String path="src/test/resources/file.txt";

	public static void waitForTab(int numberOfTabs){
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
		wait.until(ExpectedConditions.numberOfWindowsToBe(numberOfTabs));
	}

	public static void waitForClickability(By locator){
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static void waitForClickability(WebElement element){
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void switchToWindow(int index){
		Set<String> windowHandles = Driver.getDriver().getWindowHandles();
		ArrayList<String> allTabs = new ArrayList<>(windowHandles);
		Driver.getDriver().switchTo().window(allTabs.get(index));
	}

	public static String getText(WebElement element){
		return element.getText();
	}

	public static void waitForPresence(By locator){
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public static void waitForVisibility(WebElement element){
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void writeTextToFile(List<String> list){
		try{
			// Create new file
			File file = new File(path);

			// If file exists, delete it
			if (file.exists()) {
				file.delete();
			}
			file.createNewFile();

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			// Write in file
			for (String item : list) {
				bw.write(item);
				bw.newLine();
			}

			// Close connection
			bw.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public static List<String> readTextFromFile() {
		ArrayList<String> list = new ArrayList<>();
		try {
			File file = new File(path);
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()) {
				list.add(scanner.nextLine());
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


}
