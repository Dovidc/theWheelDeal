package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techelevator.security.model.Authority;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class User {

   private int id;
   private String username;
   @NotNull
   @NotBlank(message =  "First name is required")
   private String firstName;
   @NotNull
   @NotBlank(message =  "Last name is required")
   private String lastName;
   @JsonIgnore
   private String password;

   @JsonIgnore
   private boolean activated;
   private Set<Authority> authorities = new HashSet<>();
   @NotNull
   @NotBlank(message = "Email address is required")
   private String email;
   @NotNull
   @NotBlank(message = "Phone Number is required")
   private String phoneNumber;

   private List<Vehicle> vehicle;
   private List<WorkOrder> workOrder;
   private List<Invoice> invoice;

   public User() { }

   public User(int id, String username, String firstName, String lastName, String password, long passwordHash, boolean activated, Set<Authority> authorities, String email, String phoneNumber, List<Vehicle> vehicle, List<WorkOrder> workOrder, List<Invoice> invoice) {
      this.id = id;
      this.username = username;
      this.firstName = firstName;
      this.lastName = lastName;
      this.password = password;
      this.activated = activated;
      this.authorities = authorities;
      this.email = email;
      this.phoneNumber = phoneNumber;
      this.vehicle = vehicle;
      this.workOrder = workOrder;
      this.invoice = invoice;

      if (authorities != null) this.setAuthorities(authorities);
      this.activated = true;
   }
   

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public boolean isActivated() {
      return activated;
   }

   public void setActivated(boolean activated) {
      this.activated = activated;
   }

   public Set<Authority> getAuthorities() {
      return authorities;
   }

   public void setAuthorities(Set<Authority> authorities) {
      this.authorities = authorities;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }


   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPhoneNumber() {
      return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   public List<Vehicle> getVehicle() {
      return vehicle;
   }

   public void setVehicle(List<Vehicle> vehicle) {
      this.vehicle = vehicle;
   }

   public List<WorkOrder> getWorkOrder() {
      return workOrder;
   }

   public void setWorkOrder(List<WorkOrder> workOrder) {
      this.workOrder = workOrder;
   }

   public List<Invoice> getInvoice() {
      return invoice;
   }

   public void setInvoice(List<Invoice> invoice) {
      this.invoice = invoice;
   }

   public void setAuthorities(String authorities) {
      String[] roles = authorities.split(",");
      for (String role : roles) {
         String authority = role.contains("ROLE_") ? role : "ROLE_" + role;
         this.authorities.add(new Authority(authority));
      }
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      User user = (User) o;
      return id == user.id &&
              activated == user.activated &&
              Objects.equals(username, user.username) &&
              Objects.equals(password, user.password) &&
              Objects.equals(authorities, user.authorities);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, username, password, activated, authorities);
   }

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", username='" + username + '\'' +
              ", activated=" + activated +
              ", authorities=" + authorities +
              '}';
   }
}
