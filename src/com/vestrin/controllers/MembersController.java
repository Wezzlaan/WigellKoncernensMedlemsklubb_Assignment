package com.vestrin.controllers;

import com.vestrin.entities.Item;
import com.vestrin.members.Member;
import com.vestrin.members.MemberHistory;
import com.vestrin.members.Ranks;
import com.vestrin.storage.MemberRegistry;

import java.util.*;

public class MembersController{
    private final MemberRegistry memberRegistry;

    public MembersController() {
        this.memberRegistry = new MemberRegistry();
    }

    /**ADDS NEW MEMBER TO REGISTRY
     * @param member member object
     */
    private void addNewMember(Member member) {
        memberRegistry.addNew(member);
    }
    /**REMOVES MEMBER FROM REGISTRY
     * @param member Member Object
     */
    public void remove(Member member) {
        memberRegistry.remove(member);
    }


    public MemberRegistry getRegistry(){
        return this.memberRegistry;
    }

    /**Handles choices for different ranks for Member. Switch/Case returns chosen Rank.
     * @param choice
     * @return Chosen rank.
     */
    public Ranks chooseRank(char choice){
        return switch (choice) {
            case '1' -> Ranks.NOOB;
            case '2' -> Ranks.CASUAL;
            case '3' -> Ranks.VETERAN;
            case '4' -> Ranks.ELITE;
            default -> throw new InputMismatchException("Ogiltigt val för rank. Välj 1-4.");
        };
    }

    /**
     * Creates, adds and returns a new member to MemberRegistry.
     * @param name Full name of new member.
     * @param choice For the switch to set rank.
     * @return created member object.
     */
    public Member createNewMember(String name, char choice){
        Ranks rank = chooseRank(choice);
        Member member = new Member(name, rank);
        addNewMember(member);
        return member;
    }

    /**Throws NoSuchElementException if member was not found.
     * @param identifier Identifier of member to get. Can be ID number OR name.
     * @return found member.
     */
    public Member getSingleMember(String identifier){
        String identifierToUpper = identifier.toUpperCase().trim();
        if (memberRegistry.containsMemberID(identifierToUpper)){
            return memberRegistry.getMembers().get(identifierToUpper);
        }
        if (!memberRegistry.containsMemberID(identifierToUpper)){
            Member memberByName = memberRegistry.containsMemberName(identifierToUpper);
            if (memberByName != null){
                return memberByName;
            }
        }
        throw new NoSuchElementException("Kunde inte hitta medlem med ID eller namn: " + identifier);
    }

    public void addRankChangeToHistory(Member member, String oldRank, String newRank){
        try {
            MemberHistory memberHistory = member.getMemberHistory();
            memberHistory.addRankChange(oldRank, newRank);
        } catch (NullPointerException e){
            System.err.println(e.getMessage());
        }
    }


}
