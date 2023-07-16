package com.mindtree.client;

import java.util.List;
import java.util.Scanner;
import com.mindtree.entity.Hotel;
import com.mindtree.entity.Room;
import com.mindtree.exception.serviceexception.HotelServiceException;
import com.mindtree.service.HotelService;
import com.mindtree.service.HotelServiceImpl;

public class HotelApplication {
	private static Scanner input = new Scanner(System.in);
	private static HotelService hotelService = new HotelServiceImpl();

	public static void main(String[] args) {
		HotelApplication app = new HotelApplication();
		int choice;
		do {
			choice = app.createMenu();
			switch (choice) {
			case 1:
				System.out.println(app.insertToHotel());
				break;
			case 2:
				System.out.println("Enter city:");
				String city = input.next();
				List<Hotel> hotelList = null;
				try {
					hotelList = hotelService.getHotelsBasedOnCity(city);
				} catch (HotelServiceException e) {

					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (hotelList != null) {
					System.out.println("The hotel details are :");
					app.printHotels(hotelList);
				}
				 else
					System.out.println("Hotel list empty!!");
				break;
			case 3:
				System.out.println("Exit");
				break;
			}
		} while (choice != 3);
	}

	private int createMenu() {
		System.out.println("\n--------------------HOTEL APPLICATION-------------------");
		System.out.println("Enter your choice :");
		System.out.println("1.Add new Hotel and assign rooms");
		System.out.println("2.Get hotels by city");
		System.out.println("3.Exit");
		int choice = input.nextInt();
		return choice;
	}

	private void printHotels(List<Hotel> hotelList) {
		for (int i = 0; i < 35; i++)
			System.out.print("-");
		System.out.println();
		System.out.printf("|%10s|%11s|%11s|\n", "Id", "Name", "Location");
		hotelList.forEach(hotel -> {
			for (int i = 0; i < 35; i++)
				System.out.printf("-");
			System.out.println();
			System.out.printf("|%10s|%11s|%11s|\n", hotel.getId(), hotel.getName(), hotel.getLication());
			for (int i = 0; i < 35; i++)
				System.out.print("-");
			System.out.println();
			System.out.println("The room details in that hotel ");
			List<Room> roomList = null;
			try {
				roomList = hotelService.getRoomsBelongToHotel(hotel.getId());
			} catch (HotelServiceException e) {
				e.printStackTrace();
			}
			if (roomList != null)
				printRooms(roomList);
			else
				System.out.println("rooms empty for hotel " );
		
		});
	}

	private void printRooms(List<Room> roomList) {
		for (int i = 0; i < 35; i++)
			System.out.print("-");
		System.out.println();
		System.out.printf("|%10s|%12s|%10s|\n", "Id", "Type", "Price");
		roomList.forEach(room -> {
			for (int i = 0; i < 35; i++)
				System.out.printf("-");
			System.out.println();
			System.out.printf("|%10s|%12s|%10s|\n", room.getId(), room.getType(), room.getPrice());
		});
		for (int i = 0; i < 35; i++)
			System.out.print("-");
		System.out.println();
	}

	private String insertToHotel() {
		boolean insertedtoHotel = false;
		boolean insetedtoRoom = false;
		System.out.println("Enter the hotelId :");
		String id = input.next();
		System.out.println("Enter the hotel name :");
		String name = input.next();
		System.out.println("Enter the hotel location :");
		String location = input.next();
		try {
			insertedtoHotel = hotelService.insertHotelIntoDB(id, name, location);
		} catch (HotelServiceException e) {

			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (insertedtoHotel) {
			System.out.println("Hotel insertion successful");
			System.out.println("Enter no of rooms :");
			int noOfrooms = input.nextInt();
			for (int i = 1; i <= noOfrooms; i++) {
				System.out.println("Enter room " + (i) + " details :");
				insetedtoRoom = insertIntoRoom(id);
				if (insetedtoRoom)
					System.out.println("Room inserted ");
				else
					System.out.println("Room does not get inserted ");
			}
			return "Hotel created !!";
		} else {
			System.out.println("Hotel insertion not successful");
		}
		return "Hotel not created !!";
	}

	private boolean insertIntoRoom(String hotelid) {
		System.out.println("Enter room Id :");
		String id = input.next();
		System.out.println("Enter the room type :");
		String type = getValidatedInput("roomtype");
		System.out.println("Enter the room price :");
		int price = input.nextInt();
		try {
			return hotelService.insertRoomIntoDB(id, type, price, hotelid);
		} catch (HotelServiceException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private String getValidatedInput(String validationType) {
		String inputString;
		boolean isValid;
		int inputChoice;
		switch (validationType) {
		case "roomtype":
			do {
				isValid = true;
				System.out.println("1. Luxury");
				System.out.println("2. Semi Luxury");
				System.out.println("3. Deluxe");
				inputChoice = input.nextInt();
				if (inputChoice == 1)
					inputString = "Luxury";
				else if (inputChoice == 2)
					inputString = "Semi Luxury";
				else if (inputChoice == 3)
					inputString = "Deluxe";
				else {
					inputString = null;
					isValid = false;
					System.out.println("Wrong choice try again!!");
				}
			} while (!isValid);
			return inputString;
		}
		return null;
	}
}
