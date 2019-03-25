import org.junit.Assert;
import org.junit.Test;
import ru.eltex.phonebook.DataBase;
import ru.eltex.phonebook.SqlBase;
import ru.eltex.phonebook.User;

public class MyTests {

    @Test
    public void testUserAdd(){

        int expectedId = 0;
        User user1 = new User(expectedId, "Marina", "8927364527");

        Assert.assertEquals(expectedId, user1.getId());

        String expectedName = "Marina";
        User user2 = new User(expectedName,"123456789");

        Assert.assertEquals(expectedName, user2.getName());

        String expectedNPhone = "83746536458";
        User user3 = new User("Marina", expectedNPhone);

        Assert.assertEquals(expectedNPhone, user3.getPhoneNumber());
    }

    @Test
    public void testUserNullParams(){
        try {
            new User(null, "84576384756");

            Assert.fail("Must to be failed if field 'name' is null");
        }catch (NullPointerException e){}

        try {
            new User("Fedor", null);

            Assert.fail("Must to be failed if field 'phoneNumber' is null");
        }catch (NullPointerException e){}
        try {
            Integer id = null;
            new User(id,"Denis", "84576384756");

            Assert.fail("Must to be failed if field 'id' is null");
        }catch (NullPointerException e){}
    }

    @Test
    public void testUserParamsEmpty(){
        try {
            new User("", "84576384756");

            Assert.fail("Must to be failed if field 'name' is empty");
        }catch (IllegalArgumentException e){}

        try {
            new User("Fedor", "");

            Assert.fail("Must to be failed if field 'phoneNumber' is empty");
        }catch (IllegalArgumentException e){}
    }

    @Test
    public void testSqlBd(){
        DataBase dataBase = new SqlBase();

        int id = 20;
        String name = "Marina";
        String phone = "8348738437";

        User user = new User(id, name, phone);
        dataBase.addUser(user);

        Assert.assertEquals(true, dataBase.getAllUsers().stream()
                .filter(x -> x.getId() == id && x.getName().equals(name)).findFirst().isPresent());

        dataBase.deleteUserById(id);

        Assert.assertEquals(false, dataBase.getAllUsers().stream()
                .filter(x -> x.getId() == id && x.getName().equals(name)).findFirst().isPresent());
    }

    @Test
    public void failTestUser(){
        User user = new User(13, "NOna", "2323323323");
        Assert.assertEquals(1234, user.getId());
    }
}
