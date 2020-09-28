package org.theproject.springfundmentals2.profilesprespringboot;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProfilesprespringbootApplication {

    public static void main(String args[]) throws SQLException {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        ProfileBean profileBean = context.getBean(ProfileBean.class);

        String profile = profileBean.getProfile();
        System.out.println("Profile = " + profile);

        DataSource dataSource = context.getBean(DataSource.class);
        int numberOfRecords = getNumberOfRecords(dataSource);

        System.out.println("There are " + numberOfRecords + " books");
    }

    private static int getNumberOfRecords(DataSource dataSource) throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.prepareStatement("select count(*) from book");
        ResultSet resultSet = statement.getResultSet();
        int result = resultSet.getInt(1);
        return result;
    }

}
