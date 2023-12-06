package com.dai.GroupManager;

import com.dai.config.Address;
import com.sun.jdi.ArrayReference;

import java.util.ArrayList;

public class GroupManager {

    /**
     * List who contains all address
     */
    ArrayList<String> addresses;

    /**
     * Array of all groups together
     */
    ArrayList<ArrayList<String>> groups;

    /**
     * Number of group
     */
    int nbGroup;

    /**
     * Number of person in group
     */
    int nbPersonPerGroup;

    /**
     * Class who will split all the address into different group and separate for each group the sender and the
     * receiveer
     * @param addresses all the address to split
     * @param nbGroupe the number of group
     */
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

    /**
     * Method that give us the sender of the group of the given index
     * @param index index of group
     * @return address of the sender
     */
    public String getSender(int index){
        ArrayList<String> group = groups.get(index);
        return  group.get(0);
    }

    /**
     * Method who will give us all the receiver for a given group
     * @param index index of the group
     * @return an array list of all the adddress of the receiver
     */
    public ArrayList<String> getReceiver(int index){
        ArrayList<String> group = groups.get(index);
        group.remove(0);
        return group;
    }

    /**
     * Method to print all different group. Is used for debug purpose
     */
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

