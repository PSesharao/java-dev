package com.mindtree.client;

import java.util.Scanner;
import org.hibernate.Session;
import com.mindtree.entity.Song;
import com.mindtree.utility.SessionUtil;

public class SongApp {
	private static Scanner input = new Scanner(System.in);
	private static Song songObj;
	private static SessionUtil hbutil = new SessionUtil();

	public static void main(String[] args) {
		Session sessionObj = null;
		try {
			sessionObj = hbutil.buildSession().openSession();
			sessionObj.beginTransaction();

			for (int i = 1; i <= 1; i++) {
				System.out.println("Enter song " + (i) + " details :");
				songObj = getSongDetails();
				sessionObj.save(songObj);
			}
			System.out.println("\n.......Records Saved Successfully To The Database.......\n");
			/*songObj = sessionObj.get(Song.class, "song1");
			System.out.println(songObj);*/
			sessionObj.getTransaction().commit();
			
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			hbutil.closeResource(sessionObj);
		}
		
	}

	private static Song getSongDetails() {
		System.out.println("Enter the song Id:");
		String songId = input.next();
		System.out.println("Enter the song name:");
		String songName = input.next();
		return new Song(songId, songName);
	}

}
