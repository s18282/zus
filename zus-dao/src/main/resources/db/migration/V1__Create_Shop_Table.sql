CREATE TABLE USER
(
    id                  BIGINT AUTO_INCREMENT           NOT NULL,
    name                VARCHAR(255)                    NOT NULL,
    password            VARCHAR(255)                    NOT NULL,
    active              BOOLEAN                         NOT NULL,
    user_status         BIGINT                          NOT NULL,

    CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE TABLE FILE
(
    id                  BIGINT AUTO_INCREMENT           NOT NULL,
    url                 VARCHAR(255)                    NOT NULL,

    CONSTRAINT pk_file  PRIMARY KEY (id)
);

CREATE TABLE WORKFLOW_STEP
(
    id                  BIGINT AUTO_INCREMENT           NOT NULL,
    date                DATETIME                        NOT NULL,
    file_status         BIGINT                          NOT NULL,
    file_id             BIGINT                          NOT NULL,
    user_id             BIGINT                          NOT NULL,

    CONSTRAINT pk_workflow_step PRIMARY KEY (id),
    FOREIGN KEY (file_id)       REFERENCES FILE (id),
    FOREIGN KEY (user_id)       REFERENCES USER (id)
);
