package com.hiephoafarm.main.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "product", schema = "hiephoafarm", catalog = "")
public class ProductE {
   private int idProduct;
   private String productName;
   private String description;
   private int productPrice;
   private String saleUnit;
   private Collection<GalleryE> galleriesByIdProduct;
   private Collection<OrderDetailE> orderDetailsByIdProduct;
   private CategoryE categoryByCategoryId;
   private StatusE statusByStatusId;
   private Timestamp createdTime;

   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Id
   @Column(name = "id_product", nullable = false)
   public int getIdProduct() {
      return idProduct;
   }

   public void setIdProduct(int idProduct) {
      this.idProduct = idProduct;
   }

   @Basic
   @Column(name = "product_name", nullable = false, length = 150)
   public String getProductName() {
      return productName;
   }

   public void setProductName(String productName) {
      this.productName = productName;
   }

   @Basic
   @Column(name = "description", nullable = false, length = -1)
   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   @Basic
   @Column(name = "product_price", nullable = false)
   public int getProductPrice() {
      return productPrice;
   }

   public void setProductPrice(int productPrice) {
      this.productPrice = productPrice;
   }

   @Basic
   @Column(name = "sale_unit", nullable = true, length = 45)
   public String getSaleUnit() {
      return saleUnit;
   }

   public void setSaleUnit(String saleUnit) {
      this.saleUnit = saleUnit;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      ProductE productE = (ProductE) o;
      return idProduct == productE.idProduct && productPrice == productE.productPrice && Objects.equals(productName, productE.productName) && Objects.equals(description, productE.description) && Objects.equals(saleUnit, productE.saleUnit);
   }

   @Override
   public int hashCode() {
      return Objects.hash(idProduct, productName, description, productPrice, saleUnit);
   }

   @JsonManagedReference
   @OneToMany(mappedBy = "productByProductId")
   public Collection<GalleryE> getGalleriesByIdProduct() {
      return galleriesByIdProduct;
   }

   public void setGalleriesByIdProduct(Collection<GalleryE> galleriesByIdProduct) {
      this.galleriesByIdProduct = galleriesByIdProduct;
   }

   @JsonManagedReference
   @OneToMany(mappedBy = "productByProductId")
   public Collection<OrderDetailE> getOrderDetailsByIdProduct() {
      return orderDetailsByIdProduct;
   }

   public void setOrderDetailsByIdProduct(Collection<OrderDetailE> orderDetailsByIdProduct) {
      this.orderDetailsByIdProduct = orderDetailsByIdProduct;
   }

   @JsonBackReference
   @ManyToOne
   @JoinColumn(name = "category_id", referencedColumnName = "id_category", nullable = false)
   public CategoryE getCategoryByCategoryId() {
      return categoryByCategoryId;
   }

   public void setCategoryByCategoryId(CategoryE categoryByCategoryId) {
      this.categoryByCategoryId = categoryByCategoryId;
   }

   @JsonBackReference
   @ManyToOne
   @JoinColumn(name = "status_id", referencedColumnName = "id_status", nullable = false)
   public StatusE getStatusByStatusId() {
      return statusByStatusId;
   }

   public void setStatusByStatusId(StatusE statusByStatusId) {
      this.statusByStatusId = statusByStatusId;
   }

   @Basic
   @Column(name = "created_time", nullable = true)
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ss:mm:HH dd/MM/yyyy")
   public Timestamp getCreatedTime() {
      return createdTime;
   }

   public void setCreatedTime(Timestamp createdTime) {
      this.createdTime = createdTime;
   }
}
