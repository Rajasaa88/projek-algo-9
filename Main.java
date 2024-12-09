public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();

        // Menampilkan playlist kosong
        System.out.println("Playlist Kosong:");
        playlist.displayPlaylist();

        // Menambahkan lagu ke playlist
        playlist.addSong("Billy Joel - Piano Man", "Billy Joel", 1973, 5, 39, "Folk");
        playlist.addSong("Bruno Mars - Die With A Smile", "Bruno Mars", 2024, 4, 11, "Pop");
        playlist.addSong("Feast - Nina", ".Feast", 2024, 4, 37, "Indonesian Rock");
        playlist.addSong("Wave to Earth - Bad", "Wave to Earth", 2023, 4, 23, "Korean Rock, Thai Indie");
        playlist.addSong("Why Don't We - 8 Letters", "Why Don't We", 2018, 3, 10, "Pop");
        playlist.addSong("The Smiths - There Is a Light", "The Smiths", 1986, 4, 4, "Indie");
        playlist.addSong("Pamungkas - To the Bone", "Pamungkas", 2020, 5, 44, "Indonesian Indie");
        playlist.addSong("One Ok Rock - We are", "One Ok Rock", 2017, 4, 15, "Pop Rock");
        playlist.addSong("Lee Young Ji - Small girl", "Lee Young Ji", 2024, 3, 49, "R&B");
        playlist.addSong("Green Day - 21 Guns", "Green Day", 2009, 5, 21, "Punk Pop");

        playlist.addSong("Sam Smith - Too Good at Goodbyes", "Sam Smith", 2017, 3, 21, "Pop");
        playlist.addSong("Adele - Someone Like You", "Adele", 2011, 4, 45, "Pop");
        playlist.addSong("Ariana Grande - Almost Is Never Enough", "Ariana Grande", 2013, 5, 28, "Pop");
        playlist.addSong("Taylor Swift - All Too Well", "Taylor Swift", 2012, 5, 29, "Pop");
        playlist.addSong("Ed Sheeran - Photograph", "Ed Sheeran", 2014, 4, 19, "Pop");
        playlist.addSong("Sam Smith - I'm Not the Only One", "Sam Smith", 2014, 3, 59, "Soul");
        playlist.addSong("Ariana Grande - My Everything", "Ariana Grande", 2014, 2, 48, "Pop");
        playlist.addSong("Taylor Swift - White Horse", "Taylor Swift", 2008, 3, 55, "Country Pop");
        playlist.addSong("Ed Sheeran - Give Me Love", "Ed Sheeran", 2011, 8, 46, "Pop");
        playlist.addSong("Adele - Hello", "Adele", 2015, 4, 55, "Soul");
        playlist.addSong("Sam Smith - Lay Me Down", "Sam Smith", 2014, 4, 13, "Soul");
        playlist.addSong("Ariana Grande - Ghostin", "Ariana Grande", 2019, 4, 31, "Pop");
        playlist.addSong("Taylor Swift - Back to December", "Taylor Swift", 2010, 4, 55, "Pop");
        playlist.addSong("Ed Sheeran - Happier", "Ed Sheeran", 2017, 3, 27, "Pop");
        playlist.addSong("Adele - When We Were Young", "Adele", 2015, 4, 51, "Soul");
        playlist.addSong("Sam Smith - Burning", "Sam Smith", 2017, 3, 23, "Pop");
        playlist.addSong("Ariana Grande - Better Off", "Ariana Grande", 2018, 2, 52, "Pop");
        playlist.addSong("Taylor Swift - Dear John", "Taylor Swift", 2010, 6, 43, "Country Pop");
        playlist.addSong("Ed Sheeran - I See Fire", "Ed Sheeran", 2013, 5, 2, "Folk Pop");
        playlist.addSong("Adele - Remedy", "Adele", 2015, 4, 5, "Soul");
        playlist.addSong("Sam Smith - Dancing With a Stranger", "Sam Smith", 2019, 2, 51, "Pop");
        playlist.addSong("Ariana Grande - Thank U, Next", "Ariana Grande", 2019, 3, 27, "Pop");
        playlist.addSong("Taylor Swift - Teardrops on My Guitar", "Taylor Swift", 2007, 3, 35, "Country");
        playlist.addSong("Ed Sheeran - The A Team", "Ed Sheeran", 2011, 4, 18, "Pop");
        playlist.addSong("Adele - Make You Feel My Love", "Adele", 2008, 3, 32, "Soul");
        playlist.addSong("Sam Smith - Writing's on the Wall", "Sam Smith", 2015, 4, 38, "Soul");
        playlist.addSong("Ariana Grande - One Last Time", "Ariana Grande", 2014, 3, 17, "Pop");
        playlist.addSong("Taylor Swift - Sad Beautiful Tragic", "Taylor Swift", 2012, 4, 44, "Country");
        playlist.addSong("Ed Sheeran - Perfect", "Ed Sheeran", 2017, 4, 23, "Pop");
        playlist.addSong("Adele - Set Fire to the Rain", "Adele", 2011, 4, 2, "Pop");
        playlist.addSong("Sam Smith - How Do You Sleep?", "Sam Smith", 2019, 3, 22, "Pop");
        playlist.addSong("Ariana Grande - Breathin", "Ariana Grande", 2018, 3, 18, "Pop");
        playlist.addSong("Taylor Swift - Begin Again", "Taylor Swift", 2012, 3, 58, "Country Pop");
        playlist.addSong("Ed Sheeran - Thinking Out Loud", "Ed Sheeran", 2014, 4, 41, "Pop");
        playlist.addSong("Adele - Send My Love (To Your New Lover)", "Adele", 2015, 3, 43, "Pop");
        playlist.addSong("Sam Smith - Stay With Me", "Sam Smith", 2014, 2, 52, "Soul");
        playlist.addSong("Ariana Grande - No Tears Left to Cry", "Ariana Grande", 2018, 3, 26, "Pop");
        playlist.addSong("Taylor Swift - You Belong with Me", "Taylor Swift", 2008, 3, 52, "Country Pop");
        playlist.addSong("Ed Sheeran - Castle on the Hill", "Ed Sheeran", 2017, 4, 21, "Pop");
        playlist.addSong("Adele - All I Ask", "Adele", 2015, 4, 31, "Pop");
        playlist.addSong("Tulus - Tergila-gila", "Tulus", 2023, 3, 57, "Indonesian Pop");
        playlist.addSong("Tulus - Nala", "Tulus", 2023, 4, 12, "Indonesian Pop");
        playlist.addSong("Tulus - Labirin", "Tulus", 2023, 4, 9, "Indonesian Pop");
        playlist.addSong("Tulus - Hati-Hati di Jalan", "Tulus", 2022, 4, 34, "Indonesian Pop");
        playlist.addSong("Tulus - Pamit", "Tulus", 2016, 4, 10, "Indonesian Pop");

        // Menampilkan playlist asli
        System.out.println("Playlist Asli:");
        playlist.displayPlaylist();

        // Mengurutkan berdasarkan durasi
        playlist.sortPlaylistByDuration();
        System.out.println("\nPlaylist Setelah Diurutkan Berdasarkan Durasi:");
        playlist.displayPlaylist();

        // Mengurutkan berdasarkan tahun
        playlist.sortPlaylistByYear();
        System.out.println("\nPlaylist Setelah Diurutkan Berdasarkan Tahun:");
        playlist.displayPlaylist();

        // Pencarian lagu berdasarkan judul
        System.out.println("\nPencarian Lagu Berdasarkan Judul 'Tulus - Tergila-gila':");
        playlist.searchSongByTitle("Tulus - Tergila-gila");
    }
}