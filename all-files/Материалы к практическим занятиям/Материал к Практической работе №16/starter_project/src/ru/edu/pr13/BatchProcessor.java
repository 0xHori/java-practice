package ru.edu.pr13;
import java.util.*; import java.util.concurrent.*;
public class BatchProcessor { private final DocumentProcessor processor; public BatchProcessor(DocumentProcessor p){processor=p;}
 public BatchResult processAll(List<Document> docs,int poolSize) { /* TODO 1  ExecutorService, Callable, Future, shutdown */ return new BatchResult(); }
}
