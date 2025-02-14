public class Person {

    private String name;
    private String city;

    public Person(String name, String city){
        this.name = name;
        this.city = city;
    }

    public String getCity(){
        return this.city;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
