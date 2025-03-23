package com.nt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nt.entity.Politician;
import com.nt.service.IPoliticianMgmtService;

@RestController
@RequestMapping("/politician-api")
public class PoliticalPartyOperationController {

    @Autowired
    private IPoliticianMgmtService politicianService;

    @PostMapping("/save")
    public ResponseEntity<String> registerPolitician(@RequestBody Politician politician) throws Exception {
        String msg = politicianService.registerPolitician(politician);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Politician>> fetchAllPoliticians() {
        List<Politician> list = politicianService.getAllPolitician();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Politician> showPoliticianById(@PathVariable("id") int pid) {
        Politician politician = politicianService.getPoliticianById(pid);
        return new ResponseEntity<>(politician, HttpStatus.OK);
    }

    @GetMapping("/findAll/{party1}/{party2}/{party3}")
    public ResponseEntity<List<Politician>> showPoliticianByParties(
            @PathVariable String party1,
            @PathVariable String party2,
            @PathVariable String party3) throws Exception {

        List<Politician> list = politicianService.getPoliticianInfo(party1, party2, party3);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PutMapping("/modify")
    public ResponseEntity<String> updatePoliticianFullDetails(@RequestBody Politician politician) {
        String msg = politicianService.modifyPoliticianDetails(politician);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PatchMapping("/modify/{pid}/{party}")
    public ResponseEntity<String> updatePoliticianByParty(@PathVariable int pid, @PathVariable String party) {
        String msg = politicianService.partyChange(pid, party);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{pid}")
    public ResponseEntity<String> removePoliticianById(@PathVariable int pid) {
        String msg = politicianService.deletePoliticianById(pid);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
