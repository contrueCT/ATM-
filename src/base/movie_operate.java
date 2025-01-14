package base;

public class movie_operate {
    private Movie[] movies;
    public movie_operate(Movie[] movies){
        this.movies = movies;
    }

    public void printAllMovies(){

        System.out.println("-----------全部电影信息如下----------");
        for(int i = 0;i< movies.length;i++)
        {
            Movie m = movies[i];
            System.out.println(m.getId());
            System.out.println(m.getName());
            System.out.println(m.getDirector());
            System.out.println(m.getActor());
            System.out.println(m.getScore());
            System.out.println(m.getPrice());
            System.out.println(m.getInfo());

        }
    }
}
