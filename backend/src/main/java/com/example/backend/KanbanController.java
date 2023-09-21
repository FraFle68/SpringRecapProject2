package com.example.backend;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class KanbanController {
    private final KanbanService kanbanService;

    public KanbanController(KanbanService kanbanService) {
        this.kanbanService = kanbanService;
    }

    @GetMapping("/todo")
    public List<KanbanEntry> readEntries() {

        return kanbanService.getEntries();
    }

    @GetMapping("/todo/{id}")
    public KanbanEntry getEntry (@PathVariable String id) {
        return kanbanService.entry(id);
    }

    @PostMapping("/todo")
    public KanbanEntry addEntry(@RequestBody NewEntry newEntry) {
        return kanbanService.addEntry(newEntry);
    }

    @PutMapping("/todo/{id}")
    public KanbanEntry changeStatus(@RequestBody KanbanEntry entry) {
        return kanbanService.changeStatus(entry);
    }

    @DeleteMapping("/todo/{id}")
    public void deleteEntry(@PathVariable String id) {
        kanbanService.deleteEntry(id);
    }
}
