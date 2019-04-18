CREATE TABLE IF NOT EXISTS Postings (
    id UUID PRIMARY KEY,
    imageURL TEXT,
    CompanyName TEXT,
    JobPosition TEXT,
    Location TEXT,
    PostDate TEXT,
    Industry TEXT,
    EmploymentType TEXT,
    JobFunction TEXT,
    Description TEXT
);