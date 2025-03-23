package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Politician;
import com.nt.repository.IPoliticianRepository;
import com.nt.advice.PoliticianNotFoundException;  // Ensure this extends RuntimeException

@Service
public class PoliticianMgmtServiceImpl implements IPoliticianMgmtService {

    @Autowired
    private IPoliticianRepository politicianRepo;

    @Override
    public String registerPolitician(Politician politician) {
        int idVal = politicianRepo.save(politician).getPid();
        return "Generated ID: " + idVal;
    }

    @Override
    public List<Politician> getAllPolitician() {
        return politicianRepo.findAll();
    }

    @Override
    public Politician getPoliticianById(int pid) {
        return politicianRepo.findById(pid)
                .orElseThrow(() -> new PoliticianNotFoundException("Invalid ID: " + pid));
    }

    @Override
    public List<Politician> getPoliticianInfo(String party1, String party2, String party3) {
        return politicianRepo.findAllPoliticianByParties(party1, party2, party3);
    }

    @Override
    public String modifyPoliticianDetails(Politician politician) {
        Optional<Politician> opt = politicianRepo.findById(politician.getPid());
        if (opt.isPresent()) {
            politicianRepo.save(politician);  // Update existing politician
            return "Politician with ID " + politician.getPid() + " details updated successfully.";
        } else {
            return "Politician with ID " + politician.getPid() + " not found. Update failed.";
        }
    }

    @Override
    public String partyChange(int pid, String newParty) {
        Optional<Politician> opt = politicianRepo.findById(pid);
        if (opt.isPresent()) {
            Politician politician = opt.get();
            politician.setParty(newParty);  // Correctly update the party
            politicianRepo.save(politician);
            return "Politician with ID " + pid + " party changed to " + newParty + ".";
        } else {
            return "Politician with ID " + pid + " not found. Party change failed.";
        }
    }

    @Override
    public String deletePoliticianById(int pid) {
        Optional<Politician> opt = politicianRepo.findById(pid);
        if (opt.isPresent()) {
            politicianRepo.deleteById(pid);
            return "Politician with ID " + pid + " deleted successfully.";
        } else {
            return "Politician with ID " + pid + " not found. Deletion failed.";
        }
    }
}
