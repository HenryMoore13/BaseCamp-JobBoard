package com.BaseCamp.Jobboard.Models;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.StringReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;
@Data
@RequiredArgsConstructor

public class Postings {
    public UUID id;

    public String imageURL;
    @NotNull
    public String CompanyName;
    @NotNull
    public String JobPosition;
    @NotNull
    public String Location;
    @NotNull
    public String PostDate;
    @NotNull
    public String Industry;
    @NotNull
    public String EmploymentType;
    @NotNull
    public String JobFunction;
    @NotNull
    public String Description;


//    public void getPostDate(Date dateString) {
//
//        try {
//            String pattern = "yyyy-MM-dd";
//            DateFormat df = new SimpleDateFormat(pattern);
//            Date today = df.parse(String.valueOf(dateString));
//
//            PostDate = today;
//        } catch (ParseException ex) {
//            ex.printStackTrace();
//        }
//
//    }
    public Postings(UUID id, String imageURL, String CompanyName, String JobPosition, String Location, String PostDate, String Industry, String EmploymentType, String JobFunction, String Description) {
        String pattern = "MM-dd-yyyy";
        String dateInString = new SimpleDateFormat(pattern).format(new Date());
        this.id = id;
        this.imageURL = imageURL;
        this.CompanyName = CompanyName;
        this.JobPosition = JobPosition;
        this.Location = Location;
        this.PostDate = dateInString;
        this.Industry = Industry;
        this.EmploymentType = EmploymentType;
        this.JobFunction = JobFunction;
        this.Description = Description;
    }
    public String[] line(String text) {
        return text.split("\n");
    }

}
