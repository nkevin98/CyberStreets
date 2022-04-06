package com.cyberstreets.cyberstreets.registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final String phoneNumber;
    private final String creditCard;
    private final String driversLicense;
    private final String driversLicensePlate;
    private final String carMake;
    private final String carModel;
    private final String carYear;


}
