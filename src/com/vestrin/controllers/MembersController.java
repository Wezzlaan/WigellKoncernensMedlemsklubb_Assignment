package com.vestrin.controllers;

import com.vestrin.members.Member;
import com.vestrin.members.Ranks;
import com.vestrin.storage.FileWriter;
import com.vestrin.storage.MemberRegistry;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class MembersController{
    private final FileWriter fileWriter;
    private MemberRegistry memberRegistry;
    private String filePath = "members.dat";


    /**
     * CONSTRUCTOR LOADS MEMBER REGISTRY FROM 'members.dat' FILE, IF AVAILALBE. WILL CREATE NEW FILE IF NOT.
     */
    public MembersController() {
        this.fileWriter = new FileWriter();

        try {
            this.memberRegistry = fileWriter.loadMemberRegistry(filePath);
            System.out.println("Befintlig medlemslista laddad.");
        } catch (FileNotFoundException e) {
            this.memberRegistry = new MemberRegistry();
            System.out.println("Ingen medlemslista hittades. Skapar en ny...");
        } catch (IOException e){
            e.printStackTrace();
            this.memberRegistry = new MemberRegistry();
        }
    }

    /**ADDS NEW MEMBER TO REGISTRY
     * @param member member object
     */
    private void addNewMember(Member member){
        try {
            memberRegistry.addNew(member);
            fileWriter.writeToFile("members.dat", memberRegistry);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**REMOVES MEMBER FROM REGISTRY
     * @param member Member Object
     */
    public void remove(Member member) {
        memberRegistry.remove(member);
    }

    /*public void printAll() {
        if (!memberRegistry.getMembers().isEmpty()) {
            memberRegistry.getMembers().forEach(System.out::println);
        }
    }*/

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

}
