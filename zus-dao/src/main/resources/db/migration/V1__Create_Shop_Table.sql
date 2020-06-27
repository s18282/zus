CREATE TABLE USER
(
    id                  BIGINT AUTO_INCREMENT           NOT NULL,
    name                VARCHAR(255)                    NOT NULL,
    password            VARCHAR(255)                    NOT NULL,
    active              BOOLEAN                         NOT NULL,

    CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE TABLE FILE_STATUS
(
    id                  BIGINT AUTO_INCREMENT           NOT NULL,
    name                VARCHAR(30)                     NOT NULL,

    CONSTRAINT pk_file_status PRIMARY KEY (id)
);
