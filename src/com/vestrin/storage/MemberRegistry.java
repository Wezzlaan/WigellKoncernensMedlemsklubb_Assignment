package com.vestrin.storage;

import com.vestrin.members.Member;

import java.util.*;

public class MemberRegistry {

    private List<Member> members;

    public MemberRegistry()
    {
        this.members = new ArrayList<>();
    }

    /**
     * @param newMember Specify new member to be stored in Member Registry.
     */
    public void addNew(Member newMember)
    {
        if (newMember != null){
            members.add(newMember);
        }
        else{
            throw new IllegalArgumentException("FEL: Kunde inte lägga till användare. Orsak: Användare var 'Null'");
        }
    }
    /**
     * @return Unmodifiable version of Member List.
     */
    public List<Member> getMembers()
    {
        return Collections.unmodifiableList(this.members);
    }

    /**
     * @param member Member to remove from List.
     */
    public void remove(Member member)
    {
        if (members.isEmpty())
        {
            throw new NoSuchElementException("FEL: Kunde inte ta bort medlem ur listan. Orsak: 'MemberRegistry' är tomt.");
        }
        this.members.remove(member);
    }
}
