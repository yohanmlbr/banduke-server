package iot.polytech.bandukeserver.entity.compositepk;


import iot.polytech.bandukeserver.entity.User;

import java.io.Serializable;
import java.util.Objects;

public class FriendshipPK implements Serializable {

    private User idfollower;

    private User idfollowed;


    public FriendshipPK(User idfollower, User idfollowed) {
        this.idfollower = idfollower;
        this.idfollowed = idfollowed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FriendshipPK that = (FriendshipPK) o;
        return (idfollower.getId() == that.idfollower.getId()) &&
               (idfollowed.getId() == that.idfollowed.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(idfollower.getId(), idfollowed.getId());
    }

}
