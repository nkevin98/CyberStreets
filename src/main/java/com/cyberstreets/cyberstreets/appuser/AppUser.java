package com.cyberstreets.cyberstreets.appuser;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class AppUser implements UserDetails {


    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String creditCard;
    private String driversLicense;
    private String driversLicensePlate;
    private String carMake;
    private String carModel;
    private String carYear;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    private Boolean locked = false;
    private Boolean enabled = false;

    public AppUser(String firstName,
                   String lastName,
                   String email,
                   String password,
                   String creditCard,
                   String phoneNumber,
                   String driversLicense,
                   String driversLicensePlate,
                   String carMake,
                   String carModel,
                   String carYear,
                   AppUserRole appUserRole) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.creditCard = creditCard;
        this.phoneNumber= phoneNumber;
        this.driversLicense = driversLicense;
        this.driversLicensePlate = driversLicensePlate;
        this.carMake = carMake;
        this.carModel = carModel;
        this.carYear = carYear;
        this.appUserRole = appUserRole;

    }

  public AppUser(String firstName, String lastName, String email, String phoneNumber, String password, String creditCard, AppUserRole rider) {
  }

  public AppUser(String firstName, String lastName, String email, String password, String phoneNumber, String driversLicense, String driversLicensePlate, String carMake, String carModel, String carYear, AppUserRole driver) {
  }

  @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {

      return password;
    }

    @Override
    public String getUsername() {

      return email;
    }

    public String getFirstName() {

      return firstName;
    }

    public String getLastName() {

      return lastName;
    }

    public String getCreditCard() {

      return creditCard;
  }
  public String getPhoneNumber() {

    return phoneNumber;
  }

    public String getDriversLicense(){
      return driversLicense;
    }

    public String getDriversLicensePlate(){
      return driversLicensePlate;
    }

    public String getCarMake(){
      return carMake;
    }

    public String getCarModel(){
      return carModel;
    }

    public String getCarYear(){
      return carYear;
    }



    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
