package base;

public class Movie {
    private int id;
    private String name;
    private double price;
    private double score;
    private String director;
    private String actor;
    private String info;

    public Movie(int id, String name, double price, double score, String director, String actor, String info) {

    }
    public Movie(){

    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setName(String name) {

    }
    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }

    public void setScore(double score) {
        this.score = score;
    }
    public double getScore() {
        return score;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    public String getDirector() {
        return director;
    }
    public void setActor(String actor) {
        this.actor = actor;
    }
    public String getActor() {
        return actor;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public String getInfo() {
        return info;
    }

}
