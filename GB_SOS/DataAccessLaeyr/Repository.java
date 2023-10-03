package GB_SOS.DataAccessLaeyr;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Repository
 */
public class Repository {

    DB storage;

    public Repository(String dbPath) {
        this.storage = new DB(dbPath);
    }

    /**
     * @param groupId
     * @return return id of the first robot in group
     */
    public int getUserId(int groupId) throws DBException{
        String line;
        try (RandomAccessFile table = this.storage.selectFrom("group")){
            while ((line = table.readLine()) != null) {
                if (line.matches(String.format("^\\{\"id\": %d.*", groupId)))
                    return Integer.parseInt(line.split(", ")[1].replaceAll("\\D", ""));
            }
            return -1;
        } catch (DBException db) {
            throw db;
        } catch (IOException io) {
            throw new DBException("Have not access to this table.");
        }
    }

    /**
     * @param robotId
     * @return return json string of the robot DTO
     */
    public String getRobot(int robotId) throws DBException{
        String line;
        try (RandomAccessFile table = this.storage.selectFrom("robot")) {
            while ((line = table.readLine()) != null) {
                if (line.matches(String.format("^\\{\"id\": %d.*", robotId)))
                    return line;
            }
            throw new DBException("Have not this one.");
        } catch (DBException db) {
            throw db;
        } catch (IOException io) {
            throw new DBException("Have not access to this table.");
        }
    }

    /**
     * Function add new robot to database by unique serial number and assigns a id
     * @param robotDTO: json string w/o id
     * @return if added to db return true
     * @throws DBException
     */
    public boolean addRobot(String robotDTO) throws DBException{
        String line;
        int id = 0;
        try (RandomAccessFile table = this.storage.insertInto("robot")) {
            int serial = Integer.parseInt(robotDTO.split(" ")[1].replaceAll("\\D", ""));
            while ((line = table.readLine()) != null) {
                if (line.matches(String.format("^\\{\"id\": \\d+, \"serialNumber\": %d.*", serial)))
                    throw new DBException("Have this one.");
                else
                    id = Integer.parseInt(line.split(" ")[1].replaceAll("\\D", ""));
            }
            id += 1;
            table.write(String.format("{\"id\": %d, %s", id, robotDTO.replaceFirst("\\{", "")).getBytes());
            table.write('\n');
            return true;
        } catch (DBException db) {
            throw db;
        } catch (NumberFormatException | IOException e) {
            System.err.println(e.getMessage());
            throw new DBException("Have not access to this table.");
        }
    }

    public boolean addUserToGroup(String groupDTO) throws DBException{
        char separ = ',';
        String[] data = groupDTO.split(String.valueOf(separ));
        data[0] = data[0].replace("{", "\\{");
        data[0] = data[0].replace("\"", "\\\"");
        String line;
        try (RandomAccessFile table = this.storage.insertInto("group")) {
            if (table.length() != 0) {
                while ((line = table.readLine()) != null) {
                    String[] lines = line.split(",");
                    if (lines[0].matches(data[0])) {
                        table.seek(table.getFilePointer() - 2);
                        table.write(separ);
                        table.write(data[1].getBytes());
                        table.write('\n');
                        return true;
                    }
                }
            }
            table.write(groupDTO.getBytes());
            table.write('\n');
            return true;
        } catch (DBException db) {
            throw db;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            throw new DBException("Have not access to this table.");
        }
    }
}