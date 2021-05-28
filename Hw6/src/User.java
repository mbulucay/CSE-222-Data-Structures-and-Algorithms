import java.util.Scanner;

public abstract class User implements Comparable<User>,UserInterface{

    private Integer id; 
    private String password;
    private String name;

    public User(String name,Integer id,String password){
        this.name = name;
        setId(id);
        setPassword(password);
    }

    private void setId(Integer id2) {
        Scanner scan = new Scanner(System.in);
        while(DataBase.containsCustomer(id2)){
            System.out.println("This is already taken enter a different id");
            id2 = Integer.parseInt(scan.nextLine());
        }
        id = id2;        
    }

    public Integer getId(){return id;}

    public String getPassword(){return password;}

    public void setPassword(String password){
        if(password.length() != 6){
            System.out.println("password must be 6 character");
            System.out.println("your password assign automatically \"asdfgh\"");
            password = "asdfgh";
        }

        this.password = password;
    }

    public String getName(){return name;}


    @Override
    public boolean equals(Object o){

        if(o instanceof User == false)  return false;

        User other = (User) o;
        if( !(this.getId().equals(other.getId())) ) return false;

        return true;
    }

    @Override
    public int hashCode(){
                
        return id;
    }

    @Override
    public int compareTo(User o) {
        return this.getId() - o.getId();
    }

}
