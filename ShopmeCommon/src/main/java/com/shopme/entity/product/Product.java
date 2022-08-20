package com.shopme.entity.product;

import com.shopme.entity.Brand;
import com.shopme.entity.Category;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tbl_products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, length = 255, nullable = false)
  private String name;

  @Column(unique = true, length = 255, nullable = false)
  private String alias;

  @Column(length = 512, nullable = false, name = "short_description")
  private String shortDescription;

  @Column(length = 4096, nullable = false, name = "full_description")
  private String fullDescription;

  @Column(name = "created_time")
  @Temporal(TemporalType.TIMESTAMP)
  @CreationTimestamp
  private Date createTime;

  @Column(name = "updated_time")
  @Temporal(TemporalType.TIMESTAMP)
  @UpdateTimestamp
  private Date updateTime;

  private boolean enabled;

  @Column(name = "in_stock")
  private boolean inStock;

  private BigDecimal cost;

  private BigDecimal price;

  @Column(name = "discount_percent")
  private BigDecimal discountPercent;

  private float length;

  private float width;

  private float height;

  private float weight;

  @Column(name = "main_image", nullable = false)
  private String mainImage;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;

  @ManyToOne
  @JoinColumn(name = "brand_id")
  private Brand brand;

  @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<ProductImage> productImages = new HashSet<>();

  @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<ProductDetail> details = new ArrayList<>();

  private int reviewCount;

  private float averageRating;
}
