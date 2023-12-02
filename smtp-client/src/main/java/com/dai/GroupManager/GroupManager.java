package com.dai.GroupManager;

import com.dai.config.Address;
import com.sun.jdi.ArrayReference;

import java.util.ArrayList;

public class GroupManager {

    ArrayList<String> addresses;

    ArrayList<ArrayList<String>> groups;

    int nbGroup;

    int nbPersonPerGroup;

    public GroupManager(ArrayList<String> addresses, int nbGroupe){
        this.addresses = addresses;
        this.nbGroup = nbGroupe;
        this.groups = new ArrayList<>();
        this.nbPersonPerGroup = addresses.size() / nbGroupe;
        for(int i = 0; i < nbGroup; i++){
            ArrayList<String> group = new ArrayList<>();
            for(int j = nbPersonPerGroup * i; j < nbPersonPerGroup * (i + 1); j++){
                group.add(addresses.get(j));
            }
            groups.add(group);
        }
    }

    public String getSender(int index){
        ArrayList<String> group = groups.get(index);
        return  group.get(0);
    }

    public ArrayList<String> getReceiver(int index){
        ArrayList<String> group = groups.get(index);
        group.remove(0);
        return group;
    }

    public void toPrint() {
        int index = 0;
        for(var group : groups){
            System.out.println("Address of group : " + index);
            for(var address: group){
                System.out.println(address);
            }
            index++;
        }
    }
}

