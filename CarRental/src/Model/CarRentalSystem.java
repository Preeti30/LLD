package Model;

import java.util.List;

public class CarRentalSystem {

    List<User> userList;

    public CarRentalSystem(List<User> userList, List<Store> storeList) {
        System.out.println("creating new car rental system");
        this.userList = userList;
        this.storeList = storeList;
    }

    List<Store> storeList;

    public Store getStore(Location location)
    {
        for(int i=0;i<storeList.size();i++)
        {
            if(storeList.get(i).location.city == location.city)
            {
                return storeList.get(i);
            }
        }
        return null;
    }


}
