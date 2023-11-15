package com.shivansh;

import java.util.ArrayList;
import java.util.LinkedList;

public class album {
	@SuppressWarnings("unused")
	private String name;
	@SuppressWarnings("unused")
	private String artist;
	private ArrayList<song>songs;

	
	public album(String name, String artist) {
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<song>();
	}
	public album() {
		
	}
	public song findsong(String title) {
		for(song checkedSong: songs) {
			if (checkedSong.getTitle().equals(title)) return checkedSong;
				
			}
		return null;
	}
	public boolean addsong(String title,Double duration) {
		if (findsong(title)==null) {
			songs.add(new song(title,duration));
			System.out.println(title+"successfully added to list");
			return true;
			
		}
		else {
			System.out.println("song with name"+title+"already exist in the list");
			return false;
		}
		
	}
	public boolean addtoplaylist(int tracknumber,LinkedList<song>playList) {
		int index= tracknumber-1;
		if(index>0 && index<=this.songs.size()) {
			playList.add(this.songs.get(index));
			return true;
		}
		System.out.println("this album does not have song with tracknumber"+tracknumber);
		return false;
	}
	public boolean addtoplaylist(String title,LinkedList<song>playList) {
		for(song checkedSong : this.songs) {
			if(checkedSong.getTitle().equals(title)) {
				playList.add(checkedSong);
				return true;
			}
		}
		System.out.println(title+"there is no such song in the album");
		return false;
	}
}




