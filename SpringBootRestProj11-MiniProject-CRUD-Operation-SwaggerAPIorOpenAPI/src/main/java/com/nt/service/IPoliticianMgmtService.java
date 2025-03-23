package com.nt.service;

import java.util.List;

import com.nt.entity.Politician;

public interface IPoliticianMgmtService 
{
    public String registerPolitician(Politician politician) throws Exception;
    public List<Politician>getAllPolitician();
    public Politician getPoliticianById(int pid);
    public List<Politician> getPoliticianInfo(String party1, String party2, String party3);
    public String modifyPoliticianDetails(Politician politician);
    public String partyChange(int pid,String newParty);
    public String deletePoliticianById(int pid);
}
