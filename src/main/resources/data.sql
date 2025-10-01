-- Categories
INSERT INTO categories (id, name, slug) VALUES (1, 'Fiction', 'fiction');
INSERT INTO categories (id, name, slug) VALUES (2, 'Non-Fiction', 'non-fiction');
INSERT INTO categories (id, name, slug) VALUES (3, 'Programming', 'programming');

-- Books
INSERT INTO books (id, title, author, price, currency, isbn, description, stock, image_url) VALUES
(1, 'Clean Code', 'Robert C. Martin', 34.99, 'EUR', '9780132350884', 'A Handbook of Agile Software Craftsmanship.', 12, 'https://covers.openlibrary.org/b/isbn/9780132350884-L.jpg'),
(2, 'Effective Java', 'Joshua Bloch', 44.90, 'EUR', '9780134685991', 'Best practices for the Java platform.', 8, 'https://covers.openlibrary.org/b/isbn/9780134685991-L.jpg'),
(3, 'The Pragmatic Programmer', 'Andrew Hunt, David Thomas', 39.50, 'EUR', '9780201616224', 'Journey to mastery.', 10, 'https://covers.openlibrary.org/b/isbn/9780201616224-L.jpg'),
(4, 'Where the Crawdads Sing', 'Delia Owens', 12.99, 'EUR', '9780735219106', 'Novel.', 20, 'https://picsum.photos/seed/fiction1/300/450'),
(5, 'Sapiens', 'Yuval Noah Harari', 18.99, 'EUR', '9780099590088', 'Brief History of Humankind.', 15, 'https://picsum.photos/seed/nonfiction1/300/450'),
(6, 'Angular in Action', 'Jeremy Wilken', 42.00, 'EUR', '9781617293313', 'Angular practical guide.', 6, 'https://picsum.photos/seed/programming1/300/450');

-- Book-category links
INSERT INTO book_category (book_id, category_id) VALUES
(1,3), (2,3), (3,3), (6,3),     -- programming
(4,1),                          -- fiction
(5,2);                          -- non-fiction

