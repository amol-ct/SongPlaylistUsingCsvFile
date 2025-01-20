package com.playlist.SongPlaylist;

import java.lang.String;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SongPlaylistApplication {

	public static void main(String[] args) {

		ApplicationContext IOC_container= SpringApplication.run(SongPlaylistApplication.class, args);
		PlaylistCreator creator=IOC_container.getBean(PlaylistCreator.class);
		String filePath="src/main/java/com/playlist/SongPlaylist/songs.csv";

		List<Song> playlist=creator.createPlaylist(filePath);

		System.out.println("Playlist: ");
		for(Song s:playlist){
			System.out.println(s);
		}

		creator.fetchPlaylist("src/main/java/com/playlist/SongPlaylist/new_songs.csv",playlist);
		System.out.println("write operation done!");
	}

}
