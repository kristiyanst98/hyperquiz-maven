package hyperquiz;

import hyperquiz.model.Gender;
import hyperquiz.model.Role;
import hyperquiz.model.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
//        Quiz quiz = new Quiz();
//        Quiz quiz2 = new Quiz();
//        User user = new User();
//        user.setUsername("Georgi Ivanov");
//        quiz.setAuthor(user);
//        quiz.setDescription("Easy one");
//        quiz.setExpectedDuration(1);
//        quiz.setId(1L);
//        quiz.setTitle("Easy");
//        User user2=new User();
//        user2.setUsername("John Doe");
//        quiz2.setAuthor(user2);
//        quiz2.setDescription("Getting complicated");
//        quiz2.setId(2L);
//        quiz2.setTitle("Medium");

//        QuizRepository quizRepository = new QuizRepositoryImpl(new LongKeyGenerator());
//        UserRepository userRepository = new UserRepositoryMemoryImpl(new LongKeyGenerator());
//        String quizReport = PrintUtil.formatTable(quizColumns, Arrays.asList(quizz), "Quiz List:");
//        System.out.println(quizReport);
//        MenuUtil.printMenu();


       String path = Main.class.getClassLoader().getResource("database.properties").getPath();
       Properties props = new Properties();
       props.load(new FileInputStream(path));

        try{
            Class.forName(props.getProperty("db.driver"));
            System.out.println("DB driver loaded");
        }catch (ClassNotFoundException e) {
            System.out.println("DB Driver not found");
            e.printStackTrace();
            return;
        }

            try(Connection connection = DriverManager.getConnection(props.getProperty("db.url"),props)){
                System.out.printf("Successfully connected to: %s%n",props.getProperty("db.url"));
                //4. Prepare statement
                PreparedStatement statement= connection.prepareStatement("SELECT * FROM users");
                ResultSet results = statement.executeQuery();
                while(results.next()){
                    User user = new User(results.getLong("id"),results.getString("username"),results.getString("email"),results.getString("password"),Gender.valueOf(results.getString("gender")), Role.valueOf(results.getString("role")),results.getURL("picture"),results.getString("description"),results.getString("metadata"),results.getBoolean("status"));
                    System.out.println(user.forDB());

                }
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }


    }
}
