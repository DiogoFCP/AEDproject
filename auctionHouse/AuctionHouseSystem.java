package auctionHouse;

import dataStructures.DoubleList;
import dataStructures.List;

public class AuctionHouseSystem implements AuctionHouse{

    private List<User> userList;

    public AuctionHouseSystem(){
        userList = new DoubleList<>();
    }

    private boolean hasUser(User user){
        return userList.find(user) != -1;
    }

    public void addUser(String login, String name, int age, String email) throws InvalidAgeException, UserAlreadyExistsException {
        if(age < 18)
            throw new InvalidAgeException();
        User user = new UserClass(login, name, age, email);
        if(this.hasUser(user))
            throw new UserAlreadyExistsException();
        userList.addLast(user);
    }


}
