package com.vestrin.storage;

import com.vestrin.members.Member;

import java.io.Serializable;
import java.util.*;

public class MemberRegistry{

    private final HashMap<String, Member> members;

    public MemberRegistry() {
        this.members = new HashMap<>();
    }
    /**
     * @param newMember Specify new member to be stored in Member Registry.
     */
    public void addNew(Member newMember) {
        if (newMember == null){
            throw new IllegalArgumentException("FEL: Kunde inte lägga till användare. Orsak: Användare var 'Null'");
        }
        members.put(newMember.getID(), newMember);
    }

    /**
     * @return Members registry as HashMap with <String, Member>.
     */
    public HashMap<String, Member> getMembers()
    {
        return this.members;
    }

    /**
     * @param member Member to remove from List.
     */
    public void remove(Member member)
    {
        if (member == null){
            System.err.println("FEL: Medlem kan inte vara 'null'.");
            return;
        }
        if (members.isEmpty()){
            throw new NoSuchElementException("FEL: Kunde inte ta bort medlem. Orsak: 'MemberRegistry' är tomt. ");
        }

        this.members.remove(member.getID());
    }

    /**
     * @param ID Of user to find.
     * @return true/false.
     */
    public boolean containsMemberID(String ID){
        if (ID == null){
            return false;
        }
        return this.members.containsKey(ID);
    }

    /**
     * Checks if a list contains a specific member, by searching for their name.
     * @param name full name of member to find.
     * @return member if found, null if nothing is found, or if the name parameter is empty.
     */
    public Member containsMemberName(String name){
        if (name == null){
            return null;
        }
        for (Member member : members.values()){
            if (Objects.equals(name, member.getName())){
                return member;
            }
        }
        return null;
    }

}
