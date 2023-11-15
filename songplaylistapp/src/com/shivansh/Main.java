package com.shivansh;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

public class Main {
	private static ArrayList<album> albums = new ArrayList<album>();

	public static void main(String[] args) {
		
		
		
		
		album album= new album(name:"album1",artist:"ac/dc");
		
	album.addsong(title:"TNT", Duration:4.5);
	album.addsong(title:"highway to hell",Duration:3.5);
	album.addsong(title:"thunder struck",Duration:5.0);
	albums.add(album);
	
	album=new album(name:"album2",artist:"eminem");
	
	album.addsong(title:"rap god", Duration:4.5);
	album.addsong(title:"not afraid",Duration:3.5);
	album.addsong(title:"lose yourself",Duration:5.0);
	albums.add(album);
	
	LinkedList<song> playlist_1=new LinkedList<song>();
	albums.get(0).addtoplaylist(title:"TNT", playlist_1);
	albums.get(0).addtoplaylist(title:"highway to hell", playlist_1);
	albums.get(1).addtoplaylist(title:"rap god", playlist_1);
	albums.get(1).addtoplaylist(title:"lose yourself", playlist_1);
	
	play(playlist_1);
	
		
		

	}

	private static void play(LinkedList<song> playList) {
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		boolean forward = true;
		ListIterator<song> listIterator = playList.listIterator();
		if (playList.size() == 0) {
			System.out.println("this playlist have no song");

		} else {
			System.out.println("now playing " + listIterator.next().toString());
			printmenu();

		}
		while (!quit) {
			int action = sc.nextInt();
			sc.nextLine();

			switch (action) {
			case 0:
				System.out.println("playlist complete");
				quit = true;
				break;

			case 1:
				if (!forward) {
					if (listIterator.hasNext()) {
						listIterator.next();
					}
					forward = true;
				}
				if (listIterator.hasNext()) {
					System.out.println("now playing " + listIterator.next().toString());
				} else {
					System.out.println("no song available,reached to the end of the list");
					forward = false;
				}
				break;

			case 2:
				if (forward) {
					if (listIterator.hasPrevious()) {
						listIterator.previous();
					}
					forward = false;

				}
				if (listIterator.hasPrevious()) {
					System.out.println("now playing " + listIterator.previous().toString());
				} else {
					System.out.println("we are at the first song");
					forward = false;
				}
				break;
			case 3:
				if (forward) {
					if (listIterator.hasPrevious()) {
						System.out.println("now playing :" + listIterator.previous().toString());
						forward = false;
					} else {
						System.out.println("we  are at the start of the list");
					}
				} else {
					if (listIterator.hasNext()) {
						System.out.println("now playing :" + listIterator.next().toString());
						forward = true;
					} else {
						System.out.println("we have reached the end of the list");
					}
				}
				break;
			case 4:
				printlist(playList);
				break;
			case 5:
				printmenu();
				break;
			case 6:
				if (playList.size() > 0) {
					listIterator.remove();
					if (listIterator.hasNext()) {
						System.out.println("now playing :" + listIterator.next().toString());

					} else {
						if (listIterator.hasPrevious()) {
							System.out.println("now playing :" + listIterator.previous().toString());
						}

					}
				}

			}
		}

	}

	private static void printmenu() {
		System.out.println("available options \n press");
		System.out.println(
				"0-to quit\n" + "1-to play next song\n" + "2-to play previous song\n" + "3-to replay the current song"
						+ "4-list of all song\n" + "5-print all available options\n" + "6- delete current song");

	}

	private static void printlist(LinkedList<song> plaList) {
		Iterator<song> iterator = plaList.iterator();
		System.out.println("............................");
		while (iterator.hasNext()) {
			System.out.println(iterator.next());

		}
		System.out.println("...............................");

	}

}
