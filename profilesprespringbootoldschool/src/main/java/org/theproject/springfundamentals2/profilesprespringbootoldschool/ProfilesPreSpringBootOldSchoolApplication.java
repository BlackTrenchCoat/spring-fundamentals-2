package org.theproject.springfundamentals2.profilesprespringbootoldschool;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProfilesPreSpringBootOldSchoolApplication {

    public static void main(String args[]) throws SQLException {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
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
