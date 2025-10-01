package be.bookstore.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "books")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=200)
    private String title;

    @Column(nullable=false, length=150)
    private String author;

    @Column(precision=10, scale=2, nullable=false)
    private BigDecimal price;

    @Column(nullable=false, length=3)
    private String currency;

    @Column(length=20)
    private String isbn;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Integer stock;

    @Column(name="image_url", length=500)
    private String imageUrl;

    @ManyToMany
    @JoinTable(
            name = "book_category",
            joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name="category_id")
    )
    private Set<Category> categories;
}