package GB_SOS.DataAccessLaeyr;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;

public class DB {
    private String dbPath;
    private File dbFolder;
    private HashMap<String, File> tables;
    private String[] entities = {"user", "group", "schedule", "robot"};

    public DB(String path) {
        this.dbPath = path;
        this.dbFolder = new File(dbPath);
        System.out.println("Database initialization...");
        if(!this.dbFolder.exists()) {
            this.dbFolder.mkdir();
        } else System.out.println("Database o.k.");
        this.tables = new HashMap<>(entities.length);
        for (String string : entities) {
            String filePath = String.format("%s/%s", this.dbPath, string);
            this.tables.put(filePath, new File(filePath));
            try {
                if (this.tables.get(filePath).createNewFile())
                    System.out.println(String.format("Table: %s created.", filePath));
            } catch (Exception e) {
                System.err.println("Have not access to this storage.");
                System.err.println(e.getMessage());
            }
        }
    }

    public RandomAccessFile insertInto(String table) throws DBException{
        String filePath = String.format("%s/%s", this.dbPath, table);
        try {
            return 
                new RandomAccessFile(this.tables.get(filePath), "rw");
        } catch (IOException io) {
            throw new DBException("Cant write this table.");
        }
    }

    public RandomAccessFile selectFrom(String table) throws DBException{
        String filePath = String.format("%s/%s", this.dbPath, table);
        try {
            return 
                new RandomAccessFile(this.tables.get(filePath), "r");
        } catch (IOException io) {
            throw new DBException("Cant read this table.");
        }
    }
}
