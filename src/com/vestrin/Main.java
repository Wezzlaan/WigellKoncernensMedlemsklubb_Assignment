package com.vestrin;

import com.vestrin.items.Monitor;
import com.vestrin.members.Member;
import com.vestrin.members.Ranks;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Member member = new Member("Test Tester", "144325");

        member.setRank(Ranks.NOOB);

        System.out.println("Namn: " + member.getName() + "\nID: " + member.getID() + "\nRank: " + member.getRank());

        Monitor monitor = new Monitor ("Q27G3XMN", "AOC", 149.0, "453153");

        System.out.println(monitor.formattedName() + " " + monitor.getItemID() + " " + monitor.getPrice() + " " + monitor.getItemType());
    }
}