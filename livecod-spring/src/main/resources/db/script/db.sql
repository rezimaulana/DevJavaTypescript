CREATE TABLE tb_book(
	id SERIAL,
	code VARCHAR(10) NOT NULL,
	title TEXT NOT NULL,
	description TEXT NOT NULL
);
ALTER TABLE tb_book ADD CONSTRAINT book_pk PRIMARY KEY(id);
ALTER TABLE tb_book ADD CONSTRAINT book_bk UNIQUE(code);

CREATE TABLE tb_author(
	id SERIAL,
	email TEXT NOT NULL,
	fullname TEXT NOT NULL,
	address TEXT NOT NULL
);
ALTER TABLE tb_author ADD CONSTRAINT author_pk PRIMARY KEY(id);
ALTER TABLE tb_author ADD CONSTRAINT author_bk UNIQUE(email);

CREATE TABLE tb_library(
	id SERIAL,
	book_id INT NOT NULL,
	author_id INT NOT NULL,
	stock INT DEFAULT 0 NOT NULL,
	price FLOAT DEFAULT 0 NOT NULL,
	created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL
);
ALTER TABLE tb_library ADD CONSTRAINT library_pk PRIMARY KEY(id);
ALTER TABLE tb_library ADD CONSTRAINT library_book_fk FOREIGN KEY(book_id) REFERENCES tb_book(id);
ALTER TABLE tb_library ADD CONSTRAINT library_author_fk FOREIGN KEY(author_id) REFERENCES tb_author(id);
ALTER TABLE tb_library ADD CONSTRAINT library_ck UNIQUE(book_id, author_id);

INSERT INTO tb_author(id, email, fullname, address) VALUES
(1, 'rsazrm@gmail.com', 'Maulana Rezi', 'Jalan Antapani 32');

INSERT INTO tb_book(id, code, title, description) VALUES
(1, 'BOOK-THB12', 'Algoritma', 'Algoritma Masa Kini');

INSERT INTO tb_library(book_id, author_id, stock, price, created_at) VALUES
(1, 1, 10, 143500, NOW());