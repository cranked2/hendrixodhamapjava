package movies;

public class MovieDB {
    private Movie[] myMovies; //declaring nulls and no size
    private int movieIndex;

    public MovieDB(int n) {
        myMovies = new Movie[n];
        movieIndex = 0;
    }

    public void addMovie(Movie m) {
        if (movieIndex < myMovies.length) {
            myMovies[movieIndex] = m;
            movieIndex++;
        } else {
            System.out.println("MovieDB is full.");
        }
    }

    public Movie findMovie(String title) {
        for (int i = 0; i < movieIndex; i++) {
            if (myMovies[i].getTitle().equals(title)) {
                return myMovies[i];
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Movie List:\n");
        for (int k = 0; k < movieIndex; k++) {
            sb.append(myMovies[k].toString()).append("\n");
        }
        return sb.toString();
    }

    public String toStringFile() {
        StringBuilder sb = new StringBuilder();
        sb.append(movieIndex).append("\n");
        for (int k = 0; k < movieIndex; k++) {
            sb.append(myMovies[k].toStringFile());
        }
        return sb.toString();
    }
}
