package org.theproject.springfundamentals2.profilesprespringbootconditionalbeancreation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProfilesPreSpringBootConditionalBeanCreationApplication {

    public static void main(String args[]) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DatabaseConfiguration.class);

        DataSource dataSource = context.getBean(DataSource.class);
        int numberOfRecords = getNumberOfRecords(dataSource);
        System.out.println("There are " + numberOfRecords + " books");
    }

    private static int getNumberOfRecords(DataSource dataSource) throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select count(*) from book");
        resultSet.next();
        return resultSet.getInt(1);
    }


}
