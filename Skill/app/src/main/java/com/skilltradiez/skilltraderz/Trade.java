package com.skilltradiez.skilltraderz;

/*
 *    Team15Alpha
 *    AppName: SkillTradiez (Subject to change)
 *    Copyright (C) 2015  Stephen Andersen, Falon Scheers, Elyse Hill, Noah Weninger, Cole Evans
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
import java.util.List;

/**
 * Created by sja2 on 10/28/15.
 */
public class Trade implements Notification {
    private User actor1, actor2;
    private List<Skill> offer1, offer2;
    private Boolean accepted = false, active = true;

    Trade(User user1, User user2) {
        actor1 = user1;
        actor2 = user2;
    }

    public User getActor1() {
        return actor2;
    }

    public User getActor2() {
        return actor2;
    }

    public void setAccepted(User other) throws InactiveTradeException {
        if ((other.equals(actor1) || other.equals(actor2)) && active)
            accepted = true;
            // Give The Goods
            // ~ Trade Initiated
        else {
            throw new InactiveTradeException();
        }
    }

    public Boolean isAccepted() {
        return accepted;
    }

    public Boolean isActive() {
        return active;
    }

    public void decline() {
        active = false;
        accepted = false;

        // The Trade been declined
    }

    public void setCounterOffer(User user, List<Skill> new_offer) {
        // Find this user
        // change their offer
    }

    public List<Skill> getCurrentOffer(User user) {
        return null;
    }

    public void commit(UserDatabase userDB) {
        //TODO
    }
}
