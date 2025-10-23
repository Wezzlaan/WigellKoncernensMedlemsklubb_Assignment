package com.vestrin.members;

public class Member {

    private String ID; //TO DO: generera random ID vid skapning av member.
    private String name;
    private Ranks rank;
    private MemberHistory memberHistory;

    public Member() {}

    /**
     * @param name of Member
     * @param ID belonging to Member
     */
    public Member(String name, String ID)
    {
        this.name = name;
        this.ID = ID;
    }

    /**
     * @return Member ID
     */
    public String getID()
    {
        return ID;
    }

    /**
     * @return Member name
     */
    public String getName()
    {
        return name;
    }

    /**
     *
     * @param newName Sets new name to member object
     */
    public void setName(String newName)
    {
        this.name = newName;
    }

    /**
     * @return Member rank
     */
    public Ranks getRank()
    {
        return rank;
    }

    /**
     * @param newRank Sets new rank to member
     */
    public void setRank(Ranks newRank)
    {
        this.rank = newRank;
    }

    public MemberHistory getMemberHistory()
    {
        return memberHistory;
    }
}
