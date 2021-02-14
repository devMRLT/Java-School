//Author: Nathaniel Armogan
//description: This program allows the usr to dictate a collection of songs
public class Song{
	//variables
	private String artist, title;
	public static String collectionName;
	private int duration;
	//param constructor
	public Song(String artist, String title, int duration){
		setArtist(artist);
		setTitle(title);
		setDuration(duration);
	}
	//setters
	private void setArtist(String artist){this.artist = artist;};
	private void setTitle(String title){this.title = title;};
	private void setDuration(int duration){this.duration = duration;};
	//getters
	private String getArtist(){return artist;};
	private String getTitle(){return title;};
	private int getDuration(){return duration;};
	//print function
	public static void printSong(Song song){
		int min = song.getDuration() / 60;
		int sec = song.getDuration() % 60;
		System.out.printf("%s (%s) - %d:%d\n", song.getTitle(), song.getArtist(), min, sec);
	}
	//main function
	public static void main(String[] args) {
		Song sed = new Song("The Ramones", "I Wanna be Sedated", 148);
		Song one = new Song("Daft Punk", "OneMoreTime", 322);

		sed.collectionName = "Randy's Collection";
		System.out.println("Collection: " + one.collectionName);
		printSong(sed);
		printSong(one);
	}
}