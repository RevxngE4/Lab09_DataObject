package org.example;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.time.LocalDate;
import java.util.List;
@JsonAutoDetect
public class ActorAndFriends extends Actor{
    private List<String> friends;
    public ActorAndFriends(){
        super();
        this.setFriends(getFriends());
    }
    public ActorAndFriends(String name, String address, LocalDate birthday, boolean crime, int prisoners, List<String> friends){
        super(name, address, birthday, crime, prisoners);
        this.friends = friends;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "ActorAndFriends{" +
                "\nfriends=" + friends +
                '}';
    }
}
