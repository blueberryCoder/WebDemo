DROP TABLE IF EXISTS TEST;

CREATE TABLE TEST (
  test_id INT IDENTITY,
  NAME    VARCHAR(255),
  PRIMARY KEY (test_id)
);

DROP TABLE IF EXISTS Spitter;

/**
  private Long id;

    @NotNull
    @Size(min = 5, max = 16)
    private String username;
    @NotNull
    @Size(min = 5, max = 25)
    private String password;
    @NotNull
    @Size(min = 2, max = 30)
    private String firstName;
    @NotNull
    @Size(min = 2, max = 30)
    private String lastName;
 */
CREATE TABLE SPITTER (
  id        INT IDENTITY,
  username  VARCHAR(255),
  password  VARCHAR(255),
  firstName VARCHAR(255),
  lastName  VARCHAR(255),
  PRIMARY KEY (id)
)