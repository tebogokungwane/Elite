//package com.player.controller;
//
//import com.player.model.FinancialStatement;
//import com.player.model.Player;
//import com.player.repository.FinancialStatementRepository;
//import com.player.repository.PlayerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//import java.net.URI;
//import java.util.Optional;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//@CrossOrigin(origins = "http://localhost:3000")
//@RestController
//@RequestMapping("/api/v1/finances")
//public class FinancialStatementController {
//
//    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
//    private PlayerRepository playerRepository;
//    private FinancialStatementRepository financialStatementRepository;
//
//    @Autowired
//    public FinancialStatementController(PlayerRepository playerRepository,FinancialStatementRepository financialStatementRepository){
//        this.playerRepository = playerRepository;
//        this.financialStatementRepository = financialStatementRepository;
//    }
//
//    @PostMapping
//    public ResponseEntity<FinancialStatement> create(@RequestBody FinancialStatement financialStatement) {
//        LOGGER.log(Level.INFO,"--->FinancialStatementController.createFinancialRecord()");
//        Optional<Player> optionalPlayer = playerRepository.findById(financialStatement.getPlayer().getId());
//        if(!optionalPlayer.isPresent()){
//            return ResponseEntity.unprocessableEntity().build();
//        }
//
//        financialStatement.setPlayer(optionalPlayer.get());
//        FinancialStatement saveFinancialStatement = financialStatementRepository.save(financialStatement);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//                .buildAndExpand(saveFinancialStatement.getId()).toUri();
//        return ResponseEntity.created(location).body(saveFinancialStatement);
//    }
//
//    @GetMapping
//    public ResponseEntity<Page<FinancialStatement>> getAll(Pageable pageable){
//        return ResponseEntity.ok(financialStatementRepository.findAll(pageable));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<FinancialStatement> getById(@PathVariable Integer id){
//        Optional<FinancialStatement> optionalFinancialStatement = financialStatementRepository.findById(id);
//        if(!optionalFinancialStatement.isPresent()){
//            return ResponseEntity.unprocessableEntity().build();
//        }
//        return ResponseEntity.ok(optionalFinancialStatement.get());
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<FinancialStatement> update(@RequestBody @Validated FinancialStatement financialStatement, @PathVariable Integer id){
//        Optional<Player> optionalPlayer = playerRepository.findById(financialStatement.getPlayer().getId());
//        if(!optionalPlayer.isPresent()){
//            return ResponseEntity.unprocessableEntity().build();
//        }
//        Optional<FinancialStatement> optionalFinancialStatement = financialStatementRepository.findById(id);
//        if(!optionalFinancialStatement.isPresent()){
//            return ResponseEntity.unprocessableEntity().build();
//        }
//
//        financialStatement.setPlayer(optionalPlayer.get());
//        financialStatement.setId(optionalFinancialStatement.get().getId());
//        financialStatementRepository.save(financialStatement);
//        return ResponseEntity.noContent().build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<FinancialStatement> delete(@PathVariable Integer id){
//        Optional<FinancialStatement> optionalFinancialStatement = financialStatementRepository.findById(id);
//        if(!optionalFinancialStatement.isPresent()){
//            return ResponseEntity.unprocessableEntity().build();
//        }
//        financialStatementRepository.delete(optionalFinancialStatement.get());
//        return  ResponseEntity.noContent().build();
//    }
//
//}
