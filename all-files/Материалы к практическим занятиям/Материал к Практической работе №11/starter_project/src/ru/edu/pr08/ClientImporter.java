package ru.edu.pr08;
import java.nio.file.*; import java.io.*; import java.util.*;
public class ClientImporter {
 private final ClientCsvParser parser=new ClientCsvParser(); private final ClientValidator validator=new ClientValidator(); private final ClientRepository repository;
 public ClientImporter(ClientRepository r){repository=r;}
 public ImportResult importFile(Path path) throws IOException { /* TODO 3 */ return new ImportResult(); }
}
