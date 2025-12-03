package com.tasksaas.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:3001" })
public class AutomationRuleController {

    @Autowired
    private AutomationRuleRepository ruleRepository;

    @GetMapping
    public List<AutomationRule> getAllRules() {
        return ruleRepository.findAll();
    }

    @PostMapping
    public AutomationRule createRule(@RequestBody AutomationRule rule) {
        return ruleRepository.save(rule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutomationRule> updateRule(@PathVariable String id, @RequestBody AutomationRule ruleDetails) {
        return ruleRepository.findById(id)
                .map(rule -> {
                    rule.setName(ruleDetails.getName());
                    rule.setTriggerType(ruleDetails.getTriggerType());
                    rule.setTriggerValue(ruleDetails.getTriggerValue());
                    rule.setActionType(ruleDetails.getActionType());
                    rule.setActionValue(ruleDetails.getActionValue());
                    rule.setActive(ruleDetails.isActive());
                    return ResponseEntity.ok(ruleRepository.save(rule));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRule(@PathVariable String id) {
        return ruleRepository.findById(id)
                .map(rule -> {
                    ruleRepository.delete(rule);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
