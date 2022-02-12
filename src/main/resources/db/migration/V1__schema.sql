CREATE TABLE author (
    id SERIAL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_author_id PRIMARY KEY (id)
);

CREATE TABLE account (
    id SERIAL,
    name VARCHAR(255) NOT NULL,
    password VARCHAR (255) NOT NULL,
    active BOOLEAN NOT NULL,
    CONSTRAINT pk_account_id PRIMARY KEY (id)
);

CREATE TABLE book (
    id SERIAL,
    title VARCHAR(255) NOT NULL,
    genre VARCHAR (255) NOT NULL,
    year SMALLINT NOT NULL,
    description VARCHAR NOT NULL,
    quantity SMALLINT NOT NULL,
    free BOOLEAN NOT NULL,
    CONSTRAINT pk_book_id PRIMARY KEY (id)
);

CREATE TABLE reader (
    id SERIAL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    reader_number INTEGER NOT NULL,
    phone_number INTEGER NOT NULL,
    rating SMALLINT NOT NULL,
    registration_date DATE NOT NULL,
    CONSTRAINT pk_reader_id PRIMARY KEY (id)
);

CREATE TABLE record (
    id SERIAL,
    book_id INTEGER NOT NULL,
    reader_id INTEGER NOT NULL,
    receipt_date DATE NOT NULL,
    return_date DATE NOT NULL,
    real_return_date DATE,
    CONSTRAINT fk_record_book_id FOREIGN KEY (book_id) REFERENCES book (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_record_reader_id FOREIGN KEY (reader_id) REFERENCES reader (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT pk_record_id PRIMARY KEY (id)
);

CREATE TABLE role (
    id SERIAL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_role_id PRIMARY KEY (id),
    CONSTRAINT uk_role_name UNIQUE (name)
);

CREATE TABLE author_book (
    id SERIAL,
    author_id INTEGER NOT NULL,
    book_id INTEGER NOT NULL,
    CONSTRAINT pk_author_book_id PRIMARY KEY (id),
    CONSTRAINT fk_author_book_author_id FOREIGN KEY (author_id) REFERENCES author (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_author_book_book_id FOREIGN KEY (book_id) REFERENCES book (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE account_role (
    id SERIAL,
    account_id INTEGER NOT NULL,
    role_id INTEGER NOT NULL,
    CONSTRAINT pk_account_role_id PRIMARY KEY (id),
    CONSTRAINT fk_account_role_account_id FOREIGN KEY (account_id) REFERENCES account (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_account_role_role_id FOREIGN KEY (role_id) REFERENCES role (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE account_book (
    id SERIAL,
    account_id INTEGER NOT NULL,
    book_id INTEGER NOT NULL,
    CONSTRAINT pk_account_book_id PRIMARY KEY (id),
    CONSTRAINT fk_account_book_account_id FOREIGN KEY (account_id) REFERENCES account (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_account_book_book_id FOREIGN KEY (book_id) REFERENCES book (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE reader_book (
    id SERIAL,
    reader_id INTEGER NOT NULL,
    book_id INTEGER NOT NULL,
    CONSTRAINT pk_reader_book_id PRIMARY KEY (id),
    CONSTRAINT fk_reader_book_account_id FOREIGN KEY (reader_id) REFERENCES reader (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_reader_book_book_id FOREIGN KEY (book_id) REFERENCES book (id) ON DELETE CASCADE ON UPDATE CASCADE
);

