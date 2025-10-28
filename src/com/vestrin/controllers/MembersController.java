package com.vestrin.controllers;

import com.vestrin.members.Member;
import com.vestrin.storage.FileWriter;
import com.vestrin.storage.MemberRegistry;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

public class MembersController{
    private final FileWriter fileWriter;
    private MemberRegistry memberRegistry;
    private String filePath = "members.dat";

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
     * @return true/false.
     */
    public boolean addNewMember(Member member){
        String ID = member.getID();

        for (Member members : memberRegistry.getMembers()){
            if (memberRegistry.containsMember(ID)) {
                System.out.println("Medlem med detta ID finns redan i registret.");
                return false;
            }
        }
            try {
                memberRegistry.addNew(member);
                fileWriter.writeToFile("members.dat", memberRegistry);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return true;
    }

    /**REMOVES MEMBER FROM REGISTRY
     * @param member Member Object
     */
    public void remove(Member member) {
        memberRegistry.remove(member);
    }

    public void printAll() {
        if (!memberRegistry.getMembers().isEmpty()) {
            memberRegistry.getMembers().forEach(System.out::println);
        }
    }
}
