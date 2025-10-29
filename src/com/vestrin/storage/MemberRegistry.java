package com.vestrin.storage;

import com.vestrin.members.Member;

import java.io.Serializable;
import java.sql.SQLOutput;
import java.util.*;

public class MemberRegistry implements Serializable {

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
    public boolean containsMember(String ID){
        if (ID == null){
            return false;
        }
        return this.members.containsKey(ID);
    }

}
