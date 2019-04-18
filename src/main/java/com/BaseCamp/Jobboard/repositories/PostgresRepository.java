package com.BaseCamp.Jobboard.repositories;

import com.BaseCamp.Jobboard.Models.Postings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PostgresRepository {

    private static JdbcTemplate jdbc;

    @Autowired
    public PostgresRepository(JdbcTemplate jdbctemplate) {
        jdbc = jdbctemplate;
    }

    public void savePost(Postings postings) {
        postings.id = UUID.randomUUID();

        jdbc.update("INSERT INTO Postings (id, imageURL, CompanyName, JobPosition, Location, PostDate, Industry, EmploymentType, JobFunction, Description) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", postings.id, postings.imageURL,
                postings.CompanyName, postings.JobPosition, postings.Location, postings.PostDate, postings.Industry, postings.EmploymentType, postings.JobFunction, postings.Description);
    }
    public Optional<Postings> findById(UUID id) {
        return Optional.ofNullable(jdbc.queryForObject("SELECT id, imageURL, CompanyName, JobPosition, Location, PostDate, Industry, EmploymentType, JobFunction, Description FROM Postings WHERE id= ?",
                this::mapRowToStory, id));
    }
    public List<Postings> findAll() {
        return jdbc.query("SELECT id, imageURL, CompanyName, JobPosition, Location, PostDate, Industry, EmploymentType, JobFunction, Description FROM Postings", this::mapRowToStory);
    }

    private Postings mapRowToStory(ResultSet rs, int rowNum) throws SQLException {
        return new Postings(UUID.fromString(rs.getString("id")), rs.getString("imageURL"), rs.getString("CompanyName"),
                rs.getString("JobPosition"), rs.getString("Location"), rs.getString("PostDate"), rs.getString("Industry"), rs.getString("EmploymentType"), rs.getString("JobFunction"), rs.getString("Description"));
    }
}


