package excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entity.Player;

public class ExcelWriteApp {
	private static Scanner input = new Scanner(System.in);
	private static final String PATH = "C:\\Users\\RR COMPUTERS\\Desktop\\IndianTeam.xlsx";

	public static void main(String[] args) {
		List<Player> playerList = new ArrayList<Player>();
		ExcelWriteApp excelApp = new ExcelWriteApp();
		System.out.println("Enter no of players :");
		int noOfPlayers = input.nextInt();
		for (int i = 0; i < noOfPlayers; i++) {
			System.out.println("Enter player " + (i + 1) + " details:");
			playerList.add(excelApp.getPlayerDetails());
		}
		try {
			excelApp.writeExcel(playerList, PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Player getPlayerDetails() {
		System.out.println("Enter player firstName :");
		String firstName = input.next();
		System.out.println("Enter player lastName :");
		String lastName = input.next();
		System.out.println("Enter jersy number :");
		int jersyNumber = input.nextInt();
		return new Player(firstName, lastName, jersyNumber);
	}

	public void writeExcel(List<Player> PlayerList, String excelFilePath) throws IOException {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet();

		int rowCount = 0;

		for (Player player : PlayerList) {
			Row row = sheet.createRow(++rowCount);
			WritePlayerInARow(player, row);
		}

		try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
			workbook.write(outputStream);
			workbook.close();
		}
	}

	private void WritePlayerInARow(Player player, Row row) {
		Cell cell = row.createCell(1);
		cell.setCellValue(player.getFirstName());

		cell = row.createCell(2);
		cell.setCellValue(player.getLastName());

		cell = row.createCell(3);
		cell.setCellValue(player.getJersyNumber());
	}
}
