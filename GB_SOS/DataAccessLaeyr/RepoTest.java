package GB_SOS.DataAccessLaeyr;

import org.junit.*;

public class RepoTest {

    @Test
    public void haveNotThisUserTest() {
        Repository repo = new Repository("gb-sos-db");
        try {
            Assert.assertEquals(-1, repo.getUserId(12));
        } catch (DBException db) {
            Assert.assertEquals("Cant write this table.", db.getMessage());
        }
    }

    @Test
    public void addRobotTest() {
        Repository repo = new Repository("gb-sos-db");
        String robotDTO = "{\"serialNumber\": 987654321, \"version\": \"1.0\", \"name\": \"Vasia\", \"lastStart\": \"11.07.2019\", \"resource\": 12345, \"ip\": \"192.168.0.11\", \"group\": 12}";
        try {
            Assert.assertEquals(true, repo.addRobot(robotDTO));
        } catch (DBException db) {
            Assert.assertEquals("Cant write this table.", db.getMessage());
        }
    }

    @Test(expected = DBException.class)
    public void adddoubleRobotTest() throws DBException {
        Repository repo = new Repository("gb-sos-db");
        String robotDTO = "{\"serialNumber\": 987654321, \"version\": \"1.0\", \"name\": \"Vasia\", \"lastStart\": \"11.07.2019\", \"resource\": 12345, \"ip\": \"192.168.0.11\", \"group\": 12}";
        repo.addRobot(robotDTO);
        repo.addRobot(robotDTO);
    }

    @Test
    public void getRobotTest() {
        Repository repo = new Repository("gb-sos-db");
        String robotDTO = "{\"id\": 1, \"serialNumber\": 987654321, \"version\": \"1.0\", \"name\": \"Vasia\", \"lastStart\": \"11.07.2019\", \"resource\": 12345, \"ip\": \"192.168.0.11\", \"group\": 12}";
        try {
            Assert.assertEquals(robotDTO, repo.getRobot(1));
        } catch (DBException db) {
            Assert.assertEquals("Have not this one.", db.getMessage());
        }
    }
}
