CREATE TABLE BoardList (
  Id BIGINT NOT NULL PRIMARY KEY,
  ListName VARCHAR(50) NOT NULL,
  Status INT NOT NULL
);

CREATE TABLE BoardListItem (
  Id BIGINT NOT NULL,
  ListId BIGINT NOT NULL,
  Description VARCHAR(255) NOT NULL,
  Status INT NOT NULL,
  PRIMARY KEY (ID),
  FOREIGN KEY (ListID) REFERENCES BoardList(ID)
);