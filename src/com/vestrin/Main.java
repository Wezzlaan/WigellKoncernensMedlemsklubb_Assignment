package com.vestrin;

import com.vestrin.members.Member;
import com.vestrin.members.Ranks;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Member member = new Member("Test Tester", "144325");

        member.setRank(Ranks.NOOB);

        System.out.println("Namn: " + member.getName() + "\nID: " + member.getID() + "\nRank: " + member.getRank());

    }
}