package com.example.backend;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@EnableMongoRepositories
public class KanbanService {
    private final KanbanRepository kanbanRepository;

    public KanbanService(KanbanRepository kanbanRepository) {
        this.kanbanRepository = kanbanRepository;
    }

    public KanbanEntry addEntry(NewEntry newEntry) {
        KanbanEntry entryToAdd = new KanbanEntry(
                UUID.randomUUID().toString(),
                newEntry.description(),
                newEntry.status()
        );
        return kanbanRepository.save(entryToAdd);
    }

    public List<KanbanEntry> getEntries() {
        return kanbanRepository.findAll();
    }

    public KanbanEntry changeStatus (KanbanEntry entry) {
        kanbanRepository.save(entry);
        return entry;
    }
    public void deleteEntry (String id) {
        kanbanRepository.delete(kanbanRepository.findById(id).orElseThrow());
    }

    public KanbanEntry entry (String id) {
        return kanbanRepository.findById(id).orElseThrow();
    }
}
