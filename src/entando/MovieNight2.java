package entando;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MovieNight2 {
    public Boolean canViewAll(Collection<Movie> movies) {
        List<Movie> moviesPass = new ArrayList<>();
        for(Movie movie:movies){
            boolean check = false;

            if(moviesPass.isEmpty())
                check = true;
            else
                check = moviesPass.stream().filter(m -> checkMovie(movie,m))
                        .count() == 0;

            if(check)
                moviesPass.add(movie);
            else
                return false;
        }
        return true;
    }

    private boolean checkMovie(Movie newMovie,Movie oldMovie){
        LocalDateTime movieStart = fromDate(newMovie.getStart());
        LocalDateTime movieEnd = fromDate(newMovie.getEnd());
        LocalDateTime start = fromDate(oldMovie.getStart());
        LocalDateTime end = fromDate(oldMovie.getEnd());

        boolean check =(movieStart.isAfter(end) || movieStart.equals(end)) ||
                       (movieStart.isBefore(end) && movieEnd.isBefore(start)) ||
                       (movieEnd.isAfter(end) && movieStart.isAfter(end))  ||
                       (movieStart.isBefore(start) && (movieEnd.isBefore(start) || movieEnd.equals(start)) )
                ;

        return !check;
    }

    private LocalDateTime fromDate(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    @Test
    public void testOK() throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m");

        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie(sdf.parse("2015-01-01 20:00"), sdf.parse("2015-01-01 21:30")));
        movies.add(new Movie(sdf.parse("2015-01-01 23:10"), sdf.parse("2015-01-01 23:30")));
        movies.add(new Movie(sdf.parse("2015-01-01 21:30"), sdf.parse("2015-01-01 23:00")));

        assertTrue(canViewAll(movies));

    }

    @Test
    public void testInternal() throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m");

        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie(sdf.parse("2015-01-01 20:00"), sdf.parse("2015-01-01 21:30")));
        movies.add(new Movie(sdf.parse("2015-01-01 21:30"), sdf.parse("2015-01-01 23:00")));
        movies.add(new Movie(sdf.parse("2015-01-01 23:10"), sdf.parse("2015-01-01 23:30")));

        movies.add(new Movie(sdf.parse("2015-01-01 23:01"), sdf.parse("2015-01-01 23:05")));

        assertTrue(canViewAll(movies));
    }

    @Test
    public void testInternalBorder() throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m");

        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie(sdf.parse("2015-01-01 20:00"), sdf.parse("2015-01-01 21:30")));
        movies.add(new Movie(sdf.parse("2015-01-01 21:30"), sdf.parse("2015-01-01 23:00")));
        movies.add(new Movie(sdf.parse("2015-01-01 23:10"), sdf.parse("2015-01-01 23:30")));

        movies.add(new Movie(sdf.parse("2015-01-01 23:00"), sdf.parse("2015-01-01 23:10")));

        assertTrue(canViewAll(movies));
    }

    @Test
    public void test4_invalid_overLap() throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m");

        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie(sdf.parse("2015-01-01 20:00"), sdf.parse("2015-01-01 21:30")));
        movies.add(new Movie(sdf.parse("2015-01-01 21:30"), sdf.parse("2015-01-01 23:00")));
        movies.add(new Movie(sdf.parse("2015-01-01 23:10"), sdf.parse("2015-01-01 23:30")));


        movies.add(new Movie(sdf.parse("2015-01-01 23:01"), sdf.parse("2015-01-01 23:40")));

        assertFalse(canViewAll(movies));

    }

    @Test
    public void test5_invalid_overlap_end() throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m");

        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie(sdf.parse("2015-01-01 20:00"), sdf.parse("2015-01-01 21:30")));
        movies.add(new Movie(sdf.parse("2015-01-01 21:30"), sdf.parse("2015-01-01 23:00")));
        movies.add(new Movie(sdf.parse("2015-01-01 23:10"), sdf.parse("2015-01-01 23:30")));

        movies.add(new Movie(sdf.parse("2015-01-01 23:01"), sdf.parse("2015-01-01 23:20")));

        assertFalse(canViewAll(movies));

    }

    @Test
    public void test6_invalid_overlap_start() throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m");

        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie(sdf.parse("2015-01-01 20:00"), sdf.parse("2015-01-01 21:30")));
        movies.add(new Movie(sdf.parse("2015-01-01 21:30"), sdf.parse("2015-01-01 23:00")));
        movies.add(new Movie(sdf.parse("2015-01-01 23:10"), sdf.parse("2015-01-01 23:30")));

        movies.add(new Movie(sdf.parse("2015-01-01 23:20"), sdf.parse("2015-01-01 23:40")));

        assertFalse(canViewAll(movies));

    }

    @Test
    public void test6_invalid_overlap_inner() throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m");

        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie(sdf.parse("2015-01-01 20:00"), sdf.parse("2015-01-01 21:30")));
        movies.add(new Movie(sdf.parse("2015-01-01 21:30"), sdf.parse("2015-01-01 23:00")));
        movies.add(new Movie(sdf.parse("2015-01-01 23:10"), sdf.parse("2015-01-01 23:30")));

        movies.add(new Movie(sdf.parse("2015-01-01 23:15"), sdf.parse("2015-01-01 23:25")));

        assertFalse(canViewAll(movies));

    }


}

class Movie2 {
    private Date start, end;

    public Movie2(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return this.start;
    }

    public Date getEnd() {
        return this.end;
    }
}